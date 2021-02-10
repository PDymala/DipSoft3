package dip;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class PrimeNumberGenerator {

public boolean isPrime(int number) {
		return number > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(number)).noneMatch(n -> (number % n == 0));
	}

	ArrayList<Integer> primeArray = new ArrayList<>();
	
	
	
	public PrimeNumberGenerator() {

	}

public ArrayList<Integer> getSpecificNUmberOfPrimes(int numberOfPrimes) {
	

	for (int x = 2; primeArray.size() < numberOfPrimes; x++) {
		
		if (isPrime(x)) {
			
			primeArray.add(x);	}
		
	}
	return primeArray;
}


public ArrayList<Integer>  getPrimesSmallerThanANumber(int number) {
	
	
	
	for (int x = 2; x<number; x++) {
		
		if (isPrime(x)) {
			
			primeArray.add(x);	}
		
	}
	return primeArray;
}

	
	



}