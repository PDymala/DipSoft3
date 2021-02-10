package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import dip.Loader;
import dip.Pixel;
import modulesRaster.colorPaletteTransformationFiles.DataComparator2;
import modulesRaster.colorPaletteTransformationFiles.PixelColorPalette;

public class CLatentImage {

	BufferedImage imageIn;

	public CLatentImage(BufferedImage imageIn) {
		this.imageIn = imageIn;
	}

	public BufferedImage getCLatentImage(int blurrWidth, int blurrHeight, Color[] colorPalette, int numberOfStripesVertical, int numberOfStripesHorizontal) {

		BufferedImage imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(),
				BufferedImage.TYPE_INT_ARGB);

		Loader loader = new Loader();

		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition = yPosition + (blurrHeight*numberOfStripesVertical )) {

			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition = xPosition +( blurrWidth*numberOfStripesHorizontal) ) {

				loader.load(yPosition, imageIn.getHeight());

				HashMap<Integer, Pixel> pixele = new HashMap<Integer, Pixel>();

				int temp = 0;
				Double avRED = 0.0;
				Double avGREEN = 0.0;
				Double avBLUE = 0.0;
				Double avAlpha = 0.0;

				for (int pY = 0; pY < blurrHeight; pY++) {

					for (int pX = 0; pX < blurrWidth; pX++) {

						if (pX + xPosition < 0 || pX + xPosition + 1 > imageIn.getWidth() || pY + yPosition < 0
								|| pY + yPosition + 1 > imageIn.getHeight()) {
							pixele.put(temp, null);
						} else {
							Pixel tempPixel = new Pixel(pX + xPosition, pY + yPosition,
									new Color(imageIn.getRGB(pX + xPosition, pY + yPosition), true));
							pixele.put(temp, tempPixel);

							avRED = avRED + tempPixel.getColor().getRed();
							avGREEN = avGREEN + tempPixel.getColor().getGreen();
							avBLUE = avBLUE + tempPixel.getColor().getBlue();
							avAlpha = avAlpha + tempPixel.getColor().getAlpha();
							temp++;
						}
					}
				}
				avRED = avRED / temp;
				avGREEN = avGREEN / temp;
				avBLUE = avBLUE / temp;
				avAlpha = avAlpha / temp;
				for (int z = 0; z < pixele.size(); z++) {

					if (pixele.isEmpty()) {
						break;

					} else if (pixele.get(z) == null) {
						break;
					} else {

						ArrayList<PixelColorPalette> temp2 = new ArrayList<PixelColorPalette>();
						for (int x = 0; x < colorPalette.length; x++) {

							temp2.add(new PixelColorPalette(xPosition, yPosition,
									new Color(avRED.intValue(), avGREEN.intValue(), avBLUE.intValue()),
									colorPalette[x]));

						}

						temp2.sort(new DataComparator2());

						Color newColor2 = new Color(temp2.get(0).getColorDynamic().getRed(),
								temp2.get(0).getColorDynamic().getGreen(), temp2.get(0).getColorDynamic().getBlue(),
								temp2.get(0).getColorDynamic().getAlpha());

						imageOut.setRGB((int) pixele.get(z).getxPosition(), (int) pixele.get(z).getyPosition(),
								newColor2.getRGB());

					}
				}

			}

		}

		return imageOut;

	}


}
