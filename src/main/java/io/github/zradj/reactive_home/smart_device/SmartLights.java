package io.github.zradj.reactive_home.smart_device;

import io.github.zradj.reactive_home.observer.Observer;

public class SmartLights implements Observer {

  @Override
  public void update() {
    System.out.println("[Smart Lights] Flashing some blinding lights");
  }
}
