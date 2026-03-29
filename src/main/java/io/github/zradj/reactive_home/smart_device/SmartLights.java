package io.github.zradj.reactive_home.smart_device;

import io.github.zradj.reactive_home.observer.Observer;

public class SmartLights implements Observer {

  public void turnOn() {
    System.out.println("[Smart Lights] The lights are on");
  }

  public void turnOff() {
    System.out.println("[Smart Lights] The lights are off");
  }

  @Override
  public void update() {
    turnOn();
  }
}
