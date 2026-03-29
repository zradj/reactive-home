package io.github.zradj.reactive_home.smart_device;

import io.github.zradj.reactive_home.observer.Observer;
import io.github.zradj.reactive_home.strategy.AlertStrategy;

public class SmartAlarm implements Observer {

  private AlertStrategy strategy;

  public SmartAlarm(AlertStrategy strategy) {
    if (strategy == null) {
      throw new NullPointerException("AlertStrategy cannot be null");
    }
    this.strategy = strategy;
  }

  public SmartAlarm(String strategyName) {
    this.setStrategy(strategyName);
  }

  public void turnOn() {
    this.strategy.executeAlert();
  }

  public void turnOff() {
    System.out.println("[Smart Alarm] The alarm is off");
  }

  public void setStrategy(String strategyName) {
    if (!AlertStrategy.REGISTRY.containsKey(strategyName)) {
      throw new IllegalArgumentException("Unexpected strategy name: " + strategyName);
    }
    System.out.println("[Smart Alarm] Setting strategy to '" + strategyName + "'...");
    this.strategy = AlertStrategy.REGISTRY.get(strategyName);
  }

  @Override
  public void update() {
    turnOn();
  }
}
