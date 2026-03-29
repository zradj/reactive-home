package io.github.zradj.reactive_home;

import io.github.zradj.reactive_home.command.ArmAlarmCommand;
import io.github.zradj.reactive_home.command.TurnOnLightCommand;
import io.github.zradj.reactive_home.observer.MotionSensor;
import io.github.zradj.reactive_home.smart_device.SmartAlarm;
import io.github.zradj.reactive_home.smart_device.SmartLights;
import io.github.zradj.reactive_home.smart_device.SmartRemote;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    System.out.println("=".repeat(50));
    System.out.println("Test the Event Bus & Strategy");
    System.out.println("=".repeat(50));
    System.out.println();

    MotionSensor motionSensor = new MotionSensor();
    SmartLights smartLights = new SmartLights();
    SmartAlarm smartAlarm = new SmartAlarm("SILENT");

    motionSensor.addObserver(smartLights);
    motionSensor.addObserver(smartAlarm);

    motionSensor.detectMotion();

    smartAlarm.setStrategy("SIREN");

    motionSensor.detectMotion();

    System.out.println();
    System.out.println("=".repeat(50));
    System.out.println("Test the Remote & Command");
    System.out.println("=".repeat(50));
    System.out.println();

    SmartRemote smartRemote =
        new SmartRemote(
            Arrays.asList(new TurnOnLightCommand(smartLights), new ArmAlarmCommand(smartAlarm)));
    smartRemote.pressButton(0);
    smartRemote.pressButton(1);
    smartRemote.pressUndo();
  }
}
