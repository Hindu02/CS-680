package edu.umb.cs680.hw04;

public class OffState implements State{

    private Car car;

    public OffState(Car car) {
        this.car = car;
    }

    public void brakePressed() {
        // when the engine is off and break is pressed, nothing happens
    }

    public void acceleratePressed() {
        // when the engine is off and acceleration is pressed, nothing happens
    }

    public void ignitionPressed() {
        // when the engine is off and ignition is pressed, the engine starts
        car.changeState(new IdleState(car));
    }
    
}
