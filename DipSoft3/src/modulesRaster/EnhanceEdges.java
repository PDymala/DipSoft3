package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dip.Loader;
import dip.Pixel;

public class EnhanceEdges {

	private BufferedImage imageOut;

	public BufferedImage getImageOut() {
		return imageOut;
	}
	/**
	 * Enhance endges
	 * 
	 * @param imageIn BufferedImage to be changed
	 * 
	 * 
	 */
	public EnhanceEdges(BufferedImage imageIn, int grid) {
		Loader loader = new Loader();

		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {

				loader.load(yPosition, imageIn.getHeight());

				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true));
				if (pixel.getColor().getAlpha() == 0) {

					continue;
				} else {

					Color newColor = new Color(0,0,0,255);
					
					
					
					
					imageOut.setRGB(xPosition-1, yPosition-1, newColor.getRGB());		
					imageOut.setRGB(xPosition-1, yPosition, newColor.getRGB());
					imageOut.setRGB(xPosition, yPosition-1, newColor.getRGB());		
					
					imageOut.setRGB(xPosition+1, yPosition+1, newColor.getRGB());		
					imageOut.setRGB(xPosition-1, yPosition, newColor.getRGB());
					imageOut.setRGB(xPosition, yPosition-1, newColor.getRGB());		
					
					
					imageOut.setRGB(xPosition, yPosition, newColor.getRGB());
					imageOut.setRGB(xPosition, yPosition, newColor.getRGB());
				
				
				
				}

			}
		}
		


	}
}
