package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dip.Loader;
import dip.Pixel;
import modulesRaster.imigmaColor.PixelCoding2;

public class ImigmaColor {

	private BufferedImage imageOut;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	/**
	 * Uses enigma coding method for hiding a given picture. To code or decode, same secret code has to be given. If a coded picture is altered, it cannot be decoded again. The algoryth is very slow.
	 *
	 * 
	 * @param imageIn
	 *            BufferedImage to be changed
	 * 
	 * @param code
	 * 			Secret code of 4 letters to code or decode the picture
	 * 
	 * 
	 * 
	 */
	int pixelNumber=0;
	public ImigmaColor(BufferedImage imageIn, String code) {
		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();
		
		
		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {

				loader.load(yPosition, imageIn.getHeight());
				
				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true));
				if (pixel.getColor().getAlpha() == 0) {

					continue;
				} else {
					
					
					
					PixelCoding2 pixelCodingRed= new PixelCoding2(Integer.toString(pixel.getColor().getRed()), pixelNumber, code);
					PixelCoding2 pixelCodingGreen= new PixelCoding2(Integer.toString(pixel.getColor().getGreen()), pixelNumber, code);
					PixelCoding2 pixelCodingBlue= new PixelCoding2(Integer.toString(pixel.getColor().getBlue()), pixelNumber, code);
					
			
					Color newColor = new Color(Integer.parseInt(pixelCodingRed.getOutputText()), Integer.parseInt(pixelCodingGreen.getOutputText()), Integer.parseInt(pixelCodingBlue.getOutputText()), pixel.getColor().getAlpha());
					imageOut.setRGB(xPosition, yPosition, newColor.getRGB());
					
					pixelNumber++;
				}
				
				
			}
		}
	}
}
