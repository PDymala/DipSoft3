package modulesRaster;
//Changed into return
import java.awt.Color;
import java.awt.image.BufferedImage;

import dip.Loader;
import dip.Pixel;
import modulesRaster.BlackAndWhite.Method;

public class Constrast {


	private double numberOfPixels;
	private double generalContrast = 0.0;
	private BufferedImage imageIn;


	/**
	 *Checking contrast on the basis of black and white
	 * 
	 * @param imageIn Checking contrast
	 * 
	 */
	
	public Constrast(BufferedImage imageIn) {
		this.imageIn = imageIn;
	}
	

	
	public double getHorizontalContrastByBW() {
		Loader loader = new Loader();
		Pixel pixel1;
		Pixel pixel2;
		double rgb1;
		double rgb2;
		double localdiv = 0.0;
		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn.getWidth()-1; xPosition++) {

				loader.load(yPosition, imageIn.getHeight());

				 pixel1 = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true));
				 pixel2= new Pixel(xPosition+1, yPosition, new Color(imageIn.getRGB(xPosition+1, yPosition), true));

				

					 rgb1=  (pixel1.getColor().getRed() * 0.2126 + pixel1.getColor().getGreen() * 0.7152 + pixel1.getColor().getBlue() * 0.0722);
					 rgb2=  (pixel2.getColor().getRed() * 0.2126 + pixel2.getColor().getGreen() * 0.7152 + pixel2.getColor().getBlue() * 0.0722);

				
					
					 if(rgb1>rgb2)  localdiv = rgb2/rgb1;
					 else if (rgb1<rgb2) localdiv = rgb1/rgb2;
					 else localdiv =0;
					 
					 
					generalContrast = generalContrast + localdiv;
				
					numberOfPixels++;
				

			}
		}
		

		return 	(	generalContrast / numberOfPixels)*100;

	}
	
}
