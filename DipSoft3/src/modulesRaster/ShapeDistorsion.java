package modulesRaster;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dip.Loader;
import dip.Pixel;

public class ShapeDistorsion {

	private BufferedImage imageOut;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	public enum Shape {
		SQUARE,RECTANGLE,CIRCLE,ELLIPSE;
	}
	
	/**
	 * Blurrs the image with a filter. Each pixel is an average of surrounding
	 * pixels including weights of each position.
	 * 
	 * @param imageIn     BufferedImage to be changed
	 * @param typeOfBlurr Predefined filters, e.g. MEAN (each pixels weights 1)
	 * 
	 */

	public ShapeDistorsion(BufferedImage imageIn, int shapeMinSize, int shapeMaxSize, int numberOfShapes, Shape shape) {

		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);

		Loader loader = new Loader();

		for (int x = 0; x < numberOfShapes; x++) {

			// random size
			int xSize = (int) (Math.random() * (shapeMaxSize - shapeMinSize) + shapeMinSize);
			int ySize = (int) (Math.random() * (shapeMaxSize - shapeMinSize) + shapeMinSize);
			// end of random size

			// random location
			int aX = (int) (Math.random() * imageIn.getWidth());
			int aY = (int) (Math.random() * imageIn.getHeight());

			do {
				aX = (int) (Math.random() * imageIn.getWidth());
				aY = (int) (Math.random() * imageIn.getHeight());
			} while (new Color(imageIn.getRGB(aX, aY), true).getAlpha() < 10);
			// end of random location

			// counting colour
			HashMap<Integer, Pixel> pixele = new HashMap<Integer, Pixel>();
			List<Integer> pikseleRED = new ArrayList<Integer>();
			List<Integer> pikseleGREEN = new ArrayList<Integer>();
			List<Integer> pikseleBLUE = new ArrayList<Integer>();

			int temp = 0;
			Double avRED = 0.0;
			Double avGREEN = 0.0;
			Double avBLUE = 0.0;

			for (int pY = 0; pY < ySize; pY++) {

				// p�tla dla ka�dego nowego piksela na wysoko�� za�adowanego obrazu
				for (int pX = 0; pX < xSize; pX++) {

					if (pX + aX < 0 || pX + aX + 1 > imageIn.getWidth() || pY + aY < 0
							|| pY + aY + 1 > imageIn.getHeight()) {
						pixele.put(temp, null);
					} else {
						Pixel tempPixel = new Pixel(pX + aX, pY + aY,
								new Color(imageIn.getRGB(pX + aX, pY + aY), true));
						pixele.put(temp, tempPixel);
						pikseleRED.add(tempPixel.getColor().getRed());
						pikseleGREEN.add(tempPixel.getColor().getGreen());
						pikseleBLUE.add(tempPixel.getColor().getBlue());

					}
					temp++;
					avRED = pikseleRED.stream().mapToInt(val -> val).average().orElse(0.0);
					avGREEN = pikseleGREEN.stream().mapToInt(val -> val).average().orElse(0.0);
					avBLUE = pikseleBLUE.stream().mapToInt(val -> val).average().orElse(0.0);
				}
			}
			// end of counting colour

			// drawing :)
			Graphics2D g2d = imageOut.createGraphics();

			
			//SQUARE,RECTANGLE,CIRCLE,ELLIPSE;
			
			
			
			// tu do zmiany! dodanie opcji. Dlaczego krzaczy przy duzych wielkosciach?
			
			if (shape == Shape.ELLIPSE) {
				Ellipse2D shape1 = new Ellipse2D.Double(aX + (xSize / 2), aY + (ySize / 2), ySize, xSize);
				g2d.setColor(new Color(avRED.intValue(), avGREEN.intValue(), avBLUE.intValue()));
				g2d.fill(shape1);
				g2d.draw(shape1);
			} else if (shape == Shape.RECTANGLE) {
				Rectangle2D shape2 = new Rectangle2D.Double(aX + (xSize / 2), aY + (ySize / 2), ySize, xSize);
				g2d.setColor(new Color(avRED.intValue(), avGREEN.intValue(), avBLUE.intValue()));
				g2d.fill(shape2);
				g2d.draw(shape2);
			} else if (shape == Shape.SQUARE) {
				Rectangle2D shape2 = new Rectangle2D.Double(aX + (xSize / 2), aY + (ySize / 2), ySize, ySize);
				g2d.setColor(new Color(avRED.intValue(), avGREEN.intValue(), avBLUE.intValue()));
				g2d.fill(shape2);
				g2d.draw(shape2);				
			} else if (shape == Shape.CIRCLE) {
				
				Ellipse2D shape1 = new Ellipse2D.Double(aX + (xSize / 2), aY + (ySize / 2), ySize, ySize);
				g2d.setColor(new Color(avRED.intValue(), avGREEN.intValue(), avBLUE.intValue()));
				g2d.fill(shape1);
				g2d.draw(shape1);
			}
				
				
				// random shape! :D tylko ilosc punktow trza dodac albo innny konstruktor
			// AWT GEOM Generalpath
				
				
			
			// Color colorA = new Color(imageIn.getRGB(aX, aY), true);
			
			

			 loader.load(x, numberOfShapes);
			// drawingCounter.addDrawing();
			g2d.dispose();
			// end of drawing

		}

	}

	public ShapeDistorsion(BufferedImage imageIn, int shapeMinSize, int shapeMaxSize, int numberOfShapes, int numberOfShapesAngles) {

		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);

		Loader loader = new Loader();

		for (int x = 0; x < numberOfShapes; x++) {

			// random size
			int xSize = (int) (Math.random() * (shapeMaxSize - shapeMinSize) + shapeMinSize);
			int ySize = (int) (Math.random() * (shapeMaxSize - shapeMinSize) + shapeMinSize);
			// end of random size

			// random location
			int aX = (int) (Math.random() * imageIn.getWidth());
			int aY = (int) (Math.random() * imageIn.getHeight());

			do {
				aX = (int) (Math.random() * imageIn.getWidth());
				aY = (int) (Math.random() * imageIn.getHeight());
			} while (new Color(imageIn.getRGB(aX, aY), true).getAlpha() < 10);
			// end of random location

			
			//random points in shapes area
		/*	
			int points[][] = new int[][];
			
			points[0][0] = aX;
			points[0][1] = aY;		
					
			
			for (int w = 1; w<numberOfShapesAngles;w++) {
				//x
				points[w][0][0]= (int) (Math.random() * aX+xSize);
				//y
				points[w][1][0]= (int) (Math.random() * aY+ySize);
				
			}
			
			
			
			
			
			// counting colour
			HashMap<Integer, Pixel> pixele = new HashMap<Integer, Pixel>();
			List<Integer> pikseleRED = new ArrayList<Integer>();
			List<Integer> pikseleGREEN = new ArrayList<Integer>();
			List<Integer> pikseleBLUE = new ArrayList<Integer>();

			int temp = 0;
			Double avRED = 0.0;
			Double avGREEN = 0.0;
			Double avBLUE = 0.0;

			for (int pY = 0; pY < ySize; pY++) {

				// p�tla dla ka�dego nowego piksela na wysoko�� za�adowanego obrazu
				for (int pX = 0; pX < xSize; pX++) {

					if (pX + aX < 0 || pX + aX + 1 > imageIn.getWidth() || pY + aY < 0
							|| pY + aY + 1 > imageIn.getHeight()) {
						pixele.put(temp, null);
					} else {
						Pixel tempPixel = new Pixel(pX + aX, pY + aY,
								new Color(imageIn.getRGB(pX + aX, pY + aY), true));
						pixele.put(temp, tempPixel);
						pikseleRED.add(tempPixel.getColor().getRed());
						pikseleGREEN.add(tempPixel.getColor().getGreen());
						pikseleBLUE.add(tempPixel.getColor().getBlue());

					}
					temp++;
					avRED = pikseleRED.stream().mapToInt(val -> val).average().orElse(0.0);
					avGREEN = pikseleGREEN.stream().mapToInt(val -> val).average().orElse(0.0);
					avBLUE = pikseleBLUE.stream().mapToInt(val -> val).average().orElse(0.0);
				}
			}
			// end of counting colour

			// drawing :)
			Graphics2D g2d = imageOut.createGraphics();

			
			//SQUARE,RECTANGLE,CIRCLE,ELLIPSE;
			
			
			GeneralPath star = new GeneralPath();

	        star.moveTo(points[0][0], points[0][1]);

	        for (int k = 1; k < points.length; k++)
	            star.lineTo(points[k][0], points[k][1]);

	        star.closePath();
			
			
			
			
				Ellipse2D shape1 = new Ellipse2D.Double(aX + (xSize / 2), aY + (ySize / 2), ySize, ySize);
				g2d.setColor(new Color(avRED.intValue(), avGREEN.intValue(), avBLUE.intValue()));
				g2d.fill(shape1);
				g2d.draw(shape1);
			
				
				
				// random shape! :D tylko ilosc punktow trza dodac albo innny konstruktor
			// AWT GEOM Generalpath
				
				
			
			// Color colorA = new Color(imageIn.getRGB(aX, aY), true);
			
			

			 loader.load(x, numberOfShapes);
			// drawingCounter.addDrawing();
			g2d.dispose();
			// end of drawing
*/
		}

	}
}
