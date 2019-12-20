package battleship.ships;

import java.util.Arrays;

public class Destroyer extends Ship {

  /**
   * Initialize this ship's position.
   *
   * @postcondition This ship's instance variables have been set.
   */
  public Destroyer(String playerName) {
    shipClass = "Destroyer";
    shipSize = 2;
    positionArray = new Position[shipSize];
    hitsArray = new Position[shipSize];
    sunk = false;
    this.playerName = playerName;
  }


}
