package battleship.ships;

public class ShipFactory {

  /**
   * Factory method for creating ships.
   *
   * @param type the type of ship to create.
   * @param player the ship's player.
   * @return a newly created ship.
   */
  public Ship createShip(String type, String player) {
    Ship ship = null;

    if (type.equals("destroyer")) {
      ship = new Destroyer(player);
    } else if (type.equals("cruiser")) {
      ship = new Cruiser(player);
    } else if (type.equals("carrier")) {
      ship = new Carrier(player);
    }
    return ship;
  }
}
