package battleship.characters;

import battleship.grid.World;
import battleship.grid.World.Target;

public interface Observer {

  /**
   * Display winning message and game board.
   *
   * @postcondition A winning message is displayed along with the winning game borad.
   */
  public void update(World world, Target target);

}
