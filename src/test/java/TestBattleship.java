import battleship.characters.Player;
import battleship.grid.InitSixShipsCommand;
import battleship.grid.InitThreeShipsCommand;
import battleship.grid.Invoker;
import battleship.grid.World;
import battleship.grid.World.Target;
import battleship.ships.Position;
import battleship.ships.Ship;

import static org.junit.Assert.assertEquals;

import battleship.ships.ShipFactory;
import org.junit.Test;

public class TestBattleship {
  // Setup
  private int width = 5;
  private int height = 5;
  private int numShips = 3;
  private Position missile;
  private World world = new World(width, height, numShips);

  @Test
  public void testFactoryAndStrategyPattern() {
    // setup
    ShipFactory factory = new ShipFactory();
    Ship[] ships1 = new Ship[numShips];
    Ship[] ships2 = new Ship[numShips];

    // Create player1 ships using Factory method
    Ship ship1 = factory.createShip("carrier", "player1");
    Ship ship2 = factory.createShip("cruiser", "player1");
    Ship ship3 = factory.createShip("destroyer", "player1");
    ships1[0] = ship1;
    ships1[1] = ship2;
    ships1[2] = ship3;

    // expected player 1 ships
    String expected1 = "battleship.ships.Carrier";
    String expected2 = "battleship.ships.Cruiser";
    String expected3 = "battleship.ships.Destroyer";

    // actual player 1 ships
    String actual1 = ship1.getClass().getName();
    String actual2 = ship2.getClass().getName();
    String actual3 = ship3.getClass().getName();

    // verify player 1 ships
    assertEquals(expected1, actual1);
    assertEquals(expected2, actual2);
    assertEquals(expected3, actual3);

    // Switch player1's ship during game runtime
    // (made possible by the Strategy pattern.
    ship1 = factory.createShip("destroyer", "player1");
    ship2 = factory.createShip("destroyer", "player1");
    ship3 = factory.createShip("carrier", "player1");
    ships1[0] = ship1;
    ships1[1] = ship2;
    ships1[2] = ship3;

    // new expected player 1 ships
    expected1 = "battleship.ships.Destroyer";
    expected2 = "battleship.ships.Destroyer";
    expected3 = "battleship.ships.Carrier";

    // new actual player 1 ships
    actual1 = ship1.getClass().getName();
    actual2 = ship2.getClass().getName();
    actual3 = ship3.getClass().getName();

    // verify player 1's new ships
    assertEquals(expected1, actual1);
    assertEquals(expected2, actual2);
    assertEquals(expected3, actual3);
  }

  @Test
  public void testCommandPatternWithThreeShipsAndFiveGrid() {

    // Test case for command object that will randomly initialize
    // the game board with 3 ships and a 5 x 5 square grid.
    int width = 5;
    int height = 5;
    int numShips = 3;
    Position missile;
    World world = new World(width, height, numShips);

    // create the invoker object
    Invoker invoker = new Invoker();

    // create the command object
    InitThreeShipsCommand initThree = new InitThreeShipsCommand(world);

    // store the command object in the invoker
    invoker.setCommand(initThree);

    // ask the invoker to execute this command
    invoker.init();

    // Observer Pattern is used to display "Winning Game Board" twice,
    // once for each player (using System.out).
    // Players take turns firing at every square until there is a winner.
    for ( int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {

        missile = world.getPlayer1().fireMissile(i, j);
        world.verifyHit(Target.PLAYER1, missile);
        if (world.isWinner(Target.PLAYER1)) {
          return;
        }

        missile = world.getPlayer2().fireMissile(i, j);
        world.verifyHit(Target.PLAYER2, missile);
        if (world.isWinner(Target.PLAYER2)) {
          return;
        }
      }
    }

    // expected values
    int expectedNumOfShips = 3;
    int expectedBoardWidth = 5;
    int expectedBoardHeight = 5;

    // actual values
    int actualNumberOfShips = world.getPlayer1().getNumberShips();
    int actualBoardWidth = world.getBoardWidth();
    int actualBoardHeight = world.getBoardHeight();

    // verify
    assertEquals(expectedNumOfShips, actualNumberOfShips);
    assertEquals(expectedBoardWidth, actualBoardWidth);
    assertEquals(expectedBoardHeight, actualBoardHeight);

  }

