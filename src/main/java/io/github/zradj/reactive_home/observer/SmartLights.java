package io.github.zradj.reactive_home.observer;

public class SmartLights implements Observer {

  @Override
  public void update() {
    System.out.println("[Smart Lights] Flashing some blinding lights");
  }

}
