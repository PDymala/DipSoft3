package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dip.Loader;
import dip.Pixel;

public class ColorShift {

	private BufferedImage imageOut;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	public enum ColorType {
		REDANDGREEN, GREENANDBLUE, REDANDBLUE, RANDOM;
	}

	/**
	 * Changes the color of each pixel with given parameters. Contrast barier is 50%
	 * as default.
	 * 
	 * @param imageIn  BufferedImage to be changed
	 * 
	 * @param contrast % value of contrast to change
	 * 
	 * 
	 * 
	 * 
	 */
	public ColorShift(BufferedImage imageIn, ColorType colorType) {
		// konstruktor danej klasy
		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();

		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			// p�tla dla ka�dego nowego piksela na wysoko�� za�adowanego obrazu
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {
				// p�tla dla ka�dego nowego piksela na szeroko�� za�adowanego obrazu

				loader.load(yPosition, imageIn.getHeight());
				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true));
				if (pixel.getColor().getAlpha() == 0) {

					continue;
				} else {
					Color newColor = null;
					if (colorType == ColorType.REDANDBLUE) {
						newColor = new Color(pixel.getColor().getBlue(), pixel.getColor().getGreen(),
								pixel.getColor().getRed());

					} else if (colorType == ColorType.REDANDGREEN) {
						newColor = new Color(pixel.getColor().getGreen(), pixel.getColor().getRed(),
								pixel.getColor().getBlue());
					} else if (colorType == ColorType.GREENANDBLUE) {
						newColor = new Color(pixel.getColor().getRed(), pixel.getColor().getBlue(),
								pixel.getColor().getGreen());

					} else if (colorType == ColorType.RANDOM) {

						int number = (int) (Math.random() * 3);

						
						
						switch (number) {
						case 0: {
							newColor = new Color(pixel.getColor().getBlue(), pixel.getColor().getGreen(),
									pixel.getColor().getRed());
						}

						case 1: {
							newColor = new Color(pixel.getColor().getGreen(), pixel.getColor().getRed(),
									pixel.getColor().getBlue());
						}
						case 2: {
							newColor = new Color(pixel.getColor().getRed(), pixel.getColor().getBlue(),
									pixel.getColor().getGreen());
						}
						}

					}

					imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

				}
			}
		}

	}

}
