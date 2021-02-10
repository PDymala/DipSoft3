package modulesRaster.colorPaletteTransformationFiles;

import java.util.Comparator;

public class DataComparator implements Comparator<PixelColorPalette>{
		 
	    public int compare(PixelColorPalette e1, PixelColorPalette e2) {
	        if(e1.getDistanceToColorByRGBDistance() > (e2.getDistanceToColorByRGBDistance())){
	            return 1;
	        } else {
	            return -1;
	        }
	    }
	}
