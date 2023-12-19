package edu.umb.cs680.hw11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

public class DistanceTest {

    // min - max normalization
    public static List<List<Double>> normalize(List<List<Double>> points) {
        for (int i = 0; i < points.get(0).size(); i++) {
            double max = Double.MIN_VALUE;
            double min = Double.MAX_VALUE;
            for (int j = 0; j < points.size(); j++) {
                max = Math.max(points.get(j).get(i), max);
                min = Math.min(points.get(j).get(i), min);
            }

            for (int j = 0; j < points.size(); j++) {
                List<Double> point = points.get(j);
                point.set(i, (point.get(i) - min) / (max - min));
            }
        }
        return points;
    }

    @Test
    public void verify1000RandomCars1() {

        Random random = new Random();

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            cars.add(new Car("random", random.nextFloat(2023f), "random", random.nextInt(10000), random.nextInt(2023 - 1900) + 1900));
        }
        List<List<Double>> points = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            points.add(Arrays.asList((double)cars.get(i).getMileage(), (double) cars.get(i).getPrice(),  (double)cars.get(i).getYear()));
        }

        points = normalize(points);
        List<List<Double>> matrix = Distance.matrix(points, new Euclidean());
        assertEquals(1000, matrix.size());
        assertEquals(1000, matrix.get(0).size());
    }

    @Test
    public void verify1000RandomCars2() {

        Random random = new Random();

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            cars.add(new Car("random", random.nextFloat(2023f), "random", random.nextInt(10000), random.nextInt(2023 - 1900) + 1900));
        }
        List<List<Double>> points = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            points.add(Arrays.asList((double)cars.get(i).getMileage(), (double) cars.get(i).getPrice(),  (double)cars.get(i).getYear()));
        }

        points = normalize(points);
        List<List<Double>> matrix = Distance.matrix(points, new Manhattan());
        assertEquals(1000, matrix.size());
        assertEquals(1000, matrix.get(0).size());
    }

    @Test
    public void verifyEuclideanMatrix() {
        List<Double> point1 = Arrays.asList(1d, 2d, 3d);
        List<Double> point2 = Arrays.asList(2d, 3d, 4d);
        List<Double> point3 = Arrays.asList(3d, 4d, 5d);

        List<List<Double>> points = Arrays.asList(point1, point2, point3);
        points = normalize(points);
        List<List<Double>> expected = Arrays.asList(Arrays.asList(0.0, 0.8660254037844386, 1.7320508075688772),
                Arrays.asList(0.8660254037844386, 0.0, 0.8660254037844386),
                Arrays.asList(1.7320508075688772, 0.8660254037844386, 0.0));

        assertIterableEquals(expected, Distance.matrix(points, new Euclidean()));
    }

    @Test
    public void verifyManhattanMatrix() {
        List<Double> point1 = Arrays.asList(1d, 2d, 3d);
        List<Double> point2 = Arrays.asList(2d, 3d, 4d);
        List<Double> point3 = Arrays.asList(3d, 4d, 5d);

        List<List<Double>> points = Arrays.asList(point1, point2, point3);
        points = normalize(points);
        List<List<Double>> expected = Arrays.asList(Arrays.asList(0.0, 1.5, 3.0), Arrays.asList(1.5, 0.0, 1.5),
                Arrays.asList(3.0, 1.5, 0.0));

        assertIterableEquals(expected, Distance.matrix(points, new Manhattan()));
    }

    @Test
    public void verifyCosineMatrix() {
        List<Double> point1 = Arrays.asList(1d, 4d, 5d);
        List<Double> point2 = Arrays.asList(2d, 3d, 4d);
        List<Double> point3 = Arrays.asList(3d, 2d, 3d);

        List<List<Double>> points = Arrays.asList(point1, point2, point3);
        points = normalize(points);
        List<List<Double>> expected = Arrays.asList(Arrays.asList(0.9999999999999998, 0.8164965809277259, 0.0),
                Arrays.asList(0.8164965809277259, 1.0000000000000002, 0.5773502691896258),
                Arrays.asList(0.0, 0.5773502691896258, 1.0));

        assertIterableEquals(expected, Distance.matrix(points, new Cosine()));
    }

    @Test
    public void verifyCosineDistance() {

        List<Double> point1 = Arrays.asList(3d, 2d, 3d);
        List<Double> point2 = Arrays.asList(2d, 3d, 4d);

        assertEquals(0.950169098957875, Distance.get(point1, point2, new Cosine()));
    }

    @Test
    public void verifyEuclideanDistance() {

        List<Double> point1 = Arrays.asList(3d, 2d, 3d);
        List<Double> point2 = Arrays.asList(2d, 3d, 4d);

        assertEquals(1.7320508075688772, Distance.get(point1, point2, new Euclidean()));
    }

    @Test
    public void verifyManhattanDistance() {

        List<Double> point1 = Arrays.asList(3d, 2d, 3d);
        List<Double> point2 = Arrays.asList(2d, 3d, 4d);

        assertEquals(3d, Distance.get(point1, point2, new Manhattan()));
    }
}
