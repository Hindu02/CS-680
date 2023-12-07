package edu.umb.cs680.hw16;

public class AirConditioner implements Observer<Float> {

    Float DESIRED_TEMPERATURE = 24f;

    public void update(Observable<Float> sender, Float value) {
        System.out.println("Air Conditioner received temperature is now: " + value);
        adjustTemperature(value);
    }

    public void setTemperature(Float value) {
        DESIRED_TEMPERATURE = value;
    }

    public void adjustTemperature(Float value) {
        if (value < DESIRED_TEMPERATURE) {
            takeMoreAir();
        } else if (value > DESIRED_TEMPERATURE) {
            stopTakingAir();
        } 
    }

    public void takeMoreAir() {
    }

    public void stopTakingAir() {

    }

}
