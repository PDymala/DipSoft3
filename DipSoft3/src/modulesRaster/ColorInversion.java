package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dip.Loader;
import dip.Pixel;

public class ColorInversion {

	private BufferedImage imageOut;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	/**
	 * Inverts the colors
	 * 
	 * @param imageIn
	 *            BufferedImage to be changed
	 * 
	 */
	public ColorInversion(BufferedImage imageIn) {
		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();
		
		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {
				loader.load(yPosition, imageIn.getHeight());
				
				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true));
				if (pixel.getColor().getAlpha() == 0) {

					continue;
				} else {
					int red = pixel.getColor().getRed(); // czytamy kolor RED piksela
					int green = pixel.getColor().getGreen(); // czytamy kolor GREEN piksela
					int blue = pixel.getColor().getBlue(); // czytamy kolor BLUE piksela
					int alpha = pixel.getColor().getAlpha();

					Color newColor = new Color(255 - red, 255 - green, 255 - blue, alpha);
					imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

				}

			}
		}
	}
}