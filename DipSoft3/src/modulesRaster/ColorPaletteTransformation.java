package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dip.Loader;
import dip.Pixel;
import modulesRaster.colorPaletteTransformationFiles.DataComparator;
import modulesRaster.colorPaletteTransformationFiles.DataComparator2;
import modulesRaster.colorPaletteTransformationFiles.PixelColorPalette;


// http://colormind.io/   !! :)

public class ColorPaletteTransformation {

	private BufferedImage imageOut;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	/**
	 * Changes the color of each pixel with the closest one from the color palette. Closest color is taken as a distance of R G and B added together
	 * 
	 * @param imageIn
	 *            BufferedImage to be changed
	 * 
	 * @param colorPalette
	 *            matrix of color - color palette.

	 * 
	 * 
	 * 
	 */
	public ColorPaletteTransformation(BufferedImage imageIn, Color[] colorPalette) {
		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();

		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {

				loader.load(yPosition, imageIn.getHeight());

				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true));
				if (pixel.getColor().getAlpha() == 0) {

					continue;
				} else {
					ArrayList<PixelColorPalette> temp = new ArrayList<PixelColorPalette>();
					for (int x = 0; x < colorPalette.length; x++) {

						temp.add(new PixelColorPalette(xPosition, yPosition, pixel.getColor(), colorPalette[x]));

					}

					temp.sort(new DataComparator2());

					Color newColor = new Color(temp.get(0).getColorDynamic().getRed(), temp.get(0).getColorDynamic().getGreen(),
							temp.get(0).getColorDynamic().getBlue(), temp.get(0).getColorDynamic().getAlpha());
					imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

				}

			}
		}
	}

}
