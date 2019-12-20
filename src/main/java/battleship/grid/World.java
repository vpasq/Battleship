package battleship.grid;

import battleship.characters.Observer;
import battleship.characters.Player;
import battleship.ships.Position;
import battleship.ships.Ship;
import java.util.ArrayList;
import java.util.Random;

public class World implements Observable {

  public enum Target { PLAYER1, PLAYER2 }

  protected enum ShipDirection { VERTICAL, HORIZONTAL }

  private int boardWidth;
  private int boardHeight;
  private int numShips;

  private Player player1;
  private Square[][] player1board;
  private String[][] ships1Grid;

  private Player player2;
  private Square[][] player2board;
  private String[][] ships2Grid;

  private ArrayList<Observer> observers;

  /**
   * Initialize the game board.
   *
   * @param width the width of the board.
   * @param height the height of the board.
   * @throws IllegalArgumentException Indicates width || height < 5
   * @postcondition All squares on this board, and both player's ships' grids, have been initialized
   *                to water marks.
   */
  public World(int width, int height, int numShips) throws IllegalArgumentException {
    if ((width < 5 || width > 25) || (height < 5 || height > 25)) {
      throw new IllegalArgumentException("width || height < 5 or width || height > 25 ");
    }
    this.numShips = numShips;
    player1board = new Square[width][height];
    player2board = new Square[width][height];
    ships1Grid = new String[width][height];
    ships2Grid = new String[width][height];
    this.boardWidth = width;
    this.boardHeight = height;
    observers = new ArrayList<Observer>();
    for (int row = 0; row < width; row += 1) {
      for (int col = 0; col < height; col += 1) {
        player1board[row][col] = new Square(row, col, SquareMark.WATER);
        player2board[row][col] = new Square(row, col, SquareMark.WATER);
        ships1Grid[row][col] = "-";
        ships2Grid[row][col] = "-";
      }
    }
  }

  /**
   * Modifier method for Player1.
   *
   * @param player1 has been initialized and set on the board.
   */
  public void setPlayer1(Player player1) {
    this.player1 = player1;
  }

  /**
   * Modifier method for Player2.
   *
   * @param player2 has been initialized and set on the board.
   */
  public void setPlayer2(Player player2) {
    this.player2 = player2;
  }

  /**
   * Accessor method for player1.
   *
   * @return the object, player1
   */
  public Player getPlayer1() {
    return player1;
  }

  /**
   * Accessor method for player2.
   *
   * @return the object, player2
   */
  public Player getPlayer2() {
    return player2;
  }

  /**
   * Set a square on player 1's board.
   *
   * @param posX the x coordinate of the square.
   * @param posY the y coordinate of the square.
   * @param marking the HIT, MISS, or WATER mark used on the game board.
   * @postcondition The square at coordinates, (posX, posY), on player1's board have been set to the
   *                parameter, marking.
   */
  public void setPlayer1Board(int posX, int posY, SquareMark marking) {
    player1board[posY][posX] = new Square(posX, posY, marking);
  }

  /**
   * Set a square on player 2's board.
   *
   * @param posX the x coordinate of the square.
   * @param posY the y coordinate of the square.
   * @param marking the HIT, MISS, or WATER mark used on the game board.
   * @postcondition The square at coordinates, (posX, posY), on player2's board have been set to the
   *                parameter, marking.
   */
  public void setPlayer2Board(int posX, int posY, SquareMark marking) {
    player2board[posY][posX] = new Square(posX, posY, marking);
  }

  /**
   * Display player1's game board.
   *
   * @postcondition player1's game board has been displayed.
   */
  public void displayPlayer1Board() {
    for (Square[] row : player1board) {
      for (Square col : row) {
        System.out.printf("%s ", col.getMarking());
      }
      System.out.println();
    }
    System.out.println();
  }

  /**
   * Display player2's game board.
   *
   * @postcondition player1's game board has been displayed.
   */
  public void displayPlayer2Board() {
    for (Square[] row : player2board) {
      for (Square col : row) {
        System.out.printf("%s ", col.getMarking());
      }
      System.out.println();
    }
    System.out.println();
  }

  /**
   * Display player1's ships' grid.
   *
   * @postcondition Player2's ships' grid has been displayed.
   */
  public void displayShip1Grid() {
    for (String[] row : ships1Grid) {
      for (String col : row) {
        System.out.printf("%s ", col);
      }
      System.out.println();
    }
    System.out.println();
  }

  /**
   * Display player2's ships' grid.
   *
   * @postcondition Player2's ships' grid has been displayed.
   */
  public void displayShip2Grid() {
    for (String[] row : ships2Grid) {
      for (String col : row) {
        System.out.printf("%s ", col);
      }
      System.out.println();
    }
    System.out.println();
  }

