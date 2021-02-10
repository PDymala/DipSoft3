package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import dip.IntegerBinaryConverter;
import dip.Loader;
import dip.Pixel;


/*
 * 
 * DZIAL ALE TAK WOLNO ZE OMG OMG OMG
 */
public class DigiCode4_binaryTextCoding2_array2 {

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


	public enum Required {
		even, odd;
	}

	private class NumberChanger {
		int ref = 0;

		public NumberChanger(int ref) {
			this.ref = ref;
		}

		public boolean isOdd() {
			if (ref % 2 == 0) {
				return false;
			} else {
				return true;
			}
		}

		public boolean isEven() {
			if (ref % 2 == 0) {
				return true;
			} else {
				return false;
			}
		}

		public int changeToRequired(Required required) {

			if (required.equals(Required.even)) {

				if (isEven() == true) {
					return ref;
				} else {

					if (ref == 255) {
						ref = ref - 1;
					} else if (ref == 0) {
						ref = ref + 2;
					} else {
						ref++;
					}
					return ref;

				}
			} else { // znaczy required == odd

				if (isOdd() == true) {
					return ref;
				} else {

					if (ref == 255) {

					} else if (ref == 0) {
						ref = ref + 1;
					} else {
						ref++;
					}
					return ref;

				}
			}

		}

	}

	/**
	 * Changes the image so that it includes a hidden digital mark. It is based on transformation of text into binary representation and including that into RGB parameters.
	 * 
	 * @param imageIn BufferedImage to be changed
	 * 
	 * @param text text to be hidden
	 * 
	 */
	public DigiCode4_binaryTextCoding2_array2(BufferedImage imageIn, String text) {
		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		// Loader loader = new Loader();

		IntegerBinaryConverter ibc = new IntegerBinaryConverter();

		ArrayList<Pixel> pictureList = new ArrayList<Pixel>();

		// chyba max 750 000 000 pikseli (ok 25 000 x 25 000);
		// ew nie wiem czy sie da, aby tekst podzielic na 2 lub wiecej list. z
		
		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {

				pictureList.add(new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true)));

			}
		}

		// How many bits can You have in picture
		System.out.println("Pixels in picture: " + pictureList.size());

		// How many bits can You have in picture
		System.out.println("How big text can You hide in picture " + (double) (pictureList.size() - 8) / 8);

		// How many bits do You need for the text
		System.out.println("Pixels needed for 1 times text: " + (text.length() * 8) + 8);

		// How many times will the text will be coded?
		System.out.println(
				"How many times will the text be coded: " + (double) (pictureList.size() / (text.length() * 8) + 8));

		Boolean[] binaryArray;
		Queue<Boolean> queue = new LinkedList<>();

		// filing the q

		// symbol 2 - indicating start of text ???????????
		Boolean[] tempStart = ibc.intToBinary(2, 8);
		// System.out.println(Arrays.toString(tempStart));
		for (int y = 0; y < tempStart.length; y++) {

			queue.add(tempStart[y]);
		}

		// main tetxt
		for (int x = 0; x < text.length(); x++) {

			Boolean[] tempMain = ibc.intToBinary(Character.valueOf(text.charAt(x)), 8);
			// System.out.println(Arrays.toString(tempMain));
			for (int y = 0; y < tempMain.length; y++) {

				queue.add(tempMain[y]);
			}

		}

		// symbol 3 - indicating end of text
		Boolean[] tempEnd = ibc.intToBinary(3, 8);
		// System.out.println(Arrays.toString(tempEnd));
		for (int y = 0; y < tempEnd.length; y++) {

			queue.add(tempEnd[y]);
		}
		// q

		// juz dziala calym tekstem. dodac poczatek i koniec potem czytanie
		// dziala alE TAK WOLNO< ZE OMG!
		int tempListSize = pictureList.size();
		
		while (pictureList.size() > 8) {
			System.out.println(tempListSize + " / " + pictureList.size());
			NumberChanger ncRed = new NumberChanger(pictureList.get(0).getColor().getRed());
			NumberChanger ncGreen = new NumberChanger(pictureList.get(0).getColor().getGreen());
			NumberChanger ncBlue = new NumberChanger(pictureList.get(0).getColor().getBlue());

		
			if (queue.peek().equals(true)) {

				Color newColor = new Color(ncRed.changeToRequired(Required.even),
						ncGreen.changeToRequired(Required.even), ncBlue.changeToRequired(Required.even));
				imageOut.setRGB((int) (pictureList.get(0).getxPosition()), (int) (pictureList.get(0).getyPosition()),
						newColor.getRGB());

			} else if (queue.peek().equals(false)) {

				Color newColor = new Color(ncRed.changeToRequired(Required.odd), ncGreen.changeToRequired(Required.odd),
						ncBlue.changeToRequired(Required.odd));
				imageOut.setRGB((int) (pictureList.get(0).getxPosition()), (int) (pictureList.get(0).getyPosition()),
						newColor.getRGB());

			}
			queue.add(queue.poll());
			pictureList.remove(0);

		}

	}

	/**
	 * Reads an binary code put into the pixels of an image.
	 * 
	 * @param imageIn BufferedImage to be changed
	 * 
	 */
	public DigiCode4_binaryTextCoding2_array2(BufferedImage imageIn) {
		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		// Loader loader = new Loader();

		IntegerBinaryConverter ibc = new IntegerBinaryConverter();

		ArrayList<Pixel> pictureList = new ArrayList<Pixel>();

		String finalText = "";

		// chyba max 750 000 000 pozycji
		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {

				pictureList.add(new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true)));

			}
		}

		// DECODE
		Boolean activation = true;
		Boolean startText = false;
		for (int x = 0; x < pictureList.size(); x = x + 8) {
			if (activation == false) {
				break;
			}

			Boolean[] temp = new Boolean[8];

			for (int y = 0; y < 8; y++) {

				if (x + y < pictureList.size() && pictureList.get(x + y).getRgbSum() % 2 == 0) {

					temp[y] = true;
				} else {

					temp[y] = false;
				}

			}

			int temp2 = (char) ibc.binaryArraytoInt(temp);

			// 2 = start of text
			if (temp2 == 2) {
				startText = true;
				continue;
			}

			// 3 = end of text
			if (temp2 == 3) {
				activation = false;
				continue;
			}

			// writing text
			if (startText == true) {
				finalText += Character.toString((char) temp2);

			}

		}

		if (finalText.isEmpty()) {
			System.out.println("No code found");
		} else {
			System.out.println(finalText);
		}
		
	}

}
