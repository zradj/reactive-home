package io.github.zradj.reactive_home.observer;

public class SmartAlarm implements Observer {

  @Override
  public void update() {
    System.out.println("[Smart Alarm] Sounding an alarm");
  }

}
