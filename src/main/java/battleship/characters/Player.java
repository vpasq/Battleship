package battleship.characters;

import battleship.grid.Observable;
import battleship.grid.World;
import battleship.grid.World.Target;
import battleship.ships.Position;
import battleship.ships.Ship;

public class Player implements Observer {
  private int numberShips;
  private Ship[] ships;

  /**
   * Initialize player's ships.
   *
   * @param shipRefs this player's ships.
   */
  public Player(Observable observable, Ship... shipRefs) {
    observable.registerObserver(this);
    this.numberShips = shipRefs.length;
    ships = new Ship[numberShips];
    int j = 0;
    for (Ship ship : shipRefs) {
      ships[j] = ship;
      j++;
    }
  }

  /**
   * Accessor method for this player's ships array.√private Position[] positionArray;
   *
   * @return this player's ships array.
   */
  public Ship[] getShips() {
    return ships.clone();
  }

  /**
   * Accessor method for number of this player's ships.
   *
   * @return number of this player's ships.
   */
  public int getNumberShips() {
    return numberShips;
  }

  /**
   * Modifier method to fire missile.
   *
   * @param posX the x coordinate of the missile.
   * @param posY the y coordinate of the missile.
   * @postcondition Missile has been fired with target coordinates, posX and posY.
   */
  public Position fireMissile(int posX, int posY) {
    return new Position(posX, posY);
  }

  /**
   * Display winning message and game board.
   *
   * @postcondition A winning message is displayed along with the winning game borad.
   */
  public void update(World world, Target target) {
    if (target == Target.PLAYER1) {
      System.out.println("\nPlayer 2 Wins!");
      System.out.println("Observer Pattern used to send \"Winning Game Board\" to both players.");
      world.displayPlayer2Board();
    } else {
      System.out.println("\nPlayer 1 Wins!");
      System.out.println("Observer Pattern used to send \"Winning Game Board\" to both players.");
      world.displayPlayer1Board();
    }
  }


}
