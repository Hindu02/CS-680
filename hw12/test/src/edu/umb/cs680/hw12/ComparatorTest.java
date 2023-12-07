package edu.umb.cs680.hw12;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;

public class ComparatorTest {

    private static Car car1, car2, car3, car4, car5;
    private static Car[] cars;

    @BeforeAll
    public static void setUp() {

        car1 = new Car("Toyota", 25000.0f, "Camry", 15000, 2022);
        car2 = new Car("Honda", 28000.0f, "Civic", 12000, 2021);
        car3 = new Car("Ford", 30000.0f, "Mustang", 10000, 2020);
        car4 = new Car("Chevrolet", 22000.0f, "Malibu", 20000, 2019);
        car5 = new Car("Nissan", 27000.0f, "Altima", 18000, 2023);

        cars = new Car[5];
        cars[0] = car1;
        cars[1] = car2;
        cars[2] = car3;
        cars[3] = car4;
        cars[4] = car5;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i != j) {
                    Car carOne = cars[i];
                    Car carTwo = cars[j];
                    if (carOne.getPrice() <= carTwo.getPrice() &&
                            carOne.getMileage() <= carTwo.getMileage() &&
                            carOne.getYear() >= carTwo.getYear()
                            && (carOne.getPrice() < carTwo.getPrice() ||
                                    carOne.getMileage() < carTwo.getMileage() ||
                                    carOne.getYear() > carTwo.getYear())) {

                        // car two is dominated by car one
                        carTwo.setDominationCount(carTwo.getDominationCount() + 1);

                    }
                }
            }
        }
    }

    @Test
    public void verifyYearComparator() {
        Arrays.sort(cars, new YearComparator());
        Car[] expected = { car5, car1, car2, car3, car4 };

        assertArrayEquals(expected, cars);
    }

    @Test
    public void verifyPriceComparator() {
        Arrays.sort(cars, new PriceComparator());
        Car[] expected = { car4, car1, car5, car2, car3 };

        assertArrayEquals(expected, cars);
    }

    @Test
    public void verifyMileageComparator() {
        Arrays.sort(cars, new MileageComparator());
        Car[] expected = { car3, car2, car1, car5, car4 };

        assertArrayEquals(expected, cars);
    }

    @Test
    public void verifyParetoComparator() {
        Arrays.sort(cars, new ParetoComparator());
        Car[] expected = { car3, car2, car1, car5, car4 };
        assertArrayEquals(expected, cars);
    }

}
