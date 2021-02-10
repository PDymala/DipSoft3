package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;

import dip.Loader;
import dip.Pixel;

public class TruthTableOperator {
	private BufferedImage imageOut;
	
	public BufferedImage getImageOut() {
		return imageOut;
	}

	public enum Method {

		CONTRADICTION (255,255,255,255),
		NOR(255,255,255,0),
		CONVERSENONIMPLICATION(255,255,0,255),
		PNEGATION(255,255,0,0),
		NONIMPLICATION(255,0,255,255),
		QNEGATION(255,0,255,0),
		EXCLUSIVE(255,0,0,255),
		STROKE(255,0,0,0),
		CONJUCTION(0,255,255,255),
		LOGICALBICONDITIONAL(0,255,255,0),
		Q(0,255,0,255),
		MATERIALCONDITIONAL(0,255,0,0),
		P(0,0,255,255),
		CONVERSEIMPLICATION(0,0,255,0),
		ALTERNATION(0,0,0,255),
		TAUTOLOGT(255,0,0,0);
		
		
		 int[] values;

        Method(int... vals) {
            values = vals;
        }

        public int TT() {
            return values[0];
        }

        public int TF() {
            return values[1];
        }

        public int FT(){
            return  values[2];
        }
        public int FF(){
            return values[3];
        }
	}

	/**
	 * Changes given image with it's color space into black and white
	 *
	 * @param imageIn
	 *            BufferedImage to be changed
	 *
	 * @param method
	 *            type of color conversion (BlackAndWhite.Method enum)
	 */

	public TruthTableOperator(BufferedImage imageIn1, BufferedImage imageIn2, Method method) {

		imageOut = new BufferedImage(imageIn1.getWidth(), imageIn1.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Loader loader = new Loader();

		for (int yPosition = 0; yPosition < imageIn1.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn1.getWidth(); xPosition++) {
				loader.load(yPosition, imageIn1.getHeight());

				Pixel pixel1 = new Pixel(xPosition, yPosition, new Color(imageIn1.getRGB(xPosition, yPosition)));
				Pixel pixel2 = new Pixel(xPosition, yPosition, new Color(imageIn2.getRGB(xPosition, yPosition)));
				

					/*       public int TT() {
            return (int) values[0];
        }

        public int TF() {
            return (int) values[1];
        }

        public int FT(){
            return (int) values[2];
        }
        public int FF(){
            return (int) values[3];
        }
		*/			
			
				
				//TT
				if (pixel1.getRgbSum() <50 && pixel2.getRgbSum() <50  ) {
					Color newColor = new Color(method.TT(),method.TT(),method.TT());
					 imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

					
				}
				//TF
				else if(pixel1.getRgbSum() <50 && pixel2.getRgbSum() >750  ) {
				
	
					Color newColor = new Color(method.TF(),method.TF(),method.TF());
					imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

				}
				//FT
				else if(pixel1.getRgbSum() >750 && pixel2.getRgbSum()<50  ) {
				
				
					Color newColor = new Color(method.FT(),method.FT(),method.FT());
					imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

				
				}
				//FF
				else if(pixel1.getRgbSum() >750 && pixel2.getRgbSum() >750  ) {
					Color newColor = new Color(method.FF(),method.FF(),method.FF());
					imageOut.setRGB(xPosition, yPosition, newColor.getRGB());

				}	
				
				


				}

			}
		}
	}

