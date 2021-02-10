package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dip.Loader;
import dip.Pixel;

public class GhostMark {

	private BufferedImage imageOut;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	/**
	 * Changes the color of each pixel with given parameters
	 * 
	 * @param imageIn1
	 *            BufferedImage to be changed
	 *            
	  @param imageIn2
	 *            BufferedImage with watermark (1 bit picture)
	 * 
	 * @param redChange
	 *            Value from -255 to 255 of given color to be changed
	 * @param blueChange
	 *            Value from -255 to 255 of given color to be changed
	 * @param greenChange
	 *            Value from -255 to 255 of given color to be changed
	 * 
	 * 
	 * 
	 */
	public GhostMark(BufferedImage imageIn1, BufferedImage imageIn2, int redChange, int greenChange, int blueChange) {
		imageOut = new BufferedImage(imageIn1.getWidth(), imageIn1.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		Loader loader = new Loader();
		
		for (int yPosition = 0; yPosition < imageIn1.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn1.getWidth(); xPosition++) {
				loader.load(yPosition, imageIn1.getHeight());
				
				Pixel pixel1 = new Pixel(xPosition, yPosition, new Color(imageIn1.getRGB(xPosition, yPosition), true));
				Pixel pixel2;
				if (xPosition > imageIn2.getWidth() || yPosition > imageIn2.getHeight()) {
					pixel2 = new Pixel(xPosition, yPosition, new Color(0, 0, 0, 0));

				} else {
					pixel2 = new Pixel(xPosition, yPosition, new Color(imageIn2.getRGB(xPosition, yPosition), true));

				}

				if (pixel1.getColor().getAlpha() == 0) {

					continue;
				}

				else {

					if (pixel2.getColor().equals(Color.black) && pixel2.getColor().getAlpha() > 0) {

						int red = pixel1.getColor().getRed() + redChange; // czytamy
																			// kolor
																			// RED
																			// piksela
						int green = pixel1.getColor().getGreen() + greenChange; // czytamy
																				// kolor
																				// GREEN
																				// piksela
						int blue = pixel1.getColor().getBlue() + blueChange; // czytamy
																				// kolor
																				// BLUE
																				// piksela
						int alpha = pixel1.getColor().getAlpha();

						// Kolory nie mog� by� mniejsze ni� 0 i wieksze niz 255
						// (
						// mozliwe jest 256
						// kolorow) 16bit!
						if (red > 255) {
							red = 255;
						}
						if (red < 0) {
							red = 0;
						}

						if (green > 255) {
							green = 255;
						}
						if (green < 0) {
							green = 0;
						}

						if (blue > 255) {
							blue = 255;
						}
						if (blue < 0) {
							blue = 0;
						}

						Color newColor = new Color(red, green, blue, alpha);
						imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

					} else {
						int red = pixel1.getColor().getRed();
						int green = pixel1.getColor().getGreen(); 
						int blue = pixel1.getColor().getBlue(); 
						int alpha = pixel1.getColor().getAlpha();
						Color newColor = new Color(red, green, blue, alpha);
						imageOut.setRGB(xPosition, yPosition, newColor.getRGB());
					
					}

				}

			}
		}
	}
}