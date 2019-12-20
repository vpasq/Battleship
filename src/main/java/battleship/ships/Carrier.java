package battleship.ships;

import java.util.Arrays;

public class Carrier extends Ship {

  /**
   * Initialize ship.
   *
   * @postcondition This ship's instance variables have been set.
   */
  public Carrier(String playerName) {
    shipClass = "Carrier";
    shipSize = 5;
    positionArray = new Position[shipSize];
    hitsArray = new Position[shipSize];
    sunk = false;
    this.playerName = playerName;
  }


}
