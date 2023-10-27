package edu.umb.cs680.hw05;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ObserverTest {

    public static Sensor getInstance() {
        Sensor sensor = new Sensor();
        sensor.addObserver(new AirConditioner());
        sensor.addObserver(new MobilePhone());
        sensor.addObserver(new SmartHomeController());

        return sensor;
    }

    @Test
    public void checkifSensorHasAllObservers() {
        Sensor sensor = getInstance();
        assertEquals(3, sensor.countObservers());
    }

    @Test
    public void checkClearObserversMethod() {
        Sensor sensor = getInstance();
        sensor.clearObservers();
        assertEquals(0, sensor.countObservers());
    }

    @Test
    public void checkRemoveObserverMethod() {
        Sensor sensor = getInstance();
        MobilePhone phone = new MobilePhone();
        sensor.removeObserver(phone);
        assertFalse(sensor.getObservers().contains(phone));
    }

    @Test
    public void checkGetObserversMethod() {
        Sensor sensor = new Sensor();
        AirConditioner airConditioner = new AirConditioner();
        MobilePhone phone = new MobilePhone();
        SmartHomeController controller = new SmartHomeController();
        sensor.addObserver(airConditioner);
        sensor.addObserver(phone);
        sensor.addObserver(controller);

        List<Observer<Float>> expected = new ArrayList<>();
        expected.add(airConditioner);
        expected.add(phone);
        expected.add(controller);

        assertIterableEquals(expected, sensor.getObservers());
    }

    @Test
    public void checkNotifyObserversMethod() {
        Sensor sensor = getInstance();
        sensor.notifyObservers(20.0f);

        assert(true);
    }

}
