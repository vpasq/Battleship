package battleship.grid;

import battleship.characters.Player;
import battleship.ships.Ship;
import battleship.ships.ShipFactory;

public class InitSixShipsCommand implements Command {
  World world;

  /**
   * Initialize receiver.
   *
   * @param world the receiver.
   */
  public InitSixShipsCommand(World world) {
    this.world = world;
  }

  /**
   * Execute actions on the receiver object, world.
   *
   * @postcondition this game board was initialized with
   *                six ships per player.
   */
  @Override
  public void execute() {
    ShipFactory factory = new ShipFactory();

    // Create player1 ships using factory method
    Ship[] ships1 = new Ship[6];
    Ship ship1 = factory.createShip("carrier", "player1");
    ships1[0] = ship1;
    Ship ship2 = factory.createShip("cruiser", "player1");
    ships1[1] = ship2;
    Ship ship3 = factory.createShip("destroyer", "player1");
    ships1[2] = ship3;
    Ship ship4 = factory.createShip("carrier", "player1");
    ships1[3] = ship4;
    Ship ship5 = factory.createShip("cruiser", "player1");
    ships1[4] = ship5;
    Ship ship6 = factory.createShip("destroyer", "player1");
    ships1[5] = ship6;

    // Create player2 ships using factory method
    Ship[] ships2 = new Ship[6];
    Ship ship7 = factory.createShip("carrier", "player2");
    ships2[0] = ship7;
    Ship ship8 = factory.createShip("cruiser", "player2");
    ships2[1] = ship8;
    Ship ship9 = factory.createShip("destroyer", "player2");
    ships2[2] = ship9;
    Ship ship10 = factory.createShip("carrier", "player2");
    ships2[3] = ship10;
    Ship ship11 = factory.createShip("cruiser", "player2");
    ships2[4] = ship11;
    Ship ship12 = factory.createShip("destroyer", "player2");
    ships2[5] = ship12;

    // setup player1
    Player player1 = new Player(world, ships1);
    world.setPlayer1(player1);

    // setup player2
    Player player2 = new Player(world, ships2);
    world.setPlayer2(player2);

    // Randomly position both player ships vertically and horizontally.
    world.setShipsRandomly(world.getPlayer1());
    world.setShipsRandomly(world.getPlayer2());
  }
}

