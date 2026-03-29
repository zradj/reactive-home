package io.github.zradj.reactive_home.smart_device;

import io.github.zradj.reactive_home.observer.Observer;
import io.github.zradj.reactive_home.strategy.AlertStrategy;
import io.github.zradj.reactive_home.strategy.LoudSirenStrategy;
import io.github.zradj.reactive_home.strategy.SilentPushStrategy;

import java.util.Map;

public class SmartAlarm implements Observer {

  private AlertStrategy strategy;

  public SmartAlarm(AlertStrategy strategy) {
    if (strategy == null) {
      throw new NullPointerException("AlertStrategy cannot be null");
    }
    this.strategy = strategy;
  }

  public SmartAlarm(String strategyName) {
    this.updateStrategy(strategyName);
  }

  public void updateStrategy(String strategyName) {
    if (!AlertStrategy.STRATEGY_REGISTRY.containsKey(strategyName)) {
      throw new IllegalArgumentException("Unexpected strategy name: " + strategyName);
    }
    this.strategy = AlertStrategy.STRATEGY_REGISTRY.get(strategyName);
  }

  @Override
  public void update() {
    this.strategy.executeAlert();
  }
}
