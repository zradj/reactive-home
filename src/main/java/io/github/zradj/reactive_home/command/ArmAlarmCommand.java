package io.github.zradj.reactive_home.command;

import io.github.zradj.reactive_home.smart_device.SmartAlarm;

public class ArmAlarmCommand implements Command {

  private final SmartAlarm alarm;

  public ArmAlarmCommand(SmartAlarm alarm) {
    this.alarm = alarm;
  }

  @Override
  public void execute() {
    this.alarm.turnOn();
  }

  @Override
  public void undo() {
    this.alarm.turnOff();
  }
}
