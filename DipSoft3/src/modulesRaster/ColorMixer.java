package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dip.Loader;
import dip.Pixel;

public class ColorMixer {

	private BufferedImage imageOut;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	/**
	 * Changes the color of each pixel with given parameters
	 * 
	 * @param imageIn
	 *            BufferedImage to be changed
	 * 
	 * @param redChange
	 *            Value from -255 to 255 of given color to be changed
	 * @param blueChange
	 *            Value from -255 to 255 of given color to be changed
	 * @param greenChange
	 *            Value from -255 to 255 of given color to be changed
	 * 
	 * 
	 * 
	 */
	public ColorMixer(BufferedImage imageIn, int redChange, int greenChange, int blueChange) {
		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();
		
		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {

				loader.load(yPosition, imageIn.getHeight());
				
				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true));
				if (pixel.getColor().getAlpha() == 0) {

					continue;
				} else {
					int red = pixel.getColor().getRed() + redChange; // czytamy kolor RED piksela
					int green = pixel.getColor().getGreen() + greenChange; // czytamy kolor GREEN piksela
					int blue = pixel.getColor().getBlue() + blueChange; // czytamy kolor BLUE piksela
					int alpha = pixel.getColor().getAlpha();

					// Kolory nie mog� by� mniejsze ni� 0 i wieksze niz 255 ( mozliwe jest 256
					// kolorow) 16bit!
					if (red > 255) {
						red = 255;
					}
					if (red < 0) {
						red = 0;
					}

					if (green > 255) {
						green = 255;
					}
					if (green < 0) {
						green = 0;
					}

					if (blue > 255) {
						blue = 255;
					}
					if (blue < 0) {
						blue = 0;
					}

					Color newColor = new Color(red, green, blue, alpha);
					imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

				}

			}
		}
	}
}
