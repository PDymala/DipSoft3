package DigiCode2_primesFiles;

import java.awt.Color;
import java.util.HashMap;

public class NearestFromArray {

	private int staticNumber;
	public int getStaticNumber() {
		return staticNumber;
	}

	public void setStaticNumber(int staticNumber) {
		this.staticNumber = staticNumber;
	}

	public int getDynamicNumber() {
		return dynamicNumber;
	}

	public void setDynamicNumber(int dynamicNumber) {
		this.dynamicNumber = dynamicNumber;
	}

	private int dynamicNumber;
	

	private int distanceBetweenNumbers;


	public int getDistance() {
		
		distanceBetweenNumbers = Math.abs(getDynamicNumber()-getStaticNumber());
	//	System.out.println(getDynamicNumber() + "  |  " + getStaticNumber() +"  |  " + distanceBetweenNumbers );
		return distanceBetweenNumbers;
	}



	public NearestFromArray(int staticNumber, int dynamicNumber) {
		this.staticNumber = staticNumber;
		this.dynamicNumber = dynamicNumber;
	}
}
