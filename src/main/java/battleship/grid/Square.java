package battleship.grid;

public class Square {

  private int posX;
  private int posY;
  private SquareMark squareMark;

  /**
   * Initialize space on game board.
   *
   * @param posX the x coordinate of this space element.
   * @param posY the y coordinate of this space element.
   * @param squareMark the marking of this space element.
   * @postcondition This space element has been initialized to squareMark.
   */
  public Square(int posX, int posY, SquareMark squareMark) {
    this.posX = posX;
    this.posY = posY;
    this.squareMark = squareMark;
  }

  /**
   * Set space on game board.
   *
   * @param squareMark defined as one of the following:
   *                     - water element absent of a ship, and not fired upon.
   *                     * water element absent of a ship, and fired upon.
   *                     X ship element fired upon and hit.
   * @postcondition this space has been set to the given squareMark.
   */
  public void setSpaceMark(SquareMark squareMark) {
    this.squareMark = squareMark;
  }

  /**
   * Accessor method for the x coordinate of this space.
   *
   * @return the x coordinate of this space
   */
  public int getxCoordinate() {
    return posX;
  }

  /**
   * Accessor method for the y coordinate of this space.
   *
   * @return the y coordinate of this space
   */
  public int getyCoordinate() {
    return posY;
  }

  /**
   * Accessor method for the marking of this space.
   *
   * @return the marking of this space
   */
  public String getMarking() {
    return squareMark.toString();
  }


}
