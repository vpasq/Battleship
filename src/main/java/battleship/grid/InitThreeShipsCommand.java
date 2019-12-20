package battleship.grid;

import battleship.characters.Player;
import battleship.ships.Ship;
import battleship.ships.ShipFactory;

public class InitThreeShipsCommand implements Command {
  private World world;

  /**
   * Initialize receiver.
   *
   * @param world the receiver.
   */
  public InitThreeShipsCommand(World world) {
    this.world = world;
  }

  /**
   * Execute actions on the receiver object, world.
   *
   * @postcondition this game board was initialized with
   *                three ships per player.
   */
  @Override
  public void execute() {
    ShipFactory factory = new ShipFactory();

    // Create player1 ships using factory method
    Ship[] ships1 = new Ship[3];
    // Create player1 ships using factory method
    Ship ship1 = factory.createShip("carrier", "player1");
    ships1[0] = ship1;
    Ship ship2 = factory.createShip("cruiser", "player1");
    ships1[1] = ship2;
    Ship ship3 = factory.createShip("destroyer", "player1");
    ships1[2] = ship3;

    // Create player2 ships using factory method
    Ship[] ships2 = new Ship[3];
    Ship ship4 = factory.createShip("carrier", "player2");
    ships2[0] = ship4;
    Ship ship5 = factory.createShip("cruiser", "player2");
    ships2[1] = ship5;
    Ship ship6 = factory.createShip("destroyer", "player2");
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

  }
}
