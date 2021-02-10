package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.imgscalr.Scalr;

import dip.Loader;

public class AlphaImage {

	private BufferedImage imageIn1;
	private BufferedImage imageIn2;
	private BufferedImage imageOut;
	
	// fajnie wygl¹da na bia³ym. Obraz dopiero widac jak sie podlozy czarne t³o :)
	// 

/**
 * Uses secondary picture as a peuso watermark, According to secondary picture color, changes alpha on first picture.
 * 
 * @param imageIn1
 *            BufferedImage to be changed
 *            
  @param imageIn2
 *            BufferedImage as watermark
 * 
 
 * 
 */
	public AlphaImage(BufferedImage imageIn1, BufferedImage imageIn2) {
		this.imageIn1 = imageIn1;
		this.imageIn2 = imageIn2;
		
	}
	/**
	 * Uses secondary picture as a peuso watermark, According to secondary picture color, changes alpha on first picture.
	 * Secondary picture is resized to first one and conversed to black and white.
	 * 
	 * @return picture after mod          
	 * 
	 */
	public BufferedImage getAlphaImageBWConversion() {
		imageOut = new BufferedImage(imageIn1.getWidth(), imageIn1.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		Loader loader = new Loader();
		
		

			if (imageIn2.getWidth() != imageIn1.getWidth() || imageIn2.getHeight() != imageIn1.getHeight()) {
			
			imageIn2 =  Scalr.resize(imageIn2, Scalr.Mode.AUTOMATIC, imageIn1.getWidth(), imageIn2.getHeight());
			
		}
		
		
		BlackAndWhite bAW = new BlackAndWhite(imageIn2);
		imageIn2 = bAW.getBlackAndWhiteImage(BlackAndWhite.Method.luminosity);
		
		
		
		
		for (int yPosition = 0; yPosition < imageIn1.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn1.getWidth(); xPosition++) {
				loader.load(yPosition, imageIn1.getHeight());
				
				//alpha jako red, bo wszystkie RGB maja te sama wartosc
						Color newColor = new Color(new Color(imageIn1.getRGB(xPosition, yPosition)).getRed(), new Color(imageIn1.getRGB(xPosition, yPosition)).getGreen(), new Color(imageIn1.getRGB(xPosition, yPosition)).getBlue(), new Color(imageIn2.getRGB(xPosition, yPosition)).getRed());
						imageOut.setRGB(xPosition, yPosition, newColor.getRGB());
					
					}

				}
		return imageOut;
			}
	public BufferedImage getAlphaImageThresholdingConversion() {
		imageOut = new BufferedImage(imageIn1.getWidth(), imageIn1.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		Loader loader = new Loader();
		
		

		if (imageIn2.getWidth() != imageIn1.getWidth() || imageIn2.getHeight() != imageIn1.getHeight()) {
			
			imageIn2 =  Scalr.resize(imageIn2, Scalr.Mode.AUTOMATIC, imageIn1.getWidth(), imageIn2.getHeight());
			
		}
		
		
		ThresholdingManual2 bAW = new ThresholdingManual2(imageIn2,350);
				imageIn2 = bAW.getImageOut();
		
		
		
		
		for (int yPosition = 0; yPosition < imageIn1.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn1.getWidth(); xPosition++) {
				loader.load(yPosition, imageIn1.getHeight());
				
				//alpha jako red, bo wszystkie RGB maja te sama wartosc
						Color newColor = new Color(new Color(imageIn1.getRGB(xPosition, yPosition)).getRed(), new Color(imageIn1.getRGB(xPosition, yPosition)).getGreen(), new Color(imageIn1.getRGB(xPosition, yPosition)).getBlue(), new Color(imageIn2.getRGB(xPosition, yPosition)).getRed());
						imageOut.setRGB(xPosition, yPosition, newColor.getRGB());
					
					}

				}
		return imageOut;
			}
	
	public BufferedImage getAlphaImageWithoutImage2() {
		imageOut = new BufferedImage(imageIn1.getWidth(), imageIn1.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		Loader loader = new Loader();
		
		
//tu zmienic na jakis temp?  musza byc lokalne BI? 
//		chyba zwsze glowne bI zmieniamy a powinnismy lokalne?
		
		BlackAndWhite bAW = new BlackAndWhite(imageIn1);
		imageIn1 = bAW.getBlackAndWhiteImage(BlackAndWhite.Method.luminosity);
		
		
		
		
		for (int yPosition = 0; yPosition < imageIn1.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn1.getWidth(); xPosition++) {
				loader.load(yPosition, imageIn1.getHeight());
				
				//alpha jako red, bo wszystkie RGB maja te sama wartosc
						Color newColor = new Color(255,255,255, new Color(imageIn1.getRGB(xPosition, yPosition)).getRed());
						imageOut.setRGB(xPosition, yPosition, newColor.getRGB());
					
					}

				}
		return imageOut;
			}
	
}