package edu.umb.cs680.hw05;
import java.util.Random;

public class SmartHomeController implements Observer<Float> {

    Float DESIRED_TEMPERATURE = 24f;


    public void update(Observable<Float> sender, Float value) {
        temperatureChanged(value);
        System.out.println("Smart home controller received temperature is now: " + value);
    }

    public void temperatureChanged(Float value) {
        if (value < DESIRED_TEMPERATURE) {
            lowerThanDesiredTemperature();
        } else if (value > DESIRED_TEMPERATURE) {
            higherThanDesiredTemperature();
        }
    }

    public void lowerThanDesiredTemperature() {
        if (checkIfAirConsitionerIsRunning()) {
            switchOffAirConditioner();
        }
    }

    public void higherThanDesiredTemperature() {
        if (checkIfAirConsitionerIsRunning()) {
            switchOnAirConditioner();
        }
    }

    public boolean checkIfAirConsitionerIsRunning() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public void switchOffAirConditioner() {

    }

    public void switchOnAirConditioner() {

    }

}
