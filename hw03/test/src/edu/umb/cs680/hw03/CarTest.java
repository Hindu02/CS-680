package edu.umb.cs680.hw03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    private String[] carToStringArray(Car carObject) {
        String make = carObject.getMake();
        String model = carObject.getModel();
        String year = Integer.toString(carObject.getYear());
        return new String[] {make, model, year};
    }


    @Test
	public void verifyCarEqualityWithMakeModelYear() {
        Car toyota = new Car("Toyota", 23444.0f, "RAV4", 0, 2019);
        String[] expected = {"Toyota", "RAV4", "2019"};

		assertArrayEquals(expected, carToStringArray(toyota));
	}

	@Test
	public void verifyGetMakeMethod() {
        Car toyota = new Car("Toyota", 23444.0f, "RAV4", 0, 2019);
        String expected = "Toyota";
		assertSame(expected, toyota.getMake());
	}

	@Test
	public void verifyGetModelMethod() {
        Car toyota = new Car("Toyota", 23444.0f, "RAV4", 0, 2019);
        String expected = "RAV4";
		assertSame(expected, toyota.getModel());
	}

    @Test
	public void verifyGetPriceMethod() {
        Car toyota = new Car("Toyota", 23444.0f, "RAV4", 0, 2019);
        float expected = 23444.0f;
		assertEquals(expected, toyota.getPrice());
	}

    @Test
	public void verifyGetMileageMethod() {
        Car toyota = new Car("Toyota", 23444.0f, "RAV4", 0, 2019);
        int expected = 0;
		assertSame(expected, toyota.getMileage());
	}

    @Test
	public void verifyGetYearMethod() {
        Car toyota = new Car("Toyota", 23444.0f, "RAV4", 0, 2019);
        int expected = 2019;
		assertEquals(expected, toyota.getYear());
	}
    
}
