package edu.umb.cs680.hw06;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MultiObserverTest {

    @Test
    public void verifyUpdateStepCount() {
        TrackerApp app = new TrackerApp();
        LocationSensor locationSensor = new LocationSensor();
        StepCounter stepCounter = new StepCounter();
        locationSensor.addObserver(app);
        stepCounter.addObserver(app);

        StepCount stepCount = new StepCount(24);
        stepCounter.notifyObservers(stepCount);
        assertEquals(24, app.step);
    }

    @Test
    public void verifyUpdateLocation() {
        TrackerApp app = new TrackerApp();
        LocationSensor locationSensor = new LocationSensor();
        StepCounter stepCounter = new StepCounter();
        locationSensor.addObserver(app);
        stepCounter.addObserver(app);

        Location loc = new Location(2, 4);
        locationSensor.notifyObservers(loc);
        assertEquals(2, app.latitude);
        assertEquals(4, app.longitude);
    }

    @Test
    public void verifyCountObservers() {
        TrackerApp app = new TrackerApp();
        LocationSensor locationSensor = new LocationSensor();
        StepCounter stepCounter = new StepCounter();
        locationSensor.addObserver(app);
        stepCounter.addObserver(app);

        assertEquals(1, stepCounter.countObservers());
        assertEquals(1, locationSensor.countObservers());
    }

    @Test
    public void verifyClearObservers() {
        TrackerApp app = new TrackerApp();
        LocationSensor locationSensor = new LocationSensor();
        StepCounter stepCounter = new StepCounter();
        locationSensor.addObserver(app);
        stepCounter.addObserver(app);

        locationSensor.clearObservers();

        assertEquals(0, locationSensor.countObservers());
    }

    @Test
    public void verifyGetObservers() {
        TrackerApp app = new TrackerApp();
        LocationSensor locationSensor = new LocationSensor();
        StepCounter stepCounter = new StepCounter();
        locationSensor.addObserver(app);
        stepCounter.addObserver(app);

        List<LocationObserver> expected1 = Arrays.asList(app);
        List<StepCountObserver> expected2 = Arrays.asList(app);
        
        assertIterableEquals(expected1, locationSensor.getObservers());
        assertIterableEquals(expected2, stepCounter.getObservers());
    }


}
