package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import dip.Loader;
import dip.Pixel;

public class Blurr2 {

	private BufferedImage imageOut;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	public enum TypeOfBlurr {
		MEAN, GAUSSIAN, USERDEFINED
	}

	private int[] meanBlurrMatrix = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
	private int[] gaussianBlurrMatrix = new int[] { 1, 5, 1, 5, 1, 5, 1, 5, 1 };

	/**
	 * Blurrs the image with a filter. Each pixel is an average of surrounding
	 * pixels including weights of each position.
	 * 
	 * @param imageIn
	 *            BufferedImage to be changed
	 * @param typeOfBlurr
	 *            Predefined filters, e.g. MEAN (each pixels weights 1)
	 * 
	 */

	public Blurr2(BufferedImage imageIn, TypeOfBlurr typeOfBlurr) {

		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();
		
		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {

			// pêtla dla ka¿dego nowego piksela na wysokoœæ za³adowanego obrazu
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {
				loader.load(yPosition, imageIn.getHeight());
				
				// pêtla dla ka¿dego nowego piksela na szerokoœæ za³adowanego obrazu
				HashMap<Integer, Pixel> pixele = new HashMap<Integer, Pixel>();

				int temp = 0;
				for (int pY = -1; pY < 2; pY++) {

					// pêtla dla ka¿dego nowego piksela na wysokoœæ za³adowanego obrazu
					for (int pX = -1; pX < 2; pX++) {

						if (pX + xPosition < 0 || pX + xPosition + 1 > imageIn.getWidth() || pY + yPosition < 0
								|| pY + yPosition + 1 > imageIn.getHeight()) {
							pixele.put(temp, null);
						} else {
							pixele.put(temp, new Pixel(pX + xPosition, pY + yPosition,
									new Color(imageIn.getRGB(pX + xPosition, pY + yPosition), true)));
						}
						temp++;
					}
				}

				int avRed = 0;
				int avGreen = 0;
				int avBlue = 0;

				if (typeOfBlurr == TypeOfBlurr.MEAN) {
					int weightSum = 0;
					for (int x = 0; x < pixele.size(); x++) {

						if (pixele.get(x) == null) {
							continue;
						} else {
							avRed = avRed + pixele.get(x).getColor().getRed();
							weightSum = weightSum + meanBlurrMatrix[x];
						}

					}
					avRed = avRed / weightSum;

					for (int x = 0; x < pixele.size(); x++) {

						if (pixele.get(x) == null) {
							continue;
						} else {
							avGreen = avGreen + pixele.get(x).getColor().getGreen();

						}

					}
					avGreen = avGreen / weightSum;

					for (int x = 0; x < pixele.size(); x++) {

						if (pixele.get(x) == null) {
							continue;
						} else {
							avBlue = avBlue + pixele.get(x).getColor().getBlue();

						}

					}
					avBlue = avBlue / weightSum;

				}

				else if (typeOfBlurr == TypeOfBlurr.GAUSSIAN) {

					int weightSum = 0;
					for (int x = 0; x < pixele.size(); x++) {

						if (pixele.get(x) == null) {
							continue;
						} else {
							avRed = avRed + pixele.get(x).getColor().getRed() * gaussianBlurrMatrix[x];
							weightSum = weightSum + gaussianBlurrMatrix[x]; // tylko raz zliczamy ile jest pikseli nie
																			// trzeba przy kazdym kolorze
						}

					}
					avRed = avRed / weightSum;

					for (int x = 0; x < pixele.size(); x++) {

						if (pixele.get(x) == null) {
							continue;
						} else {
							avGreen = avGreen + pixele.get(x).getColor().getGreen() * gaussianBlurrMatrix[x];

						}

					}
					avGreen = avGreen / weightSum;

					for (int x = 0; x < pixele.size(); x++) {

						if (pixele.get(x) == null) {
							continue;
						} else {
							avBlue = avBlue + pixele.get(x).getColor().getBlue() * gaussianBlurrMatrix[x];

						}

					}
					avBlue = avBlue / weightSum;

				}

				Color newColor = new Color(avRed, avGreen, avBlue, pixele.get(4).getColor().getAlpha());
				imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

			}

		}

	}

