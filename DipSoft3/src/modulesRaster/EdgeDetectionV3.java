package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import dip.Loader;
import dip.Pixel;

public class EdgeDetectionV3 {

	private BufferedImage imageOut;
	private EdgeDirection eG;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	private int[] sobelX = new int[] { -1, 0, 1, -2, 0, 2, -1, 0, 1 };
	private int[] sobelY = new int[] { -1, -2, -1, 0, 0, 0, 1, 2, 1 };

	public enum EdgeDirection {
		HORIZONTAL, VERTICAL, BOTH
	}

	public enum ColorOutput {
		ONEBIT, FULLCOLOR, AVERAGE
	}

	/**
	 * Checks for edges on the image and draws them in black color. TIP: If the
	 * picture is blurred before edge detection, the result will be better
	 * 
	 * @param imageIn
	 *            BufferedImage to be changed
	 * @param sensitivity
	 *            sensitivity of edge detection
	 * 
	 */

	public EdgeDetectionV3(BufferedImage imageIn, int sensitivity) {
		eG = EdgeDirection.BOTH;
		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);

		Loader loader = new Loader();

		for (int yPosition = 0; yPosition < imageIn.getHeight() - 3; yPosition++) {

			// p�tla dla ka�dego nowego piksela na wysoko�� za�adowanego obrazu
			for (int xPosition = 0; xPosition < imageIn.getWidth() - 3; xPosition++) {

				loader.load(yPosition, imageIn.getHeight());

				HashMap<Integer, Pixel> pixele = new HashMap<Integer, Pixel>();

				int temp = 0;
				for (int pY = 0; pY < 3; pY++) {

					// p�tla dla ka�dego nowego piksela na wysoko�� za�adowanego obrazu
					for (int pX = 0; pX < 3; pX++) {

						if (pX + xPosition < 0 || pX + xPosition + 1 > imageIn.getWidth() || pY + yPosition < 0
								|| pY + yPosition + 1 > imageIn.getHeight()) {
							pixele.put(temp, new Pixel(pX + xPosition, pY + yPosition, new Color(0, 0, 0, 0)));
						} else {
							pixele.put(temp, new Pixel(pX + xPosition, pY + yPosition,
									new Color(imageIn.getRGB(pX + xPosition, pY + yPosition), true)));
						}
						temp++;
					}
				}

				int sobelXSum = 0;
				for (int x = 0; x < pixele.size(); x++) {

					if (pixele.get(x) == null) {
						continue;
					} else {
						sobelXSum = sobelXSum + (pixele.get(x).getRgbSum() / 3 * sobelX[x]);

					}

				}

				int sobelYSum = 0;
				for (int x = 0; x < pixele.size(); x++) {

					if (pixele.get(x) == null) {
						continue;
					} else {
						sobelYSum = sobelYSum + (pixele.get(x).getRgbSum() / 3 * sobelY[x]);

					}

				}

				int sobelSq = 0;

				if (eG == EdgeDirection.BOTH) {
					sobelSq = (int) Math.sqrt(sobelXSum * sobelXSum + sobelYSum * sobelYSum);
				} else if (eG == EdgeDirection.HORIZONTAL) {
					sobelSq = (int) sobelXSum;
				} else if (eG == EdgeDirection.VERTICAL) {
					sobelSq = (int) sobelYSum;
				}

				Color newColor;
				if (sobelSq > sensitivity) {
					sobelSq = 0;
					newColor = new Color(0, 0, 0, 255);
				} else {
					sobelSq = 255;
					newColor = new Color(sobelSq, sobelSq, sobelSq, 0);
				}

				imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

			}

		}

	}

	/**
	 * Checks for edges on the image and draws them in black color. TIP: If the
	 * picture is blurred before edge detection, the result will be better
	 * 
	 * @param imageIn
	 *            BufferedImage to be changed
	 * @param sensitivity
	 *            sensitivity of edge detection
	 * @param eG
	 *            direction of edges to be searched
	 */
	public EdgeDetectionV3(BufferedImage imageIn, int sensitivity, EdgeDirection eG) {
		this.eG = eG;
		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);

		Loader loader = new Loader();

		for (int yPosition = 0; yPosition < imageIn.getHeight() - 3; yPosition++) {

			// p�tla dla ka�dego nowego piksela na wysoko�� za�adowanego obrazu
			for (int xPosition = 0; xPosition < imageIn.getWidth() - 3; xPosition++) {

				loader.load(yPosition, imageIn.getHeight());

				HashMap<Integer, Pixel> pixele = new HashMap<Integer, Pixel>();

				int temp = 0;
				for (int pY = 0; pY < 3; pY++) {

					// p�tla dla ka�dego nowego piksela na wysoko�� za�adowanego obrazu
					for (int pX = 0; pX < 3; pX++) {

						if (pX + xPosition < 0 || pX + xPosition + 1 > imageIn.getWidth() || pY + yPosition < 0
								|| pY + yPosition + 1 > imageIn.getHeight()) {
							pixele.put(temp, new Pixel(pX + xPosition, pY + yPosition, new Color(0, 0, 0, 0)));
						} else {
							pixele.put(temp, new Pixel(pX + xPosition, pY + yPosition,
									new Color(imageIn.getRGB(pX + xPosition, pY + yPosition), true)));
						}
						temp++;
					}
				}

				int sobelXSum = 0;
				for (int x = 0; x < pixele.size(); x++) {

					if (pixele.get(x) == null) {
						continue;
					} else {
						sobelXSum = sobelXSum + (pixele.get(x).getRgbSum() / 3 * sobelX[x]);

					}

				}

				int sobelYSum = 0;
				for (int x = 0; x < pixele.size(); x++) {

					if (pixele.get(x) == null) {
						continue;
					} else {
						sobelYSum = sobelYSum + (pixele.get(x).getRgbSum() / 3 * sobelY[x]);

					}

				}

				int sobelSq = 0;

				if (eG == EdgeDirection.BOTH) {
					sobelSq = (int) Math.sqrt(sobelXSum * sobelXSum + sobelYSum * sobelYSum);
				} else if (eG == EdgeDirection.HORIZONTAL) {
					sobelSq = (int) sobelXSum;
				} else if (eG == EdgeDirection.VERTICAL) {
					sobelSq = (int) sobelYSum;
				}

				Color newColor;
				if (sobelSq > sensitivity) {
					sobelSq = 0;
					newColor = new Color(0, 0, 0, 255);
				} else {
					sobelSq = 255;
					newColor = new Color(sobelSq, sobelSq, sobelSq, 0);
				}

				imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

			}

		}

	}

	/**
	 * Checks for edges on the image and draws them in black color. TIP: If the
	 * picture is blurred before edge detection, the result will be better
	 * 
	 * @param imageIn
	 *            BufferedImage to be changed
	 * @param sensitivity
	 *            sensitivity of edge detection
	 * @param eG
	 *            direction of edges to be searched
	 * 
	 * @param colorOutput
	 *            Color output
	 * 
	 */
	public EdgeDetectionV3(BufferedImage imageIn, int sensitivity, EdgeDirection eG, ColorOutput colorOutput) {
		this.eG = eG;
		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);

		Loader loader = new Loader();

		for (int yPosition = 0; yPosition < imageIn.getHeight() - 3; yPosition++) {

			// p�tla dla ka�dego nowego piksela na wysoko�� za�adowanego obrazu
			for (int xPosition = 0; xPosition < imageIn.getWidth() - 3; xPosition++) {

				loader.load(yPosition, imageIn.getHeight());

				HashMap<Integer, Pixel> pixele = new HashMap<Integer, Pixel>();

				int temp = 0;
				for (int pY = 0; pY < 3; pY++) {

					// p�tla dla ka�dego nowego piksela na wysoko�� za�adowanego obrazu
					for (int pX = 0; pX < 3; pX++) {

						if (pX + xPosition < 0 || pX + xPosition + 1 > imageIn.getWidth() || pY + yPosition < 0
								|| pY + yPosition + 1 > imageIn.getHeight()) {
							pixele.put(temp, new Pixel(pX + xPosition, pY + yPosition, new Color(0, 0, 0, 0)));
						} else {
							pixele.put(temp, new Pixel(pX + xPosition, pY + yPosition,
									new Color(imageIn.getRGB(pX + xPosition, pY + yPosition), true)));
						}
						temp++;
					}
				}

				int sobelXSum = 0;
				for (int x = 0; x < pixele.size(); x++) {

					if (pixele.get(x) == null) {
						continue;
					} else {
						sobelXSum = sobelXSum + (pixele.get(x).getRgbSum() / 3 * sobelX[x]);

					}

				}

				int sobelYSum = 0;
				for (int x = 0; x < pixele.size(); x++) {

					if (pixele.get(x) == null) {
						continue;
					} else {
						sobelYSum = sobelYSum + (pixele.get(x).getRgbSum() / 3 * sobelY[x]);

					}

				}

				int sobelSq = 0;

				if (eG == EdgeDirection.BOTH) {
					sobelSq = (int) Math.sqrt(sobelXSum * sobelXSum + sobelYSum * sobelYSum);
				} else if (eG == EdgeDirection.HORIZONTAL) {
					sobelSq = (int) sobelXSum;
				} else if (eG == EdgeDirection.VERTICAL) {
					sobelSq = (int) sobelYSum;
				}

				Color newColor;
				double angle = Math.atan2(sobelYSum, sobelXSum);

				if (colorOutput == ColorOutput.FULLCOLOR) {

					if (sobelSq > sensitivity) {
						sobelSq = 0;
						newColor = new Color(Color.HSBtoRGB((float) angle, (float) 1, (float) 1));
					} else {
						sobelSq = 255;
						newColor = new Color(sobelSq, sobelSq, sobelSq, 0);
					}
				}

				else if (colorOutput == ColorOutput.AVERAGE){
					
					int avRed = 0;
					int avGreen = 0;
					int avBlue = 0;
					
					for (int x = 0; x < pixele.size(); x++) {
						
						avRed = avRed+pixele.get(x).getColor().getRed();
						avGreen = avGreen+pixele.get(x).getColor().getGreen();
						avBlue = avBlue+pixele.get(x).getColor().getBlue();
						
						
					}
					
					avRed = avRed/pixele.size();
					avGreen = avGreen/pixele.size();
					avBlue = avBlue/pixele.size();
					
					if (sobelSq > sensitivity) {
						newColor = new Color(avRed, avGreen, avBlue, 255);
					} else {
						newColor = new Color(255,255,255, 0);
					}
					
					
					
				}
				
				else {
					
					if (sobelSq > sensitivity) {
						sobelSq = 0;
						newColor = new Color(0, 0, 0, 255);
					} else {
						sobelSq = 255;
						newColor = new Color(sobelSq, sobelSq, sobelSq, 0);
					}

				}

				imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

			}

		}

	}

}