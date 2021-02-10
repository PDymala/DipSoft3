package modulesRaster;
//Changed into return
import java.awt.Color;
import java.awt.image.BufferedImage;

import dip.Loader;
import dip.Pixel;

public class AveragePixel {

	private int avRed;
	private int avGreen;
	private int avBlue;
	private int avAlpha;
	private int numberOfPixels;

	private BufferedImage imageIn;

	
	/**
	 * Average pixel
	 * 
	 * @param imageIn BufferedImage to be loaded
	 * 
	 * 
	 */
	public AveragePixel(BufferedImage imageIn) {
		this.imageIn = imageIn;
	}
	

	
	/**
	 * Get average color without taking transparent pixels into equation
	 * 
	 * @return average color, Color class
	 * 
	 */
	public Color getAverageColorExcludeTransparentPixels() {
		Loader loader = new Loader();

		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {

				loader.load(yPosition, imageIn.getHeight());

				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true));
				if (pixel.getColor().getAlpha() == 0) {

					continue;
				} else {

					avRed = avRed +pixel.getColor().getRed(); 
					avGreen = avGreen+pixel.getColor().getGreen(); 
					avBlue = avBlue+pixel.getColor().getBlue(); 
					numberOfPixels++;
				}

			}
		}
		
		avRed = (int)(avRed/(numberOfPixels));
		avGreen = (int)(avGreen/(numberOfPixels));
		avBlue = (int)(avBlue/(numberOfPixels));
		
		return new Color(avRed, avGreen, avBlue);

	}
	

	/**
	 * Get average color without taking transparent pixels into equation
	 *  
	 * 
	 */
	public Color getAverageColorIncludeTransparentPixels() {
		Loader loader = new Loader();

		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {

				loader.load(yPosition, imageIn.getHeight());

				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true));
				
					avRed = avRed +pixel.getColor().getRed(); 
					avGreen = avGreen+pixel.getColor().getGreen(); 
					avBlue = avBlue+pixel.getColor().getBlue(); 
					avAlpha = avAlpha + pixel.getColor().getAlpha();
					numberOfPixels++;
				}

			
		}
		
		avRed = (int)(avRed/(numberOfPixels));
		avGreen = (int)(avGreen/(numberOfPixels));
		avBlue = (int)(avBlue/(numberOfPixels));
		avAlpha = (int)(avAlpha/(numberOfPixels));
		
		return new Color(avRed, avGreen, avBlue, avAlpha);

	}
}
