package dip;

import java.awt.Color;

public class Pixel {

	private Color color;
	private double xPosition;
	private double yPosition;
	private int rgbSum;
	
	public int getRgbSum() {
		rgbSum = color.getRed() + color.getGreen() + color.getBlue();
		return rgbSum;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public double getxPosition() {
		return xPosition;
	}
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	public double getyPosition() {
		return yPosition;
	}
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public Pixel(double xPosition, double yPosition, Color color) {
		this.xPosition =  xPosition;
		this.yPosition = yPosition;
		this.color = color;
	}
}
