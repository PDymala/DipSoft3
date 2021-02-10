package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dip.Loader;
import dip.Pixel;

public class PictureEqualitions {

	private BufferedImage imageOut;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	public enum TypeOfEqualition {
		ADDING, SUBSTRATING
	}

	/**
	 * Adds or substracts two 1 bit pictures with different sizes.
	 *
	 * @param imageIn1
	 *            BufferedImage 1
	 *
	 * @param imageIn2
	 *            BufferedImage 2
	 *
	 *
	 * @param equalition
	 *            Type of equalition, i.e. adding etc.
	 *
	 * @param heightPosition2
	 *            Height positioning of 2-nd picture on the 1-st one
	 *
	 * @param widthPosition2
	 *            Width positioning of 2-nd picture on the 1-st one
	 *
	 * 
	 */
	public PictureEqualitions(BufferedImage imageIn1, BufferedImage imageIn2, TypeOfEqualition equalition,
			int heightPosition2, int widthPosition2) {
		imageOut = new BufferedImage(imageIn1.getWidth(), imageIn1.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();
		
		for (int yPosition = 0; yPosition < imageIn1.getHeight(); yPosition++) {

			for (int xPosition = 0; xPosition < imageIn1.getWidth(); xPosition++) {
				loader.load(yPosition, imageIn1.getHeight());
				
				if (equalition == TypeOfEqualition.ADDING) {
					Pixel pixel1 = new Pixel(xPosition, yPosition, new Color(imageIn1.getRGB(xPosition, yPosition), true));

					if (yPosition > imageIn2.getHeight() - 1) {

						imageOut.setRGB(xPosition, yPosition, pixel1.getColor().getRGB());

					} else if (xPosition > imageIn2.getWidth() - 1) {
						imageOut.setRGB(xPosition, yPosition, pixel1.getColor().getRGB());

					}

					else {

						Pixel pixel2 = new Pixel(xPosition + widthPosition2, yPosition + heightPosition2,
								new Color(imageIn2.getRGB(xPosition, yPosition), true));
						int rgb1 = pixel1.getRgbSum();
						int rgb2 = pixel2.getRgbSum();

						if (rgb1 < 760 && rgb2 < 760) { // both black
							if (pixel1.getColor().getAlpha() == 0 && pixel2.getColor().getAlpha() == 0) {
								imageOut.setRGB(xPosition, yPosition, new Color(0, 0, 0, 0).getRGB());
							} else {
								imageOut.setRGB(xPosition, yPosition, new Color(0, 0, 0, 255).getRGB());
							}

						} else if (rgb1 < 760) { // 1 black
							if (pixel1.getColor().getAlpha() == 0 && pixel2.getColor().getAlpha() == 0) {
								imageOut.setRGB(xPosition, yPosition, new Color(0, 0, 0, 0).getRGB());
							} else {
								imageOut.setRGB(xPosition, yPosition, new Color(0, 0, 0, 255).getRGB());
							}
						} else if (rgb2 < 760) { // 2 black
							if (pixel1.getColor().getAlpha() == 0 && pixel2.getColor().getAlpha() == 0) {
								imageOut.setRGB(xPosition, yPosition, new Color(0, 0, 0, 0).getRGB());
							} else {
								imageOut.setRGB(xPosition, yPosition, new Color(0, 0, 0, 255).getRGB());
							}
						} else { // both white
							if (pixel1.getColor().getAlpha() == 0 && pixel2.getColor().getAlpha() == 0) {
								imageOut.setRGB(xPosition, yPosition, new Color(255, 255, 255, 0).getRGB());
							} else {
								imageOut.setRGB(xPosition, yPosition, new Color(255, 255, 255, 255).getRGB());
							}
						}

					}

				}
/*
				else if (equalition == TypeOfEqualition.SUBSTRATING) {
					Pixel pixel1 = new Pixel(xPosition, yPosition, new Color(imageIn1.getRGB(xPosition, yPosition), true));

					if (yPosition + heightPosition2 > imageIn2.getHeight() - 1) {

						imageOut.setRGB(xPosition, yPosition, pixel1.getColor().getRGB());

					} else if (xPosition + widthPosition2 > imageIn2.getWidth() - 1) {
						imageOut.setRGB(xPosition, yPosition, pixel1.getColor().getRGB());

					}

					else {

						Pixel pixel2 = new Pixel(xPosition + widthPosition2, yPosition + heightPosition2,
								new Color(imageIn2.getRGB(xPosition, yPosition), true));
						int rgb1 = pixel1.getRgbSum();
						int rgb2 = pixel2.getRgbSum();
						if (rgb1 < 760 && rgb2 < 760) { // both black

							if (pixel1.getColor().getAlpha() == 0 && pixel2.getColor().getAlpha() == 0) {
								imageOut.setRGB(xPosition, yPosition, new Color(255, 255, 255, 0).getRGB());
							} else {
								imageOut.setRGB(xPosition, yPosition, new Color(255, 255, 255, 255).getRGB());
							}

						} else if (rgb1 < 760) { // 1 black
							if (pixel1.getColor().getAlpha() == 0 && pixel2.getColor().getAlpha() == 0) {
								imageOut.setRGB(xPosition, yPosition, new Color(0, 0, 0, 0).getRGB());
							} else {
								imageOut.setRGB(xPosition, yPosition, new Color(0, 0, 0, 255).getRGB());
							}
						} else if (rgb2 < 760) { // 2 black
							if (pixel1.getColor().getAlpha() == 0 && pixel2.getColor().getAlpha() == 0) {
								imageOut.setRGB(xPosition, yPosition, new Color(0, 0, 0, 0).getRGB());
							} else {
								imageOut.setRGB(xPosition, yPosition, new Color(0, 0, 0, 255).getRGB());
							}
						} else { // both white
							if (pixel1.getColor().getAlpha() == 0 && pixel2.getColor().getAlpha() == 0) {
								imageOut.setRGB(xPosition, yPosition, new Color(255, 255, 255, 0).getRGB());
							} else {
								imageOut.setRGB(xPosition, yPosition, new Color(255, 255, 255, 255).getRGB());
							}
						}

					}

				}

				
				*/
			}

		}
	}
}
