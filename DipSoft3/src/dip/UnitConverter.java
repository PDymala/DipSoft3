package dip;

public class UnitConverter {

	public UnitConverter() {
	}
	
	

	/**
	 * Returns mm rounded to floor of given pixels
	 * 
	 * @param numberOfPixels number of pixels
	 * 
	 */
	public int pxToMm(int numberOfPixels) {
		//dpi??
		return (int) Math.floor(numberOfPixels*0.369);
	}
	
	/**
	 * Returns px rounded to floor of given mm
	 * 
	 * @param numberOfMm number of pixels
	 * 
	 */
	public int mmToPx(int numberOfMm) {
		//dpi??
		return (int) Math.floor(numberOfMm/0.369);
	}
	
}
