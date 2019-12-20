package battleship.grid;

import battleship.characters.Observer;
import battleship.grid.World.Target;

public interface Observable {

  /**
   * Register an observer.
   *
   * @postcondition Observer, o, has been registered in the observers' list.
   */
  public void registerObserver(Observer observer);

  /**
   * Remove an observer.
   *
   * @postcondition Observer, o, has been removed from the observers' list.
   */
  public void removeObserver(Observer observer);

  /**
   * Notify all registered observers.
   *
   * @postcondition All the registered observers have been updated.
   */
  public void notifyObservers(Target target);

}
