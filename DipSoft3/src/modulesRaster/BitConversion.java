package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Collections;

import dip.Loader;
import dip.Pixel;

// Po prostu zawê¿a do do mniejszei ilosci bitów czyli robi ciemniejszy obraz
// bez sensu :D

public class BitConversion {


	private BufferedImage imageIn;
	private BufferedImage imageOut;
	
	
	
	/**
	 * Black and white conversion
	 * 
	 * @param imageIn BufferedImage to be loaded
	 * 
	 * 
	 */
	public BitConversion(BufferedImage imageIn) {
		this.imageIn = imageIn;
	}
	
	
	/**
	 * Changes given image into black and white color space
	 *
	 * @param method
	 *            type of color conversion (BlackAndWhite.Method enum). If no knowledge is had, take luminosity
	 * 
	 * @return image after black and white conversion, BufferendImage class
	 */
	
	public BufferedImage getBlackAndWhiteImage(int numberOfOutputBits) {

		

		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();
		
		
		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {
				loader.load(yPosition, imageIn.getHeight());
				
				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true));
				

					double red = pixel.getColor().getRed();
					double green = pixel.getColor().getGreen();
					double blue = pixel.getColor().getBlue();
					
					
					double redPercent =red / 256; 
					double greenPercent =green / 256; 
					double bluePercent = blue / 256; 
					
					
					
					int redFin =  (int) (Math.pow(2, numberOfOutputBits) * redPercent);
					int greenFin = (int)(Math.pow(2, numberOfOutputBits) * greenPercent);
					int blueFin = (int)(Math.pow(2, numberOfOutputBits) * bluePercent);
					

					if (redFin > Math.pow(2, numberOfOutputBits)) redFin = (int) Math.pow(2, numberOfOutputBits)-1;
					if (greenFin > Math.pow(2, numberOfOutputBits)) greenFin = (int)Math.pow(2, numberOfOutputBits)-1;
					if (blueFin > Math.pow(2, numberOfOutputBits)) blueFin = (int)Math.pow(2, numberOfOutputBits)-1;
					 
					Color newColor = new Color(redFin, greenFin, blueFin);
					imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

				}

			
		}

		return imageOut;
	}

}
