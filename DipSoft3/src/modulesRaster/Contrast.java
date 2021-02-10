package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dip.Loader;
import dip.Pixel;

public class Contrast {

	private BufferedImage imageOut;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	/**
	 * Changes the color of each pixel with given parameters
	 * 
	 * @param imageIn
	 *            BufferedImage to be changed
	 * 
	 * @param barier
	 *            border of contrast change
	 * @param contrast
	 *            % value of contrast to change

	 * 
	 * 
	 * 
	 */
	public Contrast(BufferedImage imageIn, int barier, double contrast) {
		// konstruktor danej klasy
		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();
		
			for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
				// p�tla dla ka�dego nowego piksela na wysoko�� za�adowanego obrazu
				for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {

					loader.load(yPosition, imageIn.getHeight());
					
					// p�tla dla ka�dego nowego piksela na szeroko�� za�adowanego obrazu
					Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition),true));

					if (pixel.getColor().getAlpha() == 0) {

						continue;
					} else {
					// // �adujemy konsrtruktor getRGB dla ka�dego piksela
					int red = pixel.getColor().getRed(); // czytamy kolor RED piksela
					int green = pixel.getColor().getGreen(); // czytamy kolor GREEN piksela
					int blue = pixel.getColor().getBlue(); // czytamy kolor BLUE piksela
					int rgb = red + green + blue; // dodajemy kolory RED GREEN i BLUE

					if (rgb > barier) {
						red = red + (int) (red * contrast);
						green = green + (int) (green * contrast);
						blue = blue + (int) (blue * contrast);

					} else {
						red = red - (int) (red * contrast);
						green = green - (int) (green * contrast);
						blue = blue - (int) (blue * contrast);

					}

					// Kolory nie mog� by� mniejsze ni� 0 i wieksze niz 255 ( mozliwe jest 256
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

					Color newColor = new Color(red, green, blue);

					imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

				}
				}
			}


	}
	/**
	 * Changes the color of each pixel with given parameters. Contrast barier is 50% as default.
	 * 
	 * @param imageIn
	 *            BufferedImage to be changed
	 * 
	 * @param contrast
	 *            % value of contrast to change

	 * 
	 * 
	 * 
	 */
	public Contrast(BufferedImage imageIn, double contrast) {
		// konstruktor danej klasy
		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();
		
			for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
				// p�tla dla ka�dego nowego piksela na wysoko�� za�adowanego obrazu
				for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {
					// p�tla dla ka�dego nowego piksela na szeroko�� za�adowanego obrazu

					loader.load(yPosition, imageIn.getHeight());
					Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition),true));
					if (pixel.getColor().getAlpha() == 0) {

						continue;
					} else {
					// // �adujemy konsrtruktor getRGB dla ka�dego piksela
					int red = pixel.getColor().getRed(); // czytamy kolor RED piksela
					int green = pixel.getColor().getGreen(); // czytamy kolor GREEN piksela
					int blue = pixel.getColor().getBlue(); // czytamy kolor BLUE piksela
					int rgb = red + green + blue; // dodajemy kolory RED GREEN i BLUE

					if (rgb > 383) {
						red = red + (int) (red * contrast);
						green = green + (int) (green * contrast);
						blue = blue + (int) (blue * contrast);

					} else {
						red = red - (int) (red * contrast);
						green = green - (int) (green * contrast);
						blue = blue - (int) (blue * contrast);

					}

					// Kolory nie mog� by� mniejsze ni� 0 i wieksze niz 255 ( mozliwe jest 256
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

					Color newColor = new Color(red, green, blue);

					imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

				}
				}
			}


	}

}
