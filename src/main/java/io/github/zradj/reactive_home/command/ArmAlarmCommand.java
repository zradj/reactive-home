package io.github.zradj.reactive_home.command;

public class ArmAlarmCommand implements Command {

  @Override
  public void execute() {
    System.out.println("[Arm Alarm Command] Arm alarm is turned on");
  }

  @Override
  public void undo() {
    System.out.println("[Arm Alarm Command] Undone, the arm alarm is turned off");
  }
}
