package modulesRaster;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import dip.Loader;
import dip.Pixel;

public class RandomImage {

		private BufferedImage imageOut;

		public BufferedImage getImageOut() {
			return imageOut;
		}

		/**
		 * Inverts the colors
		 * 
		 * @param imageIn
		 *            BufferedImage to be changed
		 * 
		 */
		public RandomImage() {
			int points = 5000;
			imageOut = new BufferedImage(1000,1000, BufferedImage.TYPE_INT_ARGB);
			Loader loader = new Loader();
			
			Random rnd = new Random(255);
			
			for (int i = 0; i < points;i++) {
				
//				Color newColor = new Color(0,0,0);
//				imageOut.setRGB(rnd.nextInt(1000),rnd.nextInt(1000), newColor.getRGB());
//				
			
				Graphics2D g2d = imageOut.createGraphics();
				Ellipse2D shape1 = new Ellipse2D.Double(rnd.nextInt(1000),rnd.nextInt(1000), 10, 10);
				g2d.setColor(new Color(0,0,0));
				g2d.fill(shape1);
				g2d.draw(shape1);
				g2d.dispose();
				
				
			}
			
			
			int counterx= 0;
			int countery= 0;
			
			for (int yPosition = 0; yPosition < imageOut.getHeight(); yPosition++) {
				for (int xPosition = 0; xPosition < imageOut.getWidth(); xPosition++) {
					
					
					if (counterx%30 == 0 && countery%30 ==0) {
//						Color newColor = new Color(0,0,0);
//					imageOut.setRGB(xPosition,yPosition, newColor.getRGB());
					
						Graphics2D g2d = imageOut.createGraphics();
						Ellipse2D shape1 = new Ellipse2D.Double(xPosition,yPosition, 10, 10);
						g2d.setColor(new Color(0,0,0));
						g2d.fill(shape1);
						g2d.draw(shape1);
						g2d.dispose();
					}
					
					counterx++;
					}
					countery++;
				}
			}
		}
	

