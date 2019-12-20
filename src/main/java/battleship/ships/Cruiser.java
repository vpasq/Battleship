package battleship.ships;

import java.util.Arrays;

public class Cruiser extends Ship {

  /**
   * Initialize ship.
   *
   * @postcondition This ship's instance variables have been set.
   */
  public Cruiser(String playerName) {
    shipClass = "Cruiser";
    shipSize = 3;
    positionArray = new Position[shipSize];
    hitsArray = new Position[shipSize];
    sunk = false;
    this.playerName = playerName;
  }


}
