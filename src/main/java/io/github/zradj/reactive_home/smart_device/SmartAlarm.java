package io.github.zradj.reactive_home.smart_device;

import io.github.zradj.reactive_home.observer.Observer;
import io.github.zradj.reactive_home.strategy.AlertStrategy;
import io.github.zradj.reactive_home.strategy.LoudSirenStrategy;
import io.github.zradj.reactive_home.strategy.SilentPushStrategy;

import java.util.Map;

public class SmartAlarm implements Observer {

  private static final Map<String, AlertStrategy> STRATEGY_REGISTRY =
      Map.of(
          "LoudSirenStrategy",
          new LoudSirenStrategy(),
          "SilentPushStrategy",
          new SilentPushStrategy());
  private AlertStrategy strategy;

  public SmartAlarm(AlertStrategy strategy) {
    this.strategy = strategy;
  }

  public SmartAlarm(String strategyName) {
    this.updateStrategy(strategyName);
  }

  public void updateStrategy(String strategyName) {
    if (!STRATEGY_REGISTRY.containsKey(strategyName)) {
      throw new IllegalArgumentException("Unexpected strategy name: " + strategyName);
    }
    this.strategy = STRATEGY_REGISTRY.get(strategyName);
  }

  @Override
  public void update() {
    this.strategy.executeAlert();
  }
}
