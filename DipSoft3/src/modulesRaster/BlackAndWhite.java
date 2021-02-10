package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Collections;

import dip.Loader;
import dip.Pixel;

// ok

public class BlackAndWhite {


	private BufferedImage imageIn;
	private BufferedImage imageOut;
	
	
	
	/**
	 * Black and white conversion
	 * 
	 * @param imageIn BufferedImage to be loaded
	 * 
	 * 
	 */
	public BlackAndWhite(BufferedImage imageIn) {
		this.imageIn = imageIn;
	}
	
	

	public enum Method {
		rootMeanSquare, average, lightness, luminosity;
	}
	
	
	/**
	 * Changes given image into black and white color space
	 *
	 * @param method
	 *            type of color conversion (BlackAndWhite.Method enum). If no knowledge is had, take luminosity
	 * 
	 * @return image after black and white conversion, BufferendImage class
	 */
	
	public BufferedImage getBlackAndWhiteImage(Method method) {

		

		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();
		
		
		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {
				loader.load(yPosition, imageIn.getHeight());
				
				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true));
				if (pixel.getColor().getAlpha() == 0) {

					continue;
				} else {

					int red = pixel.getColor().getRed();
					int green = pixel.getColor().getGreen();
					int blue = pixel.getColor().getBlue();
					int alpha = pixel.getColor().getAlpha();
					int rgb = 0;

					if (method == Method.luminosity) {

						rgb = (int) (red * 0.2126 + green * 0.7152 + blue * 0.0722);

					}

					else if (method == Method.average) {

						rgb = (red + green + blue) / 3;

					}

					else if (method == Method.rootMeanSquare) {

						rgb = (int) (Math.sqrt((Math.pow(red, 2) + Math.pow(green, 2) + Math.pow(blue, 2))));

						if (rgb > 255) {
							rgb = 255;
						}

					}

					else if (method == Method.lightness) {

						Integer[] rgbList = { red, green, blue };

						int min = (int) Collections.min(Arrays.asList(rgbList));
						int max = (int) Collections.max(Arrays.asList(rgbList));

						rgb = (int) (0.5 * (max + min));

					}

					Color newColor = new Color(rgb, rgb, rgb, alpha);
					imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

				}

			}
		}

		return imageOut;
	}

}
