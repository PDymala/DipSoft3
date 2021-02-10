package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dip.Loader;
import dip.Pixel;

public class DigiCode1 {

	private BufferedImage imageOut;
	private double signalPixelNumber = 0;
	private int numberOfActivePixels;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	public enum Method {
		code, decode;
	}

	/**
	 * Changes the image so that it includes a hidden digital mark. It can read a ready picture to see if it includes given code or not
	 * 
	 * @param imageIn     BufferedImage to be changed
	 * 
	 * @param redCode   Value of the code for red color 
	 * @param greenCode Value of the code for green color 
	 * @param blueCode Value of the code for blue color 
	 * 
	 * @param method coding or decoding
	 * 
	 */
	public DigiCode1(BufferedImage imageIn, int redCode, int greenCode, int blueCode, Method method) {
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
						// 3 , 4, 5

						while (red % redCode != 0) {

							red++;

						}

						while (green % greenCode != 0) {

							green++;

						}

						while (blue % blueCode != 0) {

							blue++;
						}

						if (red > 255) {
							red = 255;
						}

						if (green > 255) {
							green = 255;
						}

						if (blue > 255) {
							blue = 255;
						}

						Color newColor = new Color(red, green, blue, alpha);
						imageOut.setRGB(xPosition, yPosition, newColor.getRGB());
					}

					else if (method.equals(Method.decode)) {

						int codeNumber = 0;

						if (red % redCode == 0) {
							codeNumber = codeNumber + 85;
							signalPixelNumber++;
						}

						if (green % greenCode == 0) {
							codeNumber = codeNumber + 85;
							signalPixelNumber++;
						}

						if (blue % blueCode == 0) {
							codeNumber = codeNumber + 85;
							signalPixelNumber++;
						}

						Color newColor = new Color(codeNumber, codeNumber, codeNumber, alpha);
						imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

					}

				}

			}
		}

		System.out.println("Signal percent is: " + ((signalPixelNumber / 3) / (numberOfActivePixels)));
	}
}
