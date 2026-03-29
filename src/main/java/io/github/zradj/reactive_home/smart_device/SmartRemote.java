package io.github.zradj.reactive_home.smart_device;

import io.github.zradj.reactive_home.command.Command;

import java.util.List;

public class SmartRemote {

  private final List<Command> buttonCommands;
  private Command lastCommand;

  public SmartRemote(List<Command> buttonCommands) {
    this.buttonCommands = buttonCommands;
  }

  public void pressButton(int slot) {
    if (slot < 0) {
      throw new IllegalArgumentException("The slot cannot be negative");
    }

    if (slot >= buttonCommands.size()) {
      throw new IllegalArgumentException(
          "There are only " + buttonCommands.size() + " buttons, received slot " + slot);
    }

    buttonCommands.get(slot).execute();
    this.lastCommand = buttonCommands.get(slot);
  }

  public void pressUndo() {
    if (this.lastCommand != null) {
      this.lastCommand.undo();
      this.lastCommand = null;
    }
  }
}