  @Test
  public void testCommandPatternWithSixShipsAndFifteenGrid() {

    // Test case for command object that will randomly initialize
    // the game board with 6 ships and a 10 x 10 square grid.
    int width = 10;
    int height = 10;
    int numShips = 6;
    Position missile;
    World world = new World(width, height, numShips);

    // create the invoker object
    Invoker invoker = new Invoker();

    // create the command object
    InitSixShipsCommand initThree = new InitSixShipsCommand(world);

    // store the command object in the invoker
    invoker.setCommand(initThree);

    // ask the invoker to execute this command
    invoker.init();

    // Observer Pattern is used to display "Winning Game Board" twice,
    // once for each player (using System.out).
    // Players take turns firing at every square until there is a winner.
    for ( int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {

        missile = world.getPlayer1().fireMissile(i, j);
        world.verifyHit(Target.PLAYER1, missile);
        if (world.isWinner(Target.PLAYER1)) {
          return;
        }

        missile = world.getPlayer2().fireMissile(i, j);
        world.verifyHit(Target.PLAYER2, missile);
        if (world.isWinner(Target.PLAYER2)) {
          return;
        }
      }
    }

    // expected values
    int expectedNumOfShips = 6;
    int expectedBoardWidth = 10;
    int expectedBoardHeight = 10;

    // actual values
    int actualNumberOfShips = world.getPlayer1().getNumberShips();
    int actualBoardWidth = world.getBoardWidth();
    int actualBoardHeight = world.getBoardHeight();

    // verify
    assertEquals(expectedNumOfShips, actualNumberOfShips);
    assertEquals(expectedBoardWidth, actualBoardWidth);
    assertEquals(expectedBoardHeight, actualBoardHeight);
  }

  @Test
  public void testObserverPatternWithSystemOutAfterWin() {

    // setup
    ShipFactory factory = new ShipFactory();
    Ship[] ships1 = new Ship[numShips];
    Ship[] ships2 = new Ship[numShips];

    // Create player1 ships using factory method
    Ship ship1 = factory.createShip("carrier", "player1");
    Ship ship2 = factory.createShip("cruiser", "player1");
    Ship ship3 = factory.createShip("destroyer", "player1");
    ships1[0] = ship1;
    ships1[1] = ship2;
    ships1[2] = ship3;

    // Create player2 ships using factory method
    Ship ship4 = factory.createShip("carrier", "player2");
    Ship ship5 = factory.createShip("cruiser", "player2");
    Ship ship6 = factory.createShip("destroyer", "player2");
    ships2[0] = ship4;
    ships2[1] = ship5;
    ships2[2] = ship6;

    // setup player1
    Player player1 = new Player(world, ships1);
    world.setPlayer1(player1);

    // setup player2
    Player player2 = new Player(world, ships2);
    world.setPlayer2(player2);

    // Randomly position both player ships vertically and horizontally.
    world.setShipsRandomly(world.getPlayer1());
    world.setShipsRandomly(world.getPlayer2());

    // Observer Pattern is used to display "Winning Game Board" twice,
    // once for each player (using System.out).
    // Players take turns firing at every square until there is a winner.
    for ( int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {

        missile = world.getPlayer1().fireMissile(i, j);
        world.verifyHit(Target.PLAYER1, missile);
        if (world.isWinner(Target.PLAYER1)) {
          return;
        }

        missile = world.getPlayer2().fireMissile(i, j);
        world.verifyHit(Target.PLAYER2, missile);
        if (world.isWinner(Target.PLAYER2)) {
          return;
        }
      }
    }
  }


}
