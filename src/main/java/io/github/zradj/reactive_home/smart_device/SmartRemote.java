package io.github.zradj.reactive_home.smart_device;

import io.github.zradj.reactive_home.command.ArmAlarmCommand;
import io.github.zradj.reactive_home.command.Command;
import io.github.zradj.reactive_home.command.TurnOnLightCommand;

import java.util.ArrayList;
import java.util.List;

public class SmartRemote {

  private static final Command[] BUTTON_COMMANDS = {
    new TurnOnLightCommand(), new ArmAlarmCommand()
  };
  private Command lastCommand;

  public void pressButton(int slot) {
    if (slot < 0) {
      throw new IllegalArgumentException("The slot cannot be negative");
    }

    if (slot >= BUTTON_COMMANDS.length) {
      throw new IllegalArgumentException(
          "There are only " + BUTTON_COMMANDS.length + " buttons, received slot " + slot);
    }

    BUTTON_COMMANDS[slot].execute();
    this.lastCommand = BUTTON_COMMANDS[slot];
  }

  public void pressUndo() {
    if (this.lastCommand != null) {
      this.lastCommand.undo();
      this.lastCommand = null;
    }
  }
}
