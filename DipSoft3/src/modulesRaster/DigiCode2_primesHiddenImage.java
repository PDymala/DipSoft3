package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.stream.IntStream;

import org.imgscalr.Scalr;

import DigiCode2_primesFiles.DataComparator;
import DigiCode2_primesFiles.NearestFromArray;
import dip.Loader;
import dip.Pixel;
import dip.PrimeNumberGenerator;

public class DigiCode2_primesHiddenImage {

	private BufferedImage imageIn;
	private BufferedImage imageIn2;
	private BufferedImage imageOut;

	private double signalPixelNumber = 0;
	private int numberOfActivePixels;
	
	/*
	 * 
	 * Theoretically, one can put numberArray in Construtor and put a custom array
	 * 
	 */
	
   
	

	/**
	 * Changes the image with special pattern of colors.
	 * 
	 * Each pixel's parameter is changed to closest prime number
	 * 
	 */
	public DigiCode2_primesHiddenImage(BufferedImage imageIn, BufferedImage imageIn2) {
		this.imageIn = imageIn;
		this.imageIn2 = imageIn2;
	}

	public DigiCode2_primesHiddenImage(BufferedImage imageIn) {
		this.imageIn = imageIn;

	}
	/**
	 * Changes the image with special pattern of colors.
	 *  @return return image after conversion as BufferedImage
	 */
	public BufferedImage getConversedImage() {
		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();

		PrimeNumberGenerator png = new PrimeNumberGenerator();
		
				
		ArrayList<Integer> primes = png.getPrimesSmallerThanANumber(255);
		
		

		// trzeba ogarnac ten drugi obraz jakos. Tj wyrzucic thresholding i skalowanie stad i jakos ogarnac skalowanie aby wymiary byly spoko. Mozna np zmniejszac i wolne zapelnic bialym
		if (imageIn2.getWidth() != imageIn.getWidth() || imageIn2.getHeight() != imageIn.getHeight()) {
			
			imageIn2 =  Scalr.resize(imageIn2, Scalr.Mode.AUTOMATIC, imageIn.getWidth(), imageIn2.getHeight());
			
		}
		
		
		ThresholdingManual2 imageIn2Thresholding = new ThresholdingManual2(imageIn2, 350);
		imageIn2 = imageIn2Thresholding.getImageOut();
		
		/////////
		
		
		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {

				loader.load(yPosition, imageIn.getHeight());

				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true));
				Pixel pixel2 = new Pixel(xPosition, yPosition, new Color(imageIn2.getRGB(xPosition, yPosition), true));
				
				if (pixel.getColor().getAlpha() == 0 || pixel2.getColor().equals(new Color(0,0,0)))  {

			
					imageOut.setRGB(xPosition, yPosition, imageIn.getRGB(xPosition, yPosition));

					continue;

				} else {
					int red = pixel.getColor().getRed(); // czytamy kolor RED piksela
					int green = pixel.getColor().getGreen(); // czytamy kolor GREEN piksela
					int blue = pixel.getColor().getBlue(); // czytamy kolor BLUE piksela
					int alpha = pixel.getColor().getAlpha();
					numberOfActivePixels++;

					////////////// red
					ArrayList<NearestFromArray> temp = new ArrayList<NearestFromArray>();
					for (int x = 0; x < primes.size(); x++) {

						temp.add(new NearestFromArray(red, primes.get(x)));

					}
					temp.sort(new DataComparator());
					red = temp.get(0).getDynamicNumber();

					////////////// green

					ArrayList<NearestFromArray> temp2 = new ArrayList<NearestFromArray>();
					for (int x = 0; x < primes.size(); x++) {

						temp2.add(new NearestFromArray(green, primes.get(x)));

					}
					temp2.sort(new DataComparator());
					green = temp2.get(0).getDynamicNumber();

					////////////// blue

					ArrayList<NearestFromArray> temp3 = new ArrayList<NearestFromArray>();
					for (int x = 0; x < primes.size(); x++) {

						temp3.add(new NearestFromArray(blue, primes.get(x)));

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
