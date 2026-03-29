package io.github.zradj.reactive_home.command;

import io.github.zradj.reactive_home.smart_device.SmartLights;

public class TurnOnLightCommand implements Command {

  private final SmartLights lights;

  public TurnOnLightCommand(SmartLights lights) {
    this.lights = lights;
  }

  @Override
  public void execute() {
    this.lights.turnOn();
  }

  @Override
  public void undo() {
    this.lights.turnOff();
  }
}
