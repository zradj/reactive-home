package io.github.zradj.reactive_home.strategy;

import java.util.Map;

public interface AlertStrategy {

  Map<String, AlertStrategy> REGISTRY =
      Map.of("SIREN", new LoudSirenStrategy(), "SILENT", new SilentPushStrategy());

  void executeAlert();
}
