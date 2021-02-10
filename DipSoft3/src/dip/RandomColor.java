package dip;

import java.awt.Color;

public class RandomColor {
	
	Color color;
	Color[] colorSet;
	public RandomColor() {	}

	public Color getColor() {
		return new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255) );
	}
	
	public Color[] getColorSet(int size) {
		colorSet = new Color[size];
		for (int x = 0; x<size; x++) {
			
			
			colorSet[x] = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		}
		return colorSet;
	}
	
}
