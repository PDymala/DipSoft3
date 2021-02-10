package DigiCode2_primesFiles;

import java.util.Comparator;

public class DataComparator implements Comparator<NearestFromArray>{
		 
	    public int compare(NearestFromArray e1, NearestFromArray e2) {
	        if(e1.getDistance() >= (e2.getDistance())){
	            return 1;
	        } else {
	            return -1;
	        }
	    }
	}
