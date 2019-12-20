package battleship.grid;

public enum SquareMark {

  WATER, MISS, HIT;

  /**
   * String representation of enum value.
   *
   * @return String representation of enum value.
   */
  public String toString() {
    switch (this) {
      case WATER:
        return "-";
      case MISS:
        return "*";
      case HIT:
        return "X";
      default:
        return "Unspecified";
    }
  }
}

