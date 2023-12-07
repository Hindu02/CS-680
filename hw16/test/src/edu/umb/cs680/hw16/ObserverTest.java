package edu.umb.cs680.hw16;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

public class ObserverTest {

    private static Float DESIRED_TEMPERATURE = 24f;

    public static void setTemperature(Float value) {
        DESIRED_TEMPERATURE = value;
    }

    public static void adjustTemperature(Float value) {
        if (value < DESIRED_TEMPERATURE) {
            takeMoreAir();
        } else if (value > DESIRED_TEMPERATURE) {
            stopTakingAir();
        } 
    }

    public static void takeMoreAir() {
    }

    public static void stopTakingAir() {

    }

    public static void email(Float value) {
        if (value < 18) {
            System.out.println("Warining: Room temperature is lower than 18 Celsius");
        } else if (value > 28) {
            System.out.println("Warining: Room temperature is greate than 88 Celsius");
        }
    }

    public static void temperatureChanged(Float value) {
        if (value < DESIRED_TEMPERATURE) {
            lowerThanDesiredTemperature();
        } else if (value > DESIRED_TEMPERATURE) {
            higherThanDesiredTemperature();
        }
    }

    public static void lowerThanDesiredTemperature() {
        if (checkIfAirConsitionerIsRunning()) {
            switchOffAirConditioner();
        }
    }

    public static void higherThanDesiredTemperature() {
        if (checkIfAirConsitionerIsRunning()) {
            switchOnAirConditioner();
        }
    }

    public static boolean checkIfAirConsitionerIsRunning() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public static void switchOffAirConditioner() {

    }

    public static void switchOnAirConditioner() {

    }

    @Test
    public void checkifSensorHasAllObservers() {
        Sensor sensor = new Sensor();
        sensor.addObserver((sender, value) ->{
            System.out.println("Air Conditioner received temperature is now: " + value);
            adjustTemperature(value);
        });

        sensor.addObserver((sender, value) -> email(value));
        sensor.addObserver((sender, value) -> {
            temperatureChanged(value);
            System.out.println("Smart home controller received temperature is now: " + value);
        });
        assertEquals(3, sensor.countObservers());
    }

    @Test
    public void checkClearObserversMethod() {
        Sensor sensor = new Sensor();
        sensor.addObserver((sender, value) ->{
            System.out.println("Air Conditioner received temperature is now: " + value);
            adjustTemperature(value);
        });

        sensor.addObserver((sender, value) -> email(value));
        sensor.addObserver((sender, value) -> {
            temperatureChanged(value);
            System.out.println("Smart home controller received temperature is now: " + value);
        });
        sensor.clearObservers();
        assertEquals(0, sensor.countObservers());
    }

}
