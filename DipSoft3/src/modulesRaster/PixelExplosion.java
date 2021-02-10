package modulesRaster;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Collections;

import dip.DrawingCounter;
import dip.Loader;

// ok

public class PixelExplosion {

	private BufferedImage imageOut;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	int a = 0;
	int b = 0;
	int c = 0;

	/**
	 * Destroys the image with pixels
	 *
	 * @param imageIn BufferedImage to be changed
	 *
	 * @param percent percent of image to destroy
	 *
	 * @param method  type of pixels
	 */

	public PixelExplosion(BufferedImage imageIn, double numberofPixelsModified, int squareSize, int centerX,
			int centerY) {

		imageOut = imageIn;
		Loader loader = new Loader();
		DrawingCounter drawingCounter = new DrawingCounter();

		// int numberofPixelsModified = (int) (imageIn.getHeight() * imageIn.getWidth()
		// * percent) / 100;

		for (int x = 0; x < numberofPixelsModified; x++) {

			loader.load(x, (int) numberofPixelsModified);

			// losujemy kwadrat który ma byc przeniesiony

			int randomX = (int) (Math.random() * imageIn.getWidth());
			int randomY = (int) (Math.random() * imageIn.getHeight());

			do {
				randomX = (int) (Math.random() * imageIn.getWidth());
				randomY = (int) (Math.random() * imageIn.getHeight());
			} while (new Color(imageIn.getRGB(randomX, randomY), true).getAlpha() < 10);

			// koniec losowania kwadratu

			// Color colorA = new Color(imageIn.getRGB(randomX, randomY), true);

			// obliczamy funkcje aby w dobrym kierunku przeniesc

			Pair centerPoint = new Pair(centerX, centerY);
			Pair randomPoint = new Pair(randomX, randomY);
			lineFromPoints(centerPoint, randomPoint);

			// a, b, c jest

			// losujemy x'a nowego

			int finalX = (int) (Math.random() * imageIn.getWidth() / 2);
			int finalY = 0;
			do {
				finalX = (int) (Math.random() * imageIn.getWidth() / 2);

				randomPoint = new Pair(randomX, randomY);
				lineFromPoints(centerPoint, randomPoint);


				try {
				if (b < 0) {
					
					finalY = (c /(a * finalX))/b;
				} else if (b > 0) {
					
					finalY = (c - (a * finalX)) / b;
					
				} else {
					
					b = 1;
					finalY = (c - (a * finalX)) / b;
					
				}
				}
				catch(ArithmeticException a) {
					
				}
				/*
				2x 3y = 5
The line passing through points P and Q is: 2x + 3y = 5

*/
				
				// System.out.println("random X = "+randomX);
				// System.out.println("final x = "+finalX);
				// System.out.println(finalY);

			} while (finalX > randomX && finalY < imageIn.getHeight());

			// obliczamy Y'ka

			/*
			 * if (b < 0) {
			 * 
			 * finalY = (c-(a*finalX))/b;
			 * 
			 * // y = (c - ax) } else {
			 * 
			 * finalY = (c-(a*finalX))/b; //y = (c - ax)/b }
			 */

			/*
			 * 
			 * System.out.println(a) ;System.out.println(b); System.out.println(c);
			 * System.out.println(finalX); System.out.println(finalY);
			 */

			try {

				
				for (int xInSquare = 0; xInSquare < squareSize; xInSquare++) {
					
					for (int yInSquare = 0; yInSquare < squareSize; yInSquare++) {
							
					
						// Color newColor2 = new Color(0, 0, 0, 0);
						imageOut.setRGB(finalX+xInSquare, finalY+yInSquare, imageIn.getRGB(randomX+xInSquare, randomY+yInSquare));

						Color newColor = new Color(255, 255, 255, 255);
						imageOut.setRGB(randomX+xInSquare, randomY+yInSquare, newColor.getRGB());

					}
				}
				
			
				drawingCounter.addDrawing();

			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}

		}

	}

	static class Pair {
		int first, second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

	}

	public void lineFromPoints(Pair P, Pair Q) {
		a = Q.second - P.second;
		b = P.first - Q.first;
		c = a * (P.first) + b * (P.second);


	
	}
	/*
	 * Pair P = new Pair(3, 2); Pair Q = new Pair(2, 6); lineFromPoints(P, Q);
	 * 
	 * 
	 * is: " ax "by = c); } else { System.out.println("The ax + by = " + c); }
	 * 
	 */

}
