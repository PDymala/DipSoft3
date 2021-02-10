package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dip.Loader;
import dip.Pixel;

public class ImageComperator {


private double numberOfSimilarPixels;
	/**
	 * Compares two pictures on the basis of each RGB parameter and every pixel. In this case, pictures have to be equal size. None can be rotated, moved etc.
	 * 
	 * @param imageIn1
	 *            BufferedImage 1
	 *            
	  @param imageIn2
	 *            BufferedImage 1
	 * 
	 * 
	 * 
	 * 
	 */
	public ImageComperator(BufferedImage imageIn1, BufferedImage imageIn2) {
		
		Loader loader = new Loader();
		
		for (int yPosition = 0; yPosition < imageIn1.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn1.getWidth(); xPosition++) {
				loader.load(yPosition, imageIn1.getHeight());
				
				Pixel pixel1 = new Pixel(xPosition, yPosition, new Color(imageIn1.getRGB(xPosition, yPosition), true));
				Pixel pixel2 = new Pixel(xPosition, yPosition, new Color(imageIn2.getRGB(xPosition, yPosition), true));
				
				
				if (pixel1.getColor().getRed() == pixel2.getColor().getRed()) {
					numberOfSimilarPixels++;
				}
				if (pixel1.getColor().getGreen() == pixel2.getColor().getGreen()) {
					numberOfSimilarPixels++;
				}
				if (pixel1.getColor().getBlue() == pixel2.getColor().getBlue()) {
					numberOfSimilarPixels++;
				}
				
				
				
				}


		}
		System.out.println("Comparison is: " + (numberOfSimilarPixels/3)/(imageIn1.getHeight() * imageIn1.getWidth()));
		
		
	}
}