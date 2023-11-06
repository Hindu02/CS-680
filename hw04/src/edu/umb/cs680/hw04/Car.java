package edu.umb.cs680.hw04;

public class Car {
    
    private State state;
    protected int speed;

    public Car() {
        this.state = new OffState(this);
        this.speed = 0;
    }

    public void accelerate() {
        speed = speed + 5;
    }

    public void brake() {
        speed = speed - 5;
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
