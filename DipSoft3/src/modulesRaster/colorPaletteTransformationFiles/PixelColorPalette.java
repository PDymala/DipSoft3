package modulesRaster.colorPaletteTransformationFiles;

import java.awt.Color;
import java.util.HashMap;

public class PixelColorPalette {

	private Color colorStatic;
	private Color colorDynamic;
	public Color getColorDynamic() {
		return colorDynamic;
	}

	public void setColorDynamic(Color colorDynamic) {
		this.colorDynamic = colorDynamic;
	}

	private double xPosition;
	private double yPosition;
	private int rgbSum;
	private int distanceToColor;



	public int getDistanceToColorByRGBDistance() {
		
		distanceToColor = Math.abs(colorStatic.getRed() - colorDynamic.getRed()) + Math.abs(colorStatic.getGreen() - colorDynamic.getGreen()) + Math.abs(colorStatic.getBlue() - colorDynamic.getBlue());
		
		return distanceToColor;
	}

	public int getDistanceToColorByPythagoraDistance() {
		
	//	distanceToColor = Math.abs(colorStatic.getRed() - colorDynamic.getRed()) + Math.abs(colorStatic.getGreen() - colorDynamic.getGreen()) + Math.abs(colorStatic.getBlue() - colorDynamic.getBlue());
		distanceToColor = (int) Math.sqrt(Math.pow(colorStatic.getRed() - colorDynamic.getRed(),2) + Math.pow(colorStatic.getGreen() - colorDynamic.getGreen(),2) +Math.pow(colorStatic.getBlue() - colorDynamic.getBlue(),2)  );
		
		
		return distanceToColor;
	}

	public int getRgbSum() {
		rgbSum = colorStatic.getRed() + colorStatic.getGreen() + colorStatic.getBlue();
		return rgbSum;
	}

	public Color getColorStatic() {
		return colorStatic;
	}

	public void setColor(Color color) {
		this.colorStatic = color;
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

	public PixelColorPalette(double xPosition, double yPosition, Color colorStatic, Color colorDynamic) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.colorStatic = colorStatic;
		this.colorDynamic = colorDynamic;
	}
}
