package battleship.grid;

public class Invoker {
  private Command cmd;

  /**
   * Initialize instance variable, cmd.
   */
  public Invoker() {
    cmd = null;
  }

  /**
   * Store a command object in this invoker.
   * @param command the command object.
   * @postcondition the command object, command, was stored in the
   *                instance variable, cmd.
   */
  public void setCommand(Command command) {
    cmd = command;
  }

  /**
   * Call the execute method on the command object.
   *
   * @postcondition execute was called on this command object.
   */
  public void init() {
    cmd.execute();
  }
}


