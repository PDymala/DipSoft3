package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.stream.IntStream;

import DigiCode2_primesFiles.DataComparator;
import DigiCode2_primesFiles.NearestFromArray;
import dip.Loader;
import dip.Pixel;

public class DigiCode2_primes {

	private BufferedImage imageIn;
	private BufferedImage imageOut;

	private double signalPixelNumber = 0;
	private int numberOfActivePixels;
	
	/*
	 * 
	 * Theoretically, one can put numberArray in Construtor and put a custom array
	 * 
	 */
	int[] numberArray = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
			97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199,
			211, 223, 227, 229, 233, 239, 241, 251 };

	

	

	/**
	 * Changes the image with special pattern of colors.
	 * 
	 * Each pixel's parameter is changed to closest prime number
	 * 
	 */
	public DigiCode2_primes(BufferedImage imageIn) {
		this.imageIn = imageIn;
	}

	/**
	 * Changes the image with special pattern of colors.
	 *  @return return image after conversion as BufferedImage
	 */
	public BufferedImage getConversedImage() {
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
					numberOfActivePixels++;

					////////////// red
					ArrayList<NearestFromArray> temp = new ArrayList<NearestFromArray>();
					for (int x = 0; x < numberArray.length; x++) {

						temp.add(new NearestFromArray(red, numberArray[x]));

					}
					temp.sort(new DataComparator());
					red = temp.get(0).getDynamicNumber();

					////////////// green

					ArrayList<NearestFromArray> temp2 = new ArrayList<NearestFromArray>();
					for (int x = 0; x < numberArray.length; x++) {

						temp2.add(new NearestFromArray(green, numberArray[x]));

					}
					temp2.sort(new DataComparator());
					green = temp2.get(0).getDynamicNumber();

					////////////// blue

					ArrayList<NearestFromArray> temp3 = new ArrayList<NearestFromArray>();
					for (int x = 0; x < numberArray.length; x++) {

						temp3.add(new NearestFromArray(blue, numberArray[x]));

					}
					temp3.sort(new DataComparator());
					blue = temp3.get(0).getDynamicNumber();

					//////////

					Color newColor = new Color(red, green, blue, alpha);
					imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

				}

			}
		}
		return imageOut;

	}

	private boolean isPrime(int number) {
		return number > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(number)).noneMatch(n -> (number % n == 0));
	}
	
	
	/**
	 * Checks the image for special pattern 
	 *  @return returns number value of signal in the image
	 */
	
	public double getSignalFromImage() {
		Loader loader = new Loader();

		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {

				loader.load(yPosition, imageIn.getHeight());

				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true));
				
					int red = pixel.getColor().getRed();
					int green = pixel.getColor().getGreen();
					int blue = pixel.getColor().getBlue();
					
					numberOfActivePixels++;

					if (isPrime(red) && isPrime(green) && isPrime(blue)) {
						signalPixelNumber++;
					}

				

			}

		}
		return (signalPixelNumber / numberOfActivePixels);
	}
	
	/**
	 * Checks the image for special pattern 
	 *  @return returns BufferedImage, black and whtie map of signa in the given image
	 */
	public BufferedImage getSignalMapFromImage() {
		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();

		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {

				loader.load(yPosition, imageIn.getHeight());

				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true));
				if (pixel.getColor().getAlpha() == 0) {

					imageOut.setRGB(xPosition, yPosition, new Color(0, 0, 0, 255).getRGB());

				} else {
					int red = pixel.getColor().getRed();
					int green = pixel.getColor().getGreen();
					int blue = pixel.getColor().getBlue();
					
					if (isPrime(red) && isPrime(green) && isPrime(blue)) {
						imageOut.setRGB(xPosition, yPosition, new Color(255, 255, 255, 255).getRGB());

					} else {
						imageOut.setRGB(xPosition, yPosition, new Color(0, 0, 0, 255).getRGB());
						
						
					}

				}

			}

		}
		return imageOut;
	}
}
