package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dip.Loader;
import dip.Pixel;
import modulesRaster.imigmaColor.PixelCoding2;
import modulesRaster.imigmaColorSimple.Rotor;

public class ImigmaColorSimple {

	private BufferedImage imageOut;

	public BufferedImage getImageOut() {
		return imageOut;
	}
	public enum Method {
		code, decode;
	}

	/**
	 * Codes the values of a picture according to a database. QUite ineffective because always changes a value to the same value. No mixing included.
	 * Therefore You can see the outlines of the right image
	 * 
	 * @param imageIn
	 *            BufferedImage to be changed
	 * 
	 * @param code
	 * 				secret code for coding the image
	 * @param method
	 * 				either code or decode
	 * 
	 * 
	 */
	int pixelNumber=0;
	public ImigmaColorSimple(BufferedImage imageIn, String code, Method method) {
		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();
		
		Rotor rotor = new Rotor("C:\\Users\\Piotr\\PrivateWorkspace\\DipSoft3\\src\\modulesRaster\\imigmaColorSimple\\rotors.tsv", "aaaa");
		
		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {

				loader.load(yPosition, imageIn.getHeight());
				
				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true));
				if (pixel.getColor().getAlpha() == 0) {

					continue;
				} else {
					
					if (method.equals(Method.code)){
						
						Color newColor = new Color(rotor.getCodeNormalRotor(pixel.getColor().getRed()), rotor.getCodeNormalRotor(pixel.getColor().getGreen()), rotor.getCodeNormalRotor(pixel.getColor().getBlue()), pixel.getColor().getAlpha());
						imageOut.setRGB(xPosition, yPosition, newColor.getRGB());
						
						
					} else if (method.equals(Method.decode)) {
						Color newColor = new Color(rotor.getCodeReverseRotor(pixel.getColor().getRed()), rotor.getCodeReverseRotor(pixel.getColor().getGreen()), rotor.getCodeReverseRotor(pixel.getColor().getBlue()), pixel.getColor().getAlpha());
						imageOut.setRGB(xPosition, yPosition, newColor.getRGB());
						
					}
					
				
				//	System.out.println("px: " + pixelNumber + " " + pixel.getxPosition() + "x" + pixel.getyPosition()+ " " + "red: "+pixel.getColor().getRed() + " -> " + pixelCodingRed.getOutputText() + "|| green: "+pixel.getColor().getGreen() + " -> " + pixelCodingGreen.getOutputText() + " || blue: "+pixel.getColor().getBlue() + " -> " + pixelCodingBlue.getOutputText());
					//try {
					/*}catch(NumberFormatException e) {
						e.printStackTrace();
					}*/
					
					pixelNumber++;
				}
				
				
			}
		}
	}
	
	
	
	
	
}
