package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.imgscalr.Scalr;

import dip.Loader;

public class DigiCode3_1_hiddenImageColor {

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
	public DigiCode3_1_hiddenImageColor(BufferedImage imageIn1, BufferedImage imageIn2) {
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
	public BufferedImage getHiddenColorImage() {
		imageOut = new BufferedImage(imageIn1.getWidth(), imageIn1.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		Loader loader = new Loader();
		
		

			if (imageIn2.getWidth() != imageIn1.getWidth() || imageIn2.getHeight() != imageIn1.getHeight()) {
			
			imageIn2 =  Scalr.resize(imageIn2, Scalr.Mode.AUTOMATIC, Math.floorDiv(imageIn1.getWidth(), 3), Math.floorDiv(imageIn2.getHeight(),3));
			
		}
		
		
		int counter = 0;
		int xPosition2 = 0;
		for (int yPosition = 0; yPosition < imageIn1.getHeight(); yPosition++) {
			xPosition2 = 0;
			for (int xPosition = 0; xPosition < imageIn1.getWidth(); xPosition++) {
				loader.load(yPosition, imageIn1.getHeight());
					
				
				Color newColor = null;
					if (xPosition2 > imageIn2.getWidth()-1  || yPosition > imageIn2.getHeight()-1) {
						
						 newColor = new Color(new Color(imageIn1.getRGB(xPosition, yPosition)).getRed(), 
									new Color(imageIn1.getRGB(xPosition, yPosition)).getGreen(), 
									new Color(imageIn1.getRGB(xPosition, yPosition)).getBlue());		
						
					} else {
				
				
			
								
						if (counter == 0) {
							
							 newColor = new Color(new Color(imageIn2.getRGB(xPosition2, yPosition)).getRed(), 
														new Color(imageIn1.getRGB(xPosition, yPosition)).getGreen(), 
														new Color(imageIn1.getRGB(xPosition, yPosition)).getBlue()
														);							
						}
						else if (counter ==1) {
							 newColor = new Color(new Color(imageIn1.getRGB(xPosition, yPosition)).getRed(), 
									new Color(imageIn2.getRGB(xPosition2, yPosition)).getGreen(), 
									new Color(imageIn1.getRGB(xPosition, yPosition)).getBlue());
							
						}
						else if (counter == 2) {
							 newColor = new Color(new Color(imageIn1.getRGB(xPosition, yPosition)).getRed(), 
									new Color(imageIn1.getRGB(xPosition, yPosition)).getGreen(), 
									new Color(imageIn2.getRGB(xPosition2, yPosition)).getBlue());
							
						}
						else if (counter >2) {
							counter =-1;
						}
						
						counter ++;
						continue;
						
					}
					imageOut.setRGB(xPosition, yPosition, newColor.getRGB());
					xPosition2++;
			}
				
				}
		return imageOut;
			}
	
	
}