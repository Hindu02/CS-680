package edu.umb.cs680.hw04;

public class MoveState implements State{

    private Car car;

    public MoveState(Car car) {
        this.car = car;
    }
    
    public void brakePressed() {
        //When the car is moving, and the brakes are pressed the car stops
        car.brake();
        car.changeState(new IdleState(car));
    }

    public void acceleratePressed() {
        // When the car is moving, and accelerate is presed, the car still keeps moving but at higher speeds.
        car.accelerate();
    }

    public void ignitionPressed() {
        // When car is moving and ignition is pressed, the car stops immediately
        // but this is dangerous in a practical situation
        car.turnOff();
        car.changeState(new OffState(car));
    }

}
