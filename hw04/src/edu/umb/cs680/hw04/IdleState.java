package edu.umb.cs680.hw04;

public class IdleState implements State{

    private Car car;

    public IdleState(Car car) {
        this.car = car;
    }
    
    public void brakePressed() {
        // when car engine is on, and the car is stationary and brake is pressed,
        // the engine is still on and the car is still stationary
    }

    public void acceleratePressed() {
        // when car engine is on, and the car is stationary and accelerate is pressed,
        // the car starts moving
        car.accelerate();
        car.changeState(new MoveState(car));
    }

    public void ignitionPressed() {
        // when car engine is on, and the car is stationary and ignition is pressed,
        // the car engine switches off
        car.turnOff();
        car.changeState(new OffState(car));
    }
}
