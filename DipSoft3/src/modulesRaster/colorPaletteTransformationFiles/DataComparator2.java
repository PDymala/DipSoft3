package modulesRaster.colorPaletteTransformationFiles;

import java.util.Comparator;

public class DataComparator2 implements Comparator<PixelColorPalette>{
		 
	    public int compare(PixelColorPalette e1, PixelColorPalette e2) {
	        if(e1.getDistanceToColorByPythagoraDistance() > (e2.getDistanceToColorByPythagoraDistance())){
	            return 1;
	        } else {
	            return -1;
	        }
	    }
	}
