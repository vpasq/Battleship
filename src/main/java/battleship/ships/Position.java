package battleship.ships;

public class Position {

  private int posX;
  private int posY;

  /**
   * Initialize this position.
   *
   * @param x the x coordinate of this position.
   * @param y the y coordinate of this position.
   */
  public Position(int x, int y) {
    posX = x;
    posY = y;
  }

  /**
   * Accessor method for this x coordinate.
   *
   * @return this x coordinate.
   */
  public int getxCoordinate() {
    return posX;
  }

  /**
   * Accessor method for this y coordinate.
   *
   * @return this y coordinate.
   */
  public int getyCoordinate() {
    return posY;
  }


  /**
   * Check if two position objects have the same x and y coordinates.
   *
   * @param obj the object to compare with this object.
   * @return true if both position objects have the same x and y coordinates, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() == obj.getClass()) {
      Position other = (Position) obj;
      return this.posX == other.posX && this.posY == other.posY;
    } else {
      return false;
    }
  }

  /**
   * Recommended hashCode implementation to use when instances of this
   * class will never be inserted into a HashMap/HashTable.
   *
   * @return any arbitrary constant will do
   */
  public int hashCode() {
    assert false : "hashCode not designed";
    return 42;
  }


}
