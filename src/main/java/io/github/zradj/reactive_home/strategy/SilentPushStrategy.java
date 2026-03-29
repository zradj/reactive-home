package io.github.zradj.reactive_home.strategy;

public class SilentPushStrategy implements AlertStrategy {

  @Override
  public void executeAlert() {
    System.out.println(
        "[Silent Push Strategy] Sending silent push notification to homeowner's phone.");
  }
}
