package io.github.zradj.reactive_home.observer;

import java.util.ArrayList;
import java.util.List;

public class MotionSensor implements Subject {

  private final List<Observer> observers = new ArrayList<>();

  public void detectMotion() {
    System.out.println("[Motion Sensor] Motion detected!!!!!!!!! Notifying everyone immediately");

    notifyObservers();
  }

  @Override
  public void addObserver(Observer observer) {
    this.observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    this.observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    for (Observer observer : this.observers) {
      observer.update();
    }
  }
}
