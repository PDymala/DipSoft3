package dip;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Coverage {

	
	private BufferedImage image;

	public Coverage(BufferedImage image) {
		this.image = image;
	}
	
	/**
	 * Calculates coverage of pixels in an image.
	 * white = included
	 * color = included
	 * transparent(alpha) = excluded 
	 */
	public double getCoveregeInPercentIncludeWhite() {

		double numberOfPixels = 0;
		double numberOfTransparentPixels = 0;

		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				Color c = new Color(image.getRGB(x, y), true);
				if (c.getAlpha() < 255) {
					numberOfTransparentPixels++;
				}
				numberOfPixels++;

			}
		}

		return ((numberOfPixels - numberOfTransparentPixels) / numberOfPixels);
	
	
	}
	/**
	 * Calculates coverage of pixels in an image.
	 * white = excluded
	 * color = included
	 * transparent(alpha) = excluded 
	 */
	public double getCoveregeInPercentExcludeTransparentAndWhite() {

		double numberOfPixels = 0.0;
		double numberOfTransparentPixels = 0.0;

		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				Color c = new Color(image.getRGB(x, y), true);
				if (c.getAlpha() < 255 || c.equals(Color.WHITE)) {
					numberOfTransparentPixels++;
				}
				numberOfPixels++;

			}
		}

		return ((numberOfPixels - numberOfTransparentPixels) / numberOfPixels);
	
	
	}
	
	/**
	 * Calculates coverage of pixels in an image.
	 * white = excluded
	 * color = included as % of it's shade (i.e. black = 1, gray = 0,5, white = 0, etc)
	 * transparent(alpha) = excluded 
	 */
	public double getCoveregeByLuminosityExcludeTransparentAndWhite() {
		
		
		double numberOfPixels = 0.0;
		double numberOfTransparentPixels = 0.0;

		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				Color c = new Color(image.getRGB(x, y), true);
				if (c.getAlpha() < 255 || c.equals(Color.WHITE)) {
					numberOfTransparentPixels++;
				}
			
				numberOfPixels = numberOfPixels+((c.getRed()+c.getBlue()+c.getGreen())/(765.0));

			}
		}

		return ((numberOfPixels - numberOfTransparentPixels) / numberOfPixels);
	
		
		
	}
	
	/**
	 * Calculates coverage of pixels in an image.
	 * white = excluded
	 * color = included as % of it's shade (i.e. black = 1, gray = 0,5, white = 0, etc)
	 * transparent(alpha) = excluded 
	 */
	public double getCoveregeByLuminosityAndTransparency() {
		
		// czy nie powinno takich sam=ych % jak ten wyzej?
		double numberOfPixels = 0.0;
		double numberOfTransparentPixels = 0.0;

		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				Color c = new Color(image.getRGB(x, y), true);
				numberOfTransparentPixels = numberOfTransparentPixels+((c.getRed()+c.getBlue()+c.getGreen())/(765.0))*(c.getAlpha()/255);
				numberOfPixels++;
			}
		}

		return ((numberOfPixels - numberOfTransparentPixels) / numberOfPixels);
	
		
		
	}
	
	
	
}
