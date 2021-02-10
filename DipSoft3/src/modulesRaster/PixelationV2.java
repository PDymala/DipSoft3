package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dip.Loader;
import dip.Pixel;

public class PixelationV2 {

	private BufferedImage imageOut;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	/**
	 * Blurrs the image with a filter. Each pixel is an average of surrounding
	 * pixels including weights of each position.
	 * 
	 * @param imageIn
	 *            BufferedImage to be changed
	 * @param typeOfBlurr
	 *            Predefined filters, e.g. MEAN (each pixels weights 1)
	 * 
	 */

	public PixelationV2(BufferedImage imageIn, int blurrWidth, int blurrHeight) {

		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);

		
		Loader loader = new Loader();
		
		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition = yPosition + blurrHeight) {

			// p�tla dla ka�dego nowego piksela na wysoko�� za�adowanego obrazu
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition = xPosition + blurrWidth) {

				loader.load(yPosition, imageIn.getHeight());
				
				// p�tla dla ka�dego nowego piksela na szeroko�� za�adowanego obrazu
				HashMap<Integer, Pixel> pixele = new HashMap<Integer, Pixel>();
				
				int temp = 0;
				Double avRED = 0.0;
				Double avGREEN = 0.0;
				Double avBLUE = 0.0;
				Double avAlpha = 0.0;	

				for (int pY = 0; pY < blurrHeight; pY++) {

					// p�tla dla ka�dego nowego piksela na wysoko�� za�adowanego obrazu
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
				}}
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
						Color newColor = new Color(avRED.intValue(), avGREEN.intValue(), avBLUE.intValue());
						imageOut.setRGB((int)pixele.get(z).getxPosition(),(int) pixele.get(z).getyPosition(), newColor.getRGB());

					}
				}

			}

		}

	}

}