	/**
	 * Blurrs the image with a filter. Each pixel is an average of surrounding
	 * pixels including weights of each position.
	 * 
	 * @param imageIn
	 *            BufferedImage to be changed
	 * @param customMatrix
	 *            Userdefined weight matrix. Starts from top left and goes right and
	 *            next row
	 * 
	 */
	public Blurr2(BufferedImage imageIn, int[] customMatrix) {

		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();
		
		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {

			// pêtla dla ka¿dego nowego piksela na wysokoœæ za³adowanego obrazu
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {
				loader.load(yPosition, imageIn.getHeight());
				
				// pêtla dla ka¿dego nowego piksela na szerokoœæ za³adowanego obrazu
				HashMap<Integer, Pixel> pixele = new HashMap<Integer, Pixel>();

				int temp = 0;
				for (int pY = -1; pY < 2; pY++) {

					// pêtla dla ka¿dego nowego piksela na wysokoœæ za³adowanego obrazu
					for (int pX = -1; pX < 2; pX++) {

						if (pX + xPosition < 0 || pX + xPosition + 1 > imageIn.getWidth() || pY + yPosition < 0
								|| pY + yPosition + 1 > imageIn.getHeight()) {
							pixele.put(temp, null);
						} else {
							pixele.put(temp, new Pixel(pX + xPosition, pY + yPosition,
									new Color(imageIn.getRGB(pX + xPosition, pY + yPosition), true)));
						}
						temp++;
					}
				}

				int avRed = 0;
				int avGreen = 0;
				int avBlue = 0;

				int weightSum = 0;
				for (int x = 0; x < pixele.size(); x++) {

					if (pixele.get(x) == null) {
						continue;
					} else {
						avRed = avRed + pixele.get(x).getColor().getRed() * customMatrix[x];
						weightSum = weightSum + customMatrix[x]; // tylko raz zliczamy ile jest pikseli nie
																		// trzeba przy kazdym kolorze
					}

				}
				avRed = avRed / weightSum;

				for (int x = 0; x < pixele.size(); x++) {

					if (pixele.get(x) == null) {
						continue;
					} else {
						avGreen = avGreen + pixele.get(x).getColor().getGreen() * customMatrix[x];

					}

				}
				avGreen = avGreen / weightSum;

				for (int x = 0; x < pixele.size(); x++) {

					if (pixele.get(x) == null) {
						continue;
					} else {
						avBlue = avBlue + pixele.get(x).getColor().getBlue() * customMatrix[x];

					}

				}
				avBlue = avBlue / weightSum;

				Color newColor = new Color(avRed, avGreen, avBlue, pixele.get(4).getColor().getAlpha());
				imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

			}

		}

	}
	/**
	 * Blurrs the image with a filter. Each pixel is an average of surrounding
	 * pixels including weights of each position. Size (strenght) of blurr can be defined
	 * 
	 * @param imageIn
	 *            BufferedImage to be changed
	 * @param customMatrix
	 *            Userdefined weight matrix. Starts from top left and goes right and
	 *            next row
	 * @param
	 * 		  size
	 * 			  User defined size of matrix of surrounding pixels that affects the middle one. Has to match customMatrix numer of elements and be uneven
	 * 
	 */
	

	
	public Blurr2(BufferedImage imageIn, int[] customMatrix, int size) {

		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();
		
		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {

			// pêtla dla ka¿dego nowego piksela na wysokoœæ za³adowanego obrazu
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {
				loader.load(yPosition, imageIn.getHeight());
				
				// pêtla dla ka¿dego nowego piksela na szerokoœæ za³adowanego obrazu
				HashMap<Integer, Pixel> pixele = new HashMap<Integer, Pixel>();

				int temp = 0;
				for (int pY = -((int) size/2); pY < (Math.ceil(size/2))+1; pY++) {

					// pêtla dla ka¿dego nowego piksela na wysokoœæ za³adowanego obrazu
					for (int pX = -((int) size/2); pX < (Math.ceil(size/2))+1; pX++) {

						if (pX + xPosition < 0 || pX + xPosition + 1 > imageIn.getWidth() || pY + yPosition < 0
								|| pY + yPosition + 1 > imageIn.getHeight()) {
							pixele.put(temp, null);
						} else {
							pixele.put(temp, new Pixel(pX + xPosition, pY + yPosition,
									new Color(imageIn.getRGB(pX + xPosition, pY + yPosition), true)));
						}
						temp++;
					}
				}

				int avRed = 0;
				int avGreen = 0;
				int avBlue = 0;

				int weightSum = 0;
				for (int x = 0; x < pixele.size(); x++) {

					if (pixele.get(x) == null) {
						continue;
					} else {
						avRed = avRed + pixele.get(x).getColor().getRed() * customMatrix[x];
						weightSum = weightSum + customMatrix[x]; // tylko raz zliczamy ile jest pikseli nie
																		// trzeba przy kazdym kolorze
					}

				}
				avRed = avRed / weightSum;

				for (int x = 0; x < pixele.size(); x++) {

					if (pixele.get(x) == null) {
						continue;
					} else {
						avGreen = avGreen + pixele.get(x).getColor().getGreen() * customMatrix[x];

					}

				}
				avGreen = avGreen / weightSum;

				for (int x = 0; x < pixele.size(); x++) {

					if (pixele.get(x) == null) {
						continue;
					} else {
						avBlue = avBlue + pixele.get(x).getColor().getBlue() * customMatrix[x];

					}

				}
				avBlue = avBlue / weightSum;

				Color newColor = new Color(avRed, avGreen, avBlue, pixele.get(12).getColor().getAlpha());
				imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

			}

		}

	}
}