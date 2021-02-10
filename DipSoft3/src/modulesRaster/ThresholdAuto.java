package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dip.Coverage;
import dip.Loader;
import dip.Pixel;

public class ThresholdAuto {

	private BufferedImage imageIn;

	public ThresholdAuto(BufferedImage imageIn) {

		this.imageIn = imageIn;
	}

	/**
	 * Changes given image with thresholding filter into 1 byte image. Pixel is
	 * changed into black if its rgb value is smaller than a thresholding border.
	 * The border is automatically calculated from coverage.
	 * Each step is calculated by adding or substracting 10 from thresholdborder according to coverage
	 *
	 *
	 * @param finalCoverage Needed coverage
	 * 
	 * @param margin  margin of coverage calculation
	 */

	public BufferedImage getThresholdAuto(double finalCoverage, double margin) {
		BufferedImage imageOut;

		int step = 0;
		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		// Loader loader = new Loader();

		Coverage tempCoverage = new Coverage(imageOut);
		int thresholdingBorder = (int) (Math.random() * 765);

		while (tempCoverage.getCoveregeInPercentExcludeTransparentAndWhite() < finalCoverage - (finalCoverage * margin)
				|| tempCoverage.getCoveregeInPercentExcludeTransparentAndWhite() > finalCoverage
						+ (finalCoverage * margin))

		{

			for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
				for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {
					Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition)));

					if (pixel.getColor().getAlpha() == 0) {

						continue;
					} else {

						if (pixel.getRgbSum() < thresholdingBorder) {
							Color newColor = new Color(0, 0, 0, 255); // czarny
							imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

						} else {
							Color newColor = new Color(255, 255, 255, 0); // bia³y
							imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

						}
					}
				}

			}
			System.out.println("Tmp coverage " + tempCoverage.getCoveregeInPercentExcludeTransparentAndWhite());
			System.out.println("Final coverage " + finalCoverage);
			System.out.println("border " + thresholdingBorder);
			System.out.println("step " + step);
			System.out.println("------------------------------------");
			step++;

			if (tempCoverage.getCoveregeInPercentExcludeTransparentAndWhite() < finalCoverage
					- (finalCoverage * margin)) {
				thresholdingBorder = thresholdingBorder + 10;
			} else {
				thresholdingBorder = thresholdingBorder - 10;
			}
		}
		return imageOut;
	}
  
	/**
	 * Changes given image with thresholding filter into 1 byte image. Pixel is
	 * changed into black if its rgb value is smaller than a thresholding border.
	 * The border is automatically calculated from coverage.
	 * Each step is calculated by adding or substracting calculated % from thresholdborder according to coverage
	 *
	 *
	 * @param finalCoverage Needed coverage
	 * 
	 * @param margin  margin of coverage calculation
	 */

	public BufferedImage getThresholdAuto2(double finalCoverage, double margin) {
		BufferedImage imageOut;
		int step = 0;

		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		// Loader loader = new Loader();

		Coverage tempCoverage = new Coverage(imageOut);
		int thresholdingBorder = (int) (Math.random() * 765);

		while (tempCoverage.getCoveregeInPercentExcludeTransparentAndWhite() < finalCoverage - (finalCoverage * margin)
				|| tempCoverage.getCoveregeInPercentExcludeTransparentAndWhite() > finalCoverage
						+ (finalCoverage * margin))

		{

			for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
				for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {
					Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition)));

					if (pixel.getColor().getAlpha() == 0) {

						continue;
					} else {

						if (pixel.getRgbSum() < thresholdingBorder) {
							Color newColor = new Color(0, 0, 0, 255); // czarny
							imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

						} else {
							Color newColor = new Color(255, 255, 255, 0); // bia³y
							imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

						}
					}
				}

			}
			System.out.println("Tmp coverage " + tempCoverage.getCoveregeInPercentExcludeTransparentAndWhite());
			System.out.println("Final coverage " + finalCoverage);
			System.out.println("border " + thresholdingBorder);
			System.out.println("step " + step);
			System.out.println("------------------------------------");
			step++;

			if (tempCoverage.getCoveregeInPercentExcludeTransparentAndWhite() < finalCoverage
					- (finalCoverage * margin)) {
				thresholdingBorder = thresholdingBorder + (int)(thresholdingBorder*Math.abs((tempCoverage.getCoveregeByLuminosityExcludeTransparentAndWhite() - finalCoverage)));
			} else {
				thresholdingBorder = thresholdingBorder - (int)(thresholdingBorder*Math.abs((tempCoverage.getCoveregeByLuminosityExcludeTransparentAndWhite() - finalCoverage)));
				
			}
		}
		return imageOut;
	}

}
