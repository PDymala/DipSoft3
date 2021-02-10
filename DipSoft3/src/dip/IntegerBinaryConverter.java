package dip;

import java.util.Arrays;

public class IntegerBinaryConverter {

	// wazne Arrays.toString(temp)
	
	

	/**
	 * Calculates the most optimum power with given base for  a number
	 * 
	 * @param number	number to check optimum power (e.g. 130 with base 2 optimum is 8 because 2^8 = 256 and it's bigger than 130, while 2^7 = 128 is smaller than 130.
	 * 
	 * @param base		base of power, e.g. 2^7 = 128 where 2 is base				
	 * 
	 * 
	 */
	public int optimumBase(int number, int base) {
		int x = 0;
		while (Math.pow(base, x) <= number) {
			x++;
			
		}
		return x;
	
	}
	/**
	 * Changes a number from integer into binary array in a form of [false, true, true] etc.
	 * 
	 * @param number	integer to be changed
	 * 
	 * @param base		base of power for calculation. E.g. 130 requires base 8 (array of 8 elements)
	 * 
	 * 
	 */
	public  Boolean[] intToBinary(int number, int base) {
		 //brakuje ochrony przed zbyt ma³¹ baz¹, tj np. 130 potrzebuje base 8 (bo 2^7 to 128 a w^8 to 256). Jak bedzie zbyt ma³a baza to bedzie sie powtarzac
		 // a moze wybor optymalnej bazy?
	    final Boolean[] ret = new Boolean[base];
	    for (int i = 0; i < base; i++) {
	        ret[base - 1 - i] = (1 << i & number) != 0;
	    }
	    return ret;
	}
	/**
	 * Funkcja odwraca tablice! dlaczego!?
	 * 
	 */
	public int binaryArraytoInt(Boolean[] binaryArray) {
		int temp2 = 0;
		for(int i = 0; i < binaryArray.length / 2; i++)
		{
		    boolean temp = binaryArray[i];
		    binaryArray[i] = binaryArray[binaryArray.length - i - 1];
		    binaryArray[binaryArray.length - i - 1] = temp;
		}
		
		for (int x = 0; x < binaryArray.length; x++) {
			if(binaryArray[x] == true) {
				temp2 = (int) (temp2+ Math.pow(2, x));
			} 
			
		}
		return temp2;
	}
	
	
	
}
