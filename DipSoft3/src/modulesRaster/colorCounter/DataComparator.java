package modulesRaster.colorCounter;

import java.util.Comparator;

public class DataComparator implements Comparator<colorExistance>{
		 
	    public int compare(colorExistance e1, colorExistance e2) {
	        if(e1.getExistance() > e2.getExistance()){
	            return 1;
	        } else {
	            return -1;
	        }
	    }
	}