  /**
   * Modifier method for setting ship position.
   *
   * @param player the player for which their ship will be positioned.
   * @param shipNumber player's ship number.
   * @param direction the direction of player's ship.
   * @param pos player's ship's position..
   * @return true if successful, false otherwise.
   * @postcondition player's ship has been placed on game board.
   */
  public boolean setShip(Player player, int shipNumber, ShipDirection direction, Position pos) {
    Ship[] playerShips = player.getShips();
    int size = playerShips[shipNumber].getSize();

    String[][] shipsGrid = new String[boardWidth][boardHeight];
    if (player == player1) {
      shipsGrid = ships1Grid;
    } else if (player == player2) {
      shipsGrid = ships2Grid;
    }

    if (direction.equals(ShipDirection.VERTICAL)) {
      if (boardWidth - pos.getxCoordinate() >= size) {

        for (int i = 0; i < size; i += 1) {
          if (shipsGrid[pos.getxCoordinate() + i][pos.getyCoordinate()].equals("H")
              || shipsGrid[pos.getxCoordinate() + i][pos.getyCoordinate()].equals("V")) {
            return false;
          }
        }

        for (int j = 0; j < size; j += 1) {
          shipsGrid[pos.getxCoordinate() + j][pos.getyCoordinate()] = "V";
          Position tempPos = new Position(pos.getyCoordinate(), pos.getxCoordinate() + j);
          playerShips[shipNumber].setPositionArray(j, tempPos);
        }
      } else {
        return false;
      }
    }

    if (direction.equals(ShipDirection.HORIZONTAL)) {
      if (boardHeight - pos.getyCoordinate() >= size) {

        for (int i = 0; i < size; i += 1) {
          if (shipsGrid[pos.getxCoordinate()][pos.getyCoordinate() + i].equals("H")
              || shipsGrid[pos.getxCoordinate()][pos.getyCoordinate() + i].equals("V")) {
            return false;
          }
        }

        for (int j = 0; j < size; j += 1) {
          shipsGrid[pos.getxCoordinate()][pos.getyCoordinate() + j] = "H";
          Position tempPos = new Position(pos.getyCoordinate() + j, pos.getxCoordinate());
          playerShips[shipNumber].setPositionArray(j, tempPos);
        }
      } else {
        return false;
      }
    }
    return true;
  }

  /**
   * Modifier method for randomly setting ships' positions.
   *
   * @param player the player for which their ships will be randomly positioned on game board.
   * @postcondition ALl player's ships have been randomly placed on game board.
   */
  public void setShipsRandomly(Player player) {
    for (int shipNumber = 0; shipNumber < player.getNumberShips(); shipNumber += 1) {
      int direction = new Random().nextInt(2);
      ShipDirection randomDirection =
          (direction == 0) ? ShipDirection.HORIZONTAL : ShipDirection.VERTICAL;
      int randomXCoordinate = new Random().nextInt(boardWidth);
      int randomYCoordinate = new Random().nextInt(boardHeight);

      while (!setShip(player, shipNumber, randomDirection,
          new Position(randomXCoordinate, randomYCoordinate))) {
        randomXCoordinate = new Random().nextInt(5);
        randomYCoordinate = new Random().nextInt(5);

        if (randomDirection == ShipDirection.VERTICAL) {
          randomDirection = ShipDirection.HORIZONTAL;
        } else {
          randomDirection = ShipDirection.VERTICAL;
        }

      }
    }
  }

  /**
   * Check if missile was a HIT or MISS.
   *
   * @param missile the position of the missile target.
   * @param targetPlayer the player that is being fired upon.
   */
  public void verifyHit(Target targetPlayer, Position missile) {
    boolean hit = false;
    Ship[] ships = null;

    if (targetPlayer == Target.PLAYER1) {
      ships = getPlayer1().getShips();
    } else {
      ships = getPlayer2().getShips();
    }

    for (int i = 0; i < numShips; i++) {
      Position[] positionArray = ships[i].getPositionArray();

      int index = 0;
      for (Position pos : positionArray) {

        // if missile hits ship
        if (pos.getxCoordinate() == missile.getxCoordinate()
            && pos.getyCoordinate() == missile.getyCoordinate()) {
          //System.out.print(ships[i].getShipClass() + ", ");
          //System.out.print("Size = " + ships[i].getSize() + ", ");
          //System.out.print("X = " + pos.getxCoordinate() + ", ");
          //System.out.println("Y = " + pos.getyCoordinate() + " ");

          if (targetPlayer == Target.PLAYER1) {
            setPlayer2Board(missile.getxCoordinate(), missile.getyCoordinate(), SquareMark.HIT);
          } else {
            setPlayer1Board(missile.getxCoordinate(), missile.getyCoordinate(), SquareMark.HIT);
          }

          ships[i].setHitsArray(index,
              new Position(missile.getxCoordinate(), missile.getyCoordinate()));
          hit = true;
        }

        index += 1;
      }
    }

    // if missile doesn't hit ship
    if (!hit) {

      if (targetPlayer == Target.PLAYER1) {
        setPlayer2Board(missile.getxCoordinate(), missile.getyCoordinate(), SquareMark.MISS);
      } else {
        setPlayer1Board(missile.getxCoordinate(), missile.getyCoordinate(), SquareMark.MISS);
      }
    }
  }

  /**
   * Check if game is won.
   *
   * @return true if game is won, false otherwise.
   */
  public boolean isWinner(Target target) {
    Player p;
    p = (target == Target.PLAYER1) ? player1 : player2;

    int count = 0;
    for (int i = 0; i < numShips; i++) {
      if (p.getShips()[i].isSunk()) {
        count += 1;
      }
    }

    if (count == numShips) {
      notifyObservers(target);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Register an observer.
   *
   * @postcondition Observer, o, has been registered in the observers' list.
   */
  public void registerObserver(Observer o) {
    observers.add(o);
  }

  /**
   * Remove an observer.
   *
   * @postcondition Observer, o, has been removed from the observers' list.
   */
  public void removeObserver(Observer o) {
    int i = observers.indexOf(o);
    if (i >= 0) {
      observers.remove(i);
    }

  }

  /**
   * Notify all registered observers.
   *
   * @postcondition All the registered observers have been updated.
   */
  public void notifyObservers(Target target) {
    for (Observer observer : observers) {
      observer.update(this, target);
    }
  }

  /**
   * Accessor method for this board's width.
   *
   * @return this board's width
   */
  public int getBoardWidth() {
    return boardWidth;
  }

  /**
   * Accessor method for this board's height.
   *
   * @return this board's height
   */
  public int getBoardHeight() {
    return boardHeight;
  }


}
