package dip;

public class DrawingCounter {

	private int numberOfDrawings = 0;

	public DrawingCounter() {

	}

	public void addDrawing() {
		numberOfDrawings = numberOfDrawings + 1;
	}

	public int getNumberOfDrawings() {
		return numberOfDrawings;
	}
	
	public String toString() {
		return "Number of drawings: " + numberOfDrawings;
	}

}
