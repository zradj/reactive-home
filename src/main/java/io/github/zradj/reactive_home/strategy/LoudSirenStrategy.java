package io.github.zradj.reactive_home.strategy;

public class LoudSirenStrategy implements AlertStrategy {

  @Override
  public void executeAlert() {
    System.out.println("[Loud Siren Strategy] SOUNDING 120dB SIREN!");
  }

}
