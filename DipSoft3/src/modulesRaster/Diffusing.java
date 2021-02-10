package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

import dip.Loader;
import dip.Pixel;

public class Diffusing {

	private BufferedImage imageOut;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	/**
	 * Changes given image with dithering filter into 1 byte image. Pixel is changed
	 * into black if its rgb value is smaller than a random, 0-765 value
	 *
	 * @param imageIn       BufferedImage to be changed
	 *
	 * @param DitheringType thresholding value, random or pseudorandom
	 *
	 *
	 * @param heightSkip    Diluting the filter in Y direction
	 *
	 * @param weightSkip    Diluting the filter in X direction
	 *
	 * @param size          size of dithering dots
	 *
	 * 
	 */

	public Diffusing(BufferedImage imageIn, int matrixHeight, int matrixWeight, int skip) {

	//	imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		imageOut = imageIn;
		Loader loader = new Loader();

		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition = yPosition + skip) {
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition = xPosition + skip) {

				loader.load(yPosition, imageIn.getHeight());
				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition)));

				if (pixel.getColor().getAlpha() == 0) {

					continue;
				} else {

					int newXPosition = (int) (Math.random() * matrixWeight * 2) - matrixWeight +xPosition;
					int newYPosition = (int) (Math.random() * matrixHeight * 2) - matrixHeight + yPosition;

					if (newXPosition >= imageOut.getWidth() || newXPosition<0 || newYPosition >= imageOut.getHeight() || newYPosition < 0) {
						continue;
					}
					
					
					// Color newColor = new Color(255, 255, 255,0); // bia�y
					imageOut.setRGB( newXPosition, newYPosition, pixel.getColor().getRGB());

				}
			}

			///////////////////////////

		}
	}

}
