package modulesRaster;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import dip.DrawingCounter;
import dip.Loader;
import dip.Pixel;
import javafx.scene.shape.Line;

public class GibberishLines {

	private BufferedImage imageOut;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	public enum ColorType {
		MONO, AVERAGE, RANDOM;
	}

	public enum LineContinuity {
		YES, NO;
	}

	/**
	 * Random lines at random location without any sense
	 * 
	 * @param width  width of the new picture
	 * @param height   height of the new picture
	 * @param numberOfRandomLines numer of random lines
	 * @param colorType random, mono etc.
	 * 
	 * 
	 * 
	 * 
	 */
	public GibberishLines(int width, int height, int numberOfRandomLines, ColorType colorType) {
		// konstruktor danej klasy
		imageOut = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		Loader loader = new Loader();
		DrawingCounter drawingCounter = new DrawingCounter();

		for (int x = 0; x < numberOfRandomLines; x++) {

			Graphics2D g2d = imageOut.createGraphics();
			if (colorType == ColorType.MONO) {
				g2d.setColor(Color.BLACK);

			} else if (colorType == ColorType.RANDOM) {

				g2d.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
						(int) (Math.random() * 255)));

			}
			g2d.draw(new Line2D.Double(Math.random() * width, Math.random() * height, Math.random() * width,
					Math.random() * height));

			loader.load(x, numberOfRandomLines);
			drawingCounter.addDrawing();
			g2d.dispose();
		}

	}

	
	/**
	 * Random lines at random location without any sense
	 * 
	 * @param imageIn  picture to manipulate
	 * @param numberOfRandomLines numer of random lines
	 * @param colorType random, mono etc.
	 * @param lineContinuity continue line or bunch of random lines
	 * 
	 * 
	 * 
	 */
	
	public GibberishLines(BufferedImage imageIn, int numberOfRandomLines, ColorType colorType,
			LineContinuity lineContinuity) {

		if (lineContinuity == LineContinuity.YES) {
			imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);

			Loader loader = new Loader();
			DrawingCounter drawingCounter = new DrawingCounter();

			// nie wiem po co to tu :D
			int aX = (int) (Math.random() * imageIn.getWidth());
			int aY = (int) (Math.random() * imageIn.getHeight());
			//
			do {
				aX = (int) (Math.random() * imageIn.getWidth());
				aY = (int) (Math.random() * imageIn.getHeight());
			} while (new Color(imageIn.getRGB(aX, aY), true).getAlpha() < 10);

			for (int x = 0; x < numberOfRandomLines; x++) {

				int bX = (int) (Math.random() * imageIn.getWidth());
				int bY = (int) (Math.random() * imageIn.getHeight());

				do {
					bX = (int) (Math.random() * imageIn.getWidth());
					bY = (int) (Math.random() * imageIn.getHeight());
				} while (new Color(imageIn.getRGB(bX, bY), true).getAlpha() < 10);

				Graphics2D g2d = imageOut.createGraphics();

				if (colorType == ColorType.AVERAGE) {
					Color colorA = new Color(imageIn.getRGB(aX, aY), true);
					Color colorB = new Color(imageIn.getRGB(bX, bY), true);
					g2d.setColor(new Color((colorA.getRed() + colorB.getRed()) / 2,
							(colorA.getGreen() + colorB.getGreen()) / 2, (colorA.getBlue() + colorB.getBlue()) / 2));

				} else if (colorType == ColorType.MONO) {
					g2d.setColor(Color.BLACK);

				} else if (colorType == ColorType.RANDOM) {

					g2d.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
							(int) (Math.random() * 255)));

				}

				g2d.draw(new Line2D.Double(aX, aY, bX, bY));
				aX = bX;
				aY = bY;
				loader.load(x, numberOfRandomLines);
				drawingCounter.addDrawing();
				g2d.dispose();
			}

		} else {

			imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);

			Loader loader = new Loader();
			DrawingCounter drawingCounter = new DrawingCounter();

			for (int x = 0; x < numberOfRandomLines; x++) {

				int aX = (int) (Math.random() * imageIn.getWidth());
				int aY = (int) (Math.random() * imageIn.getHeight());
				int bX = (int) (Math.random() * imageIn.getWidth());
				int bY = (int) (Math.random() * imageIn.getHeight());

				do {
					aX = (int) (Math.random() * imageIn.getWidth());
					aY = (int) (Math.random() * imageIn.getHeight());
				} while (new Color(imageIn.getRGB(aX, aY), true).getAlpha() < 10);

				do {
					bX = (int) (Math.random() * imageIn.getWidth());
					bY = (int) (Math.random() * imageIn.getHeight());
				} while (new Color(imageIn.getRGB(bX, bY), true).getAlpha() < 10);

				Graphics2D g2d = imageOut.createGraphics();

				if (colorType == ColorType.AVERAGE) {
					Color colorA = new Color(imageIn.getRGB(aX, aY), true);
					Color colorB = new Color(imageIn.getRGB(bX, bY), true);
					g2d.setColor(new Color((colorA.getRed() + colorB.getRed()) / 2,
							(colorA.getGreen() + colorB.getGreen()) / 2, (colorA.getBlue() + colorB.getBlue()) / 2));

				} else if (colorType == ColorType.MONO) {
					g2d.setColor(Color.BLACK);

				} else if (colorType == ColorType.RANDOM) {

					g2d.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
							(int) (Math.random() * 255)));

				}

				g2d.draw(new Line2D.Double(aX, aY, bX, bY));

				loader.load(x, numberOfRandomLines);
				drawingCounter.addDrawing();
				g2d.dispose();
			}

		}

	}
}
