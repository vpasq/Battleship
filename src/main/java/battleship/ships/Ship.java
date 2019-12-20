package battleship.ships;

import java.util.Arrays;

public abstract class Ship {
  String playerName;
  boolean sunk;
  String shipClass;
  int shipSize;
  Position[] positionArray;
  Position[] hitsArray;

  /**
   * Accessor method for ship class.
   *
   * @return this ship class.
   */
  public String getShipClass() {
    return shipClass;
  }

  /**
   * Accessor method for this ship size.
   *
   * @return this ship size.
   */
  public int getSize() {
    return shipSize;
  }

  /**
   * Accessor method for ship's position array.
   *
   * @return this ship's position array.
   */
  public Position[] getPositionArray() {
    return positionArray.clone();
  }

  /**
   * Modifier method to set this ship's position array.
   *
   * @param shipSquare This section of the ship. If shipSize = 3, then the ship has three shipSquare
   *                   sections.
   * @param pos the position of this shipSquare section.
   * @postcondition this ship's position array has been set.
   */
  public void setPositionArray(int shipSquare, Position pos) {
    positionArray[shipSquare] = pos;
  }

  /**
   * Accessor method for sunk.
   *
   * @return true if this ship is sunk, false otherwise.
   */
  public boolean isSunk() {
    return sunk;
  }

  /**
   * Modifier method to set a hit in this ship's hits array.
   *
   * @param shipSquare This section of this ship. If shipSize = 3, then this ship has three
   *                   shipSquare sections.
   * @param pos the position of this shipSquare section.
   * @postcondition A missile hit has been recorded in this ship's hitsArray.
   */
  public void setHitsArray(int shipSquare, Position pos) {
    if (!sunk) {
      hitsArray[shipSquare] = pos;
    }

    if (!sunk && Arrays.equals(hitsArray, positionArray)) {
      sunk = true;
      System.out.println(getPlayerName() + " " + shipClass + " is sunk");
    }
  }

  /**
   * Private Accessor method for this ship's player.
   *
   * @return this ship's player.
   */
  private String getPlayerName() {
    return playerName;
  }


}
