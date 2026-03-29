package io.github.zradj.reactive_home.command;

public class TurnOnLightCommand implements Command {

  @Override
  public void execute() {
    System.out.println("[Turn On Light Command] The lights are on");
  }

  @Override
  public void undo() {
    System.out.println("[Turn On Light Command] Undone, the lights are off");
  }
}
