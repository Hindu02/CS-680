package edu.umb.cs680.hw02;

import java.util.Iterator;
import java.util.LinkedList;

public class PrimeGenerator {

	private static PrimeGenerator gen = null;
	protected static long FROM, TO;
	private PrimeGenerator() {}
	protected LinkedList<Long> primes = new LinkedList<Long>();

	public static PrimeGenerator getInstance() {
		if (gen == null) {
			gen = new PrimeGenerator();
		}
		return gen;
	}
	public void fromto(long from, long to){
		if (from >= 1 && to > from) {
			FROM = from;
			TO = to;
		} else {
			throw new RuntimeException("Wrong input values: from=" + from + " to=" + to);
		}
	}


	public LinkedList<Long> getPrimes() {
		return primes;
	};

	protected boolean isEven(long n) {
		if (n % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	protected boolean isPrime(long n) {
		// 1 or lower numbers are not prime.
		if (n <= 1) {
			return false;
		}
		// Even numbers are not prime, except for 2.
		if (n > 2 && isEven(n)) {
			return false;
		}
		long i;
		// Find a number "i" that can divide "n"
		for (i = (long) Math.sqrt(n); n % i != 0 && i >= 1; i--) {
		}
		// If such a number "i" is found, n is not prime. Otherwise, n is prime.
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void generatePrimes() {
		primes.clear();
		for (long n = FROM; n <= TO; n++) {
			if (isPrime(n)) {
				primes.add(n);
			}
		}
	}

	public static void main(String[] args) {
		PrimeGenerator gen = PrimeGenerator.getInstance();
		gen.fromto(1,100);
		gen.generatePrimes();
		LinkedList<Long> primes = gen.getPrimes();
		Iterator<Long> it = primes.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
		System.out.println("\n" + gen.getPrimes().size() + " primes are found.");
	}
}