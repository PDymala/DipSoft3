package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.imgscalr.Scalr;

import dip.Loader;
import dip.Pixel;

public class DigiCode3_hiddenImage {

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
	 * Inner class for counting closest value to given one working according to given modulus
	 */
	private class ClosestNumberInPixelWorking {

		int closestHigh;
		int closestLow;
		int ref;

		public ClosestNumberInPixelWorking(int ref, int modulus) {
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

		public int getClosestNumberWorking() {
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
	 * Inner class for counting closest value to given one working according to given modulus
	 */
	private class ClosestNumberInPixelNotWorking {

		int closestHigh;
		int closestLow;
		int ref;

		public ClosestNumberInPixelNotWorking(int ref, int modulus) {
			this.ref = ref;
			closestHigh = ref;
			closestLow = ref;

			while (closestHigh % modulus == 0) {

				closestHigh++;

			}

			while (closestLow % modulus == 0) {

				closestLow--;
			}

		}

		public int getClosestNumberNotWorking() {
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
	 * @param imageIn1 BufferedImage to be changed
	 * 
	 * @param code    3 digit code
	 * 
	 * @param method  coding or decoding
	 * 
	 */
	public DigiCode3_hiddenImage(BufferedImage imageIn1, BufferedImage imageIn2, int redCode, int greenCode, int blueCode, Method method) {
		imageOut = new BufferedImage(imageIn1.getWidth(), imageIn1.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();

		
		/// to pewnie jakos trzeba wyrzucic stad :)
		
		
		
		// trzeba ogarnac ten drugi obraz jakos. Tj wyrzucic thresholding i skalowanie stad i jakos ogarnac skalowanie aby wymiary byly spoko. Mozna np zmniejszac i wolne zapelnic bialym
		if (imageIn2.getWidth() != imageIn1.getWidth() || imageIn2.getHeight() != imageIn1.getHeight()) {
			
			imageIn2 =  Scalr.resize(imageIn2, Scalr.Mode.AUTOMATIC, imageIn1.getWidth(), imageIn2.getHeight());
			
		}
		
		
		ThresholdingManual2 imageIn2Thresholding = new ThresholdingManual2(imageIn2, 350);
		imageIn2 = imageIn2Thresholding.getImageOut();
		
		/////////
		
		for (int yPosition = 0; yPosition < imageIn1.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn1.getWidth(); xPosition++) {

				loader.load(yPosition, imageIn1.getHeight());

				Pixel pixel1 = new Pixel(xPosition, yPosition, new Color(imageIn1.getRGB(xPosition, yPosition), true));
				Pixel pixel2 = new Pixel(xPosition, yPosition, new Color(imageIn2.getRGB(xPosition, yPosition), true));
				
				
				if (pixel1.getColor().getAlpha() == 0) {

					if (method.equals(Method.code)) {
						continue;
					} else if (method.equals(Method.decode)) {
						Color newColor = new Color(0, 0, 0, 255);
						imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

					}

				} else {
					int red = pixel1.getColor().getRed(); // czytamy kolor RED piksela
					int green = pixel1.getColor().getGreen(); // czytamy kolor GREEN piksela
					int blue = pixel1.getColor().getBlue(); // czytamy kolor BLUE piksela
					int alpha = pixel1.getColor().getAlpha();
					numberOfActivePixels++;
					if (method.equals(Method.code)) {

						if (pixel2.getRgbSum() < 700) {
						

							ClosestNumberInPixelWorking closestRed = new ClosestNumberInPixelWorking(red,redCode);
							ClosestNumberInPixelWorking closestGreen = new ClosestNumberInPixelWorking(green, greenCode);
							ClosestNumberInPixelWorking closestBlue = new ClosestNumberInPixelWorking(blue,blueCode);
							
							Color newColor = new Color(closestRed.getClosestNumberWorking(), closestGreen.getClosestNumberWorking(), closestBlue.getClosestNumberWorking(), alpha);
							imageOut.setRGB(xPosition, yPosition, newColor.getRGB());
							
						} else {
							
							ClosestNumberInPixelNotWorking closestRed = new ClosestNumberInPixelNotWorking(red,redCode);
							ClosestNumberInPixelNotWorking closestGreen = new ClosestNumberInPixelNotWorking(green, greenCode);
							ClosestNumberInPixelNotWorking closestBlue = new ClosestNumberInPixelNotWorking(blue,blueCode);
							
							Color newColor = new Color(closestRed.getClosestNumberNotWorking(), closestGreen.getClosestNumberNotWorking(), closestBlue.getClosestNumberNotWorking(), alpha);
							imageOut.setRGB(xPosition, yPosition, newColor.getRGB());
							
						}
						
						
					

						
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
