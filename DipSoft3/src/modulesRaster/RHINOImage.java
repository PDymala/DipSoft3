package modulesRaster;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;


import dip.Loader;
import dip.Pixel;


//add posibitlity to change proportions somehow ? :)
// different color proprtions in each category
public class RHINOImage {

	private BufferedImage imageOut;

	public BufferedImage getImageOut() {
		return imageOut;
	}
	
	public RHINOImage(BufferedImage imageIn, int thresholdingBorder){
		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();
	
		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {
				loader.load(yPosition, imageIn.getHeight());
				
				
				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true));
				if (pixel.getColor().getAlpha() == 0) {

					continue;
				} else {
				
					if (pixel.getRgbSum() < thresholdingBorder) {
					 // warunek czy piksel ma byc widoczny czy niewidoczny w IR / tworzymy kontrast
						Random rand = new Random();
						int x = rand.nextInt(9);
						// losujemy kolor w proporcji K = 60%, pozosta³e = 40%
						if (x==8 || x==9 || x==6 || x==3 || x==5 || x==2) {
							//K
							Color newColor = new Color(0,0,0);
							imageOut.setRGB(xPosition, yPosition, newColor.getRGB());
						}
						else if (x == 4) {
							//M
							Color newColor = new Color(255, 0, 255);
							imageOut.setRGB(xPosition, yPosition, newColor.getRGB());				
						}
						else if (x == 7 || x == 0) {
							//Y
							Color newColor = new Color(255, 255, 0);
							imageOut.setRGB(xPosition, yPosition, newColor.getRGB());	
						}		
						else {
						// x = 1
							//C
							Color newColor = new Color(0, 255, 255);
							imageOut.setRGB(xPosition, yPosition, newColor.getRGB());
							
						}
					}
					
					else {
					// warunek je¿eli piksel ma byæ	
						Random rand = new Random();
						int x = rand.nextInt(9);
						 // losujemy piksel w proporcji K = 30%, reszta 70%
						if (x==4 || x==9 || x==0) {
							//K
							Color newColor = new Color(0,0,0);
							imageOut.setRGB(xPosition, yPosition, newColor.getRGB());
						}
						else if (x == 4 || x==3 || x==7) {
							//M
							Color newColor = new Color(255, 0, 255);
							imageOut.setRGB(xPosition, yPosition, newColor.getRGB());				
						}
						else if (x == 2  || x==5) {
							//Y
							Color newColor = new Color(255, 255, 0);
							imageOut.setRGB(xPosition, yPosition, newColor.getRGB());		
						}		
						else {
						// x = 1
							//C
							Color newColor = new Color(0, 255, 255);
							imageOut.setRGB(xPosition, yPosition, newColor.getRGB());
										
							
						}

					}		
				}		
			}
												
		}
		
	} 

}
