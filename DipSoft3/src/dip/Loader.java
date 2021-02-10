package dip;

public class Loader {

	private float percentage = 0;
	private long start = 0;
	
	public Loader() {
		start = System.currentTimeMillis();
	}

	public void load(int yPosition, int pictureHeight) {
		long elapsedTimeMillis = System.currentTimeMillis()-start;

		float percentage2 = yPosition * 100 / pictureHeight;
		float elapsedTimeSec = elapsedTimeMillis/1000F;
		
		if (percentage2 != percentage) {
			System.out.println((float) (percentage2) +"% - "+elapsedTimeSec + " sec" );
			
			System.out.println((float) (percentage2) +"% - time left: "+((elapsedTimeSec*100/percentage2)-elapsedTimeSec) + " sec" );
			
		
			percentage = percentage2;

		}
		
	}

}
