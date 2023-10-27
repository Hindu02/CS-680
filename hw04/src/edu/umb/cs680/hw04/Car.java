package edu.umb.cs680.hw04;

public class Car {
    
    private State state;
    private int speed;
    private boolean isEngineRunning;

    public Car() {
        this.state = new OffState(this);
        this.speed = 0;
        this.isEngineRunning = false;
    }

    public void turnOn() {
        isEngineRunning = true;
    }

    public void turnOff() {
        isEngineRunning = false;
        speed = 0;
    }

    public void accelerate() {
        speed = speed + 5;
    }

    public void brake() {
        speed = 0;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    public void brakePressed() {
        state.brakePressed();
    }

    public void acceleratePressed() {
        state.acceleratePressed();
    }

    public void ignitionPressed() {
        state.ignitionPressed();
    }

}
