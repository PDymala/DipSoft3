package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dip.Loader;
import dip.Pixel;

public class ThresholdingManual2 {

	private BufferedImage imageOut;
	int heightSkip;
	int weightSkip;
	int size;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	/**
	 * Changes given image with thresholding filter into 1 byte image. Pixel is
	 * changed into black if its rgb value is smaller than a thresholding border
	 *
	 * @param imageIn
	 *            BufferedImage to be changed
	 *
	 * @param heightSkip
	 *            Diluting the filter in Y direction
	 *
	 * @param weightSkip
	 *            Diluting the filter in X direction
	 *
	 * @param size
	 *            size of dots
	 *
	 * @param thresholdingBorder
	 *            border value of color change
	 */
	public ThresholdingManual2(BufferedImage imageIn, int heightSkip, int weightSkip, int size,
			int thresholdingBorder) {
		this.heightSkip = heightSkip;
		this.weightSkip = weightSkip;
		this.size = size;

		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();
		
		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition = yPosition + heightSkip + size) {
			// pêtla dla ka¿dego nowego piksela na wysokoœæ za³adowanego obrazu
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition = xPosition + weightSkip + size) {
				loader.load(yPosition, imageIn.getHeight());
				// pêtla dla ka¿dego nowego piksela na szerokoœæ za³adowanego obrazu
				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition)));

				if (pixel.getColor().getAlpha() == 0) {

					continue;
				} else {

					// RED GREEN i BLUE
					for (int tempX = 0; tempX < size; tempX++) {
						for (int tempY = 0; tempY < size; tempY++) {

							if (pixel.getRgbSum() < thresholdingBorder) {
								Color newColor = new Color(0, 0, 0, 255); // czarny
								imageOut.setRGB(xPosition + tempX, yPosition + tempY, newColor.getRGB());

							} else {
								Color newColor = new Color(255, 255, 255, 0); // bia³y
								imageOut.setRGB(xPosition + tempX, yPosition + tempY, newColor.getRGB());

							}
						}
					}

				}

			}
		}

	}

	/**
	 * Changes given image with thresholding filter into 1 byte image. Pixel is
	 * changed into black if its rgb value is smaller than a thresholding border
	 *
	 * @param imageIn
	 *            BufferedImage to be changed
	 *
	 * @param thresholdingBorder
	 *            border value of color change
	 */
	public ThresholdingManual2(BufferedImage imageIn, int thresholdingBorder) {
		heightSkip = 0;
		weightSkip = 0;
		size = 1;

		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();
		
		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition = yPosition + heightSkip + size) {
			// pêtla dla ka¿dego nowego piksela na wysokoœæ za³adowanego obrazu
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition = xPosition + weightSkip + size) {
				loader.load(yPosition, imageIn.getHeight());
				// pêtla dla ka¿dego nowego piksela na szerokoœæ za³adowanego obrazu
				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition)));

				if (pixel.getColor().getAlpha() == 0) {

					continue;
				} else {

					// RED GREEN i BLUE
					for (int tempX = 0; tempX < size; tempX++) {
						for (int tempY = 0; tempY < size; tempY++) {

							if (pixel.getRgbSum() < thresholdingBorder) {
								Color newColor = new Color(0, 0, 0, 255); // czarny
								imageOut.setRGB(xPosition + tempX, yPosition + tempY, newColor.getRGB());

							} else {
								Color newColor = new Color(255, 255, 255, 0); // bia³y
								imageOut.setRGB(xPosition + tempX, yPosition + tempY, newColor.getRGB());

							}
						}
					}

				}

			}
		}

	}

}
