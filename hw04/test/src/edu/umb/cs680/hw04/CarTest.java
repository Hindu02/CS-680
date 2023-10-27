package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void verifyChangeState() {
        Car car = new Car();
        car.changeState(new IdleState(car));
        assert (car.getState() instanceof IdleState);
    }

    @Test
    public void verifyInitialStateIsOffState() {
        Car car = new Car();

        assert (car.getState() instanceof OffState);
    }

    @Test
    public void verifyOffStatebrakePressed() {
        Car car = new Car();
        car.changeState(new OffState(car));
        car.brakePressed();
        assert (car.getState() instanceof OffState);
    }

    @Test
    public void verifyOffStateIgnitionPressed() {
        Car car = new Car();
        car.changeState(new OffState(car));
        car.ignitionPressed();
        assert (car.getState() instanceof IdleState);
    }

    @Test
    public void verifyOffStateAcceleratePressed() {
        Car car = new Car();
        car.changeState(new OffState(car));
        car.acceleratePressed();
        assert (car.getState() instanceof OffState);
    }

    @Test
    public void verifyIdleStatebrakePressed() {
        Car car = new Car();
        car.changeState(new IdleState(car));
        car.brakePressed();
        assert (car.getState() instanceof IdleState);
    }

    @Test
    public void verifyIdleStateIgnitionPressed() {
        Car car = new Car();
        car.changeState(new IdleState(car));
        car.ignitionPressed();
        assert (car.getState() instanceof OffState);
    }

    @Test
    public void verifyIdleStateAcceleratePressed() {
        Car car = new Car();
        car.changeState(new IdleState(car));
        car.acceleratePressed();
        assert (car.getState() instanceof MoveState);
    }


    @Test
    public void verifyMoveStatebrakePressed() {
        Car car = new Car();
        car.changeState(new MoveState(car));
        car.brakePressed();
        assert (car.getState() instanceof IdleState);
    }

    @Test
    public void verifyMoveStateIgnitionPressed() {
        Car car = new Car();
        car.changeState(new MoveState(car));
        car.ignitionPressed();
        assert (car.getState() instanceof OffState);
    }

    @Test
    public void verifyMoveStateAcceleratePressed() {
        Car car = new Car();
        car.changeState(new MoveState(car));
        car.acceleratePressed();
        assert (car.getState() instanceof MoveState);
    }

}
