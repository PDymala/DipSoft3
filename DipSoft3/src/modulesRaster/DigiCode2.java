package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dip.Loader;
import dip.Pixel;

public class DigiCode2 {

	private BufferedImage imageOut;
	private double signalPixelNumber = 0;
	private int numberOfActivePixels;
	private double signalValue = 0;

	public double getSignalValue() {
		return signalValue;
	}

	public BufferedImage getImageOut() {
		return imageOut;
	}

	public enum Method {
		code, decode;
	}
	
	/**
	 * Inner class for counting closest value to given one 
	 */
	private class ClosestNumberInPixel {

		int closestHigh;
		int closestLow;
		int ref;

		public ClosestNumberInPixel(int ref, int modulus) {
			this.ref = ref;
			closestHigh = ref;
			closestLow = ref;

			while (closestHigh % modulus != 0) {

				closestHigh++;

			}

			while (closestLow % modulus != 0) {

				closestLow--;
			}

		}

		public int getClosestNumber() {
			if (closestHigh > 255) {
				if (closestLow <= 0) {
					return ref; // not possible :)
				} else {
					return closestLow;
				}

			} else {
				return closestHigh;
			}

		}
	}

	/**
	 * Changes the image so that it includes a hidden digital mark. It can read a
	 * ready picture to see if it includes given code or not. It needs to be tested but a coded picture should have signal 100%;
	 * 
	 * @param imageIn BufferedImage to be changed
	 * 
	 * @param code    3 digit code
	 * 
	 * @param method  coding or decoding
	 * 
	 */
	public DigiCode2(BufferedImage imageIn, int redCode, int greenCode, int blueCode, Method method) {
		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();

		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {

				loader.load(yPosition, imageIn.getHeight());

				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true));
				if (pixel.getColor().getAlpha() == 0) {

					if (method.equals(Method.code)) {
						continue;
					} else if (method.equals(Method.decode)) {
						Color newColor = new Color(0, 0, 0, 255);
						imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

					}

				} else {
					int red = pixel.getColor().getRed(); // czytamy kolor RED piksela
					int green = pixel.getColor().getGreen(); // czytamy kolor GREEN piksela
					int blue = pixel.getColor().getBlue(); // czytamy kolor BLUE piksela
					int alpha = pixel.getColor().getAlpha();
					numberOfActivePixels++;
					if (method.equals(Method.code)) {

						ClosestNumberInPixel closestRed = new ClosestNumberInPixel(red,redCode);
						ClosestNumberInPixel closestGreen = new ClosestNumberInPixel(green, greenCode);
						ClosestNumberInPixel closestBlue = new ClosestNumberInPixel(blue,blueCode);
						
					

						Color newColor = new Color(closestRed.getClosestNumber(), closestGreen.getClosestNumber(), closestBlue.getClosestNumber(), alpha);
						imageOut.setRGB(xPosition, yPosition, newColor.getRGB());
					}

					else if (method.equals(Method.decode)) {

						int codeNumber = 0;

						if (red % redCode == 0 && green % greenCode == 0 && blue % blueCode == 0) {
							codeNumber = 255;
							signalPixelNumber++;
						}

						

						Color newColor = new Color(codeNumber, codeNumber, codeNumber, alpha);
						imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

					}

				}

			}
		}
		signalValue = ((signalPixelNumber) / (numberOfActivePixels));
	}
	
	
	
}
