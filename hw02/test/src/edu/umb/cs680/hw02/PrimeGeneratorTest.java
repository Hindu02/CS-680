package edu.umb.cs680.hw02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;



public class PrimeGeneratorTest {
    
    public void verifyGetInstanceIsNotNull() {
        PrimeGenerator primeGenerator = PrimeGenerator.getInstance();
        assertNotNull(primeGenerator);
    }

    public void verifyGetInstanceReturnSameObject() {
        PrimeGenerator generator1 = PrimeGenerator.getInstance();
        generator1.fromto(1, 34);
        PrimeGenerator generator2 = PrimeGenerator.getInstance();
        generator2.fromto(1, 20);
        assertSame(generator1, generator2);
    }

    @Test
    public void verifyGeneratePrimesFrom1to9() {
        PrimeGenerator gen = PrimeGenerator.getInstance();
        gen.fromto(1, 10);
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
        PrimeGenerator gen = PrimeGenerator.getInstance();
        gen.fromto(1, 5);
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
            PrimeGenerator gen = PrimeGenerator.getInstance();
            gen.fromto(3, 1);
            fail();
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=" + 3 + " to=" + 1, e.getMessage());
        }
    }

    @Test
    public void verifyExceptionWhenFromEqualToTo() {
        try {
            PrimeGenerator gen = PrimeGenerator.getInstance();
            gen.fromto(1, 1);
            fail();
        } catch (RuntimeException e) {
            assertEquals("Wrong input values: from=" + 1 + " to=" + 1, e.getMessage());
        }
    }
}
