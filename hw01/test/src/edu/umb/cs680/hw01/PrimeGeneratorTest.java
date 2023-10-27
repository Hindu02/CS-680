package edu.umb.cs680.hw01;

import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeGeneratorTest {

    @Test
    public void verifyGeneratePrimesFrom1to9() {
        PrimeGenerator gen = new PrimeGenerator(1, 10);
        gen.generatePrimes();
        LinkedList<Long> primes = gen.getPrimes();
        LinkedList<Long> expected = new LinkedList<>();
        expected.add(2L);
        expected.add(3L);
        expected.add(5L);
        expected.add(7L);
        assertIterableEquals(expected, primes);
    }

    @Test
    public void verifyGeneratePrimesFrom1to5() {
        PrimeGenerator gen = new PrimeGenerator(1, 5);
        gen.generatePrimes();
        LinkedList<Long> primes = gen.getPrimes();
        LinkedList<Long> expected = new LinkedList<>();
        expected.add(2L);
        expected.add(3L);
        expected.add(5L);
        assertIterableEquals(expected, primes);
    }

    @Test
    public void verifyExceptionWhenFromGreaterThanTo() {
        try {
            PrimeGenerator gen = new PrimeGenerator(3, 1);
            fail();
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=" + 3 + " to=" + 1, e.getMessage());
        }
    }

    @Test
    public void verifyExceptionWhenFromEqualToTo() {
        try {
            PrimeGenerator gen = new PrimeGenerator(1, 1);
            fail();
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=" + 1 + " to=" + 1, e.getMessage());
        }
    }

}
