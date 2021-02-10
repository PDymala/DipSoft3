package modulesRaster.colorCounter;

import java.awt.Color;
import java.util.HashMap;

public class colorExistance {

	private Color color;
	private int existance;

	public colorExistance(Color color, int existance) {
		this.color = color;
		this.existance = existance;
	}

	public Color getColor() {
		return color;
	}

	public void addToExistance() {
		existance++;
	}

	public int getExistance() {
		return existance;
	}
}