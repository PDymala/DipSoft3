package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

import dip.Loader;
import dip.Pixel;

public class Dithering2 {

	private BufferedImage imageOut;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	public enum DitheringType {
		RANDOM, PSEUDORANDOM;
	}

	
	/**
	 * Changes given image with dithering filter into 1 byte image. Pixel is changed into black if its rgb value is smaller than a random, 0-765 value
	 *
	 * @param imageIn
	 *            BufferedImage to be changed
	 *
	 * @param DitheringType
	 *            thresholding value, random or pseudorandom
	 *
	 *
	 * @param heightSkip
	 *           Diluting the filter in Y direction
	 *
	 * @param weightSkip
	 *           Diluting the filter in X direction
	 *
	 * @param size
	 *            size of dithering dots
	 *

	 */
	
	public Dithering2(BufferedImage imageIn, DitheringType type, int heightSkip, int weightSkip, int size) {

		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();
		
		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition = yPosition + heightSkip + size) {
			// p�tla dla ka�dego nowego piksela na wysoko�� za�adowanego obrazu
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition = xPosition + weightSkip + size) {

				loader.load(yPosition, imageIn.getHeight());
					// p�tla dla ka�dego nowego piksela na szeroko�� za�adowanego obrazu
				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition)));

				if (pixel.getColor().getAlpha() == 0) {

					continue;
				} else {

					if (type == DitheringType.RANDOM) {
						Random rand = new Random(); // �adujemy klas� RANDOM
						int x = rand.nextInt(765); // losujemy liczb� mi�dzy 0 a 765 (maksimum dla maksymalnych warto�ci
													// RED GREEN i BLUE
						for (int tempX = 0; tempX < size; tempX++) {
							for (int tempY = 0; tempY < size; tempY++) {

								if (pixel.getRgbSum() < x) {
									Color newColor = new Color(0, 0, 0,255); // czarny
									imageOut.setRGB(xPosition + tempX, yPosition + tempY, newColor.getRGB());

								} else {
									Color newColor = new Color(255, 255, 255,0); // bia�y
									imageOut.setRGB(xPosition + tempX, yPosition + tempY, newColor.getRGB());

								}
							}
						}

					} else if (type == DitheringType.PSEUDORANDOM) {

						if (pixel.getRgbSum() < 50) {
							Random rand = new Random();
							int x = rand.nextInt(9);
							for (int tempX = 0; tempX < size; tempX++) {
								for (int tempY = 0; tempY < size; tempY++) {

									// losujemy kolor w proporcji czarny = 90% bia�y = 20%
									if (x == 8 || x == 9 || x == 6 || x == 3 || x == 5 || x == 2 || x == 7 || x == 1
											|| x == 0) {

										Color newColor = new Color(0, 0, 0,255); // czarny
										imageOut.setRGB(xPosition + tempX, yPosition + tempY, newColor.getRGB());

									} else {
										// x = 4
										Color newColor = new Color(255, 255, 255,0); // bia�y
										imageOut.setRGB(xPosition + tempX, yPosition + tempY, newColor.getRGB());

									}
								}
							}
						}
						if (pixel.getRgbSum() > 51 && pixel.getRgbSum() < 300) {
							Random rand = new Random();
							int x = rand.nextInt(9);
							for (int tempX = 0; tempX < size; tempX++) {
								for (int tempY = 0; tempY < size; tempY++) {

									// losujemy kolor w proporcji czarny = 50% bia�y = 50%
									if (x == 9 || x == 3 || x == 5 || x == 2 || x == 7) {
										Color newColor = new Color(0, 0, 0,255); // czarny
										imageOut.setRGB(xPosition + tempX, yPosition + tempY, newColor.getRGB());

									} else {
										// x = 1, 4, 0, 6, 8
										Color newColor = new Color(255, 255, 255,0); // bia�y
										imageOut.setRGB(xPosition + tempX, yPosition + tempY, newColor.getRGB());

									}
								}
							}
						} else {

							for (int tempX = 0; tempX < size; tempX++) {
								for (int tempY = 0; tempY < size; tempY++) {

									Color newColor = new Color(255, 255, 255,0); // bia�y
									imageOut.setRGB(xPosition + tempX, yPosition + tempY, newColor.getRGB());
								}
							}
						}
					}

					///////////////////////////

				}

			}
		}

	}

}
