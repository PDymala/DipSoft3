package dip;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufImage {
	private BufferedImage image;

	public BufferedImage getImage() {
		return image;
	}

	public enum OutputFileType {
		JPG("jpg"), TIFF("tiff"), GIF("gif"), BMP("bmp"), PNG("png");

		private final String name;

		OutputFileType(String s) {
			name = s;
		}

	}

	/**
	 * Reads image from given file name and saves as BufferedImage in memory
	 *
	 * @param fileName
	 *            absolute directory of file to read
	 *
	 */
	public BufImage(String fileName) {

		try {
			System.out.println("Loading image...");
			File input = new File(fileName);
			image = ImageIO.read(input);

		} catch (IOException e) {
			System.out.println("BufferedImage error");

		}

	}

	/**
	 * Saves given BufferedImage into standalone file
	 *
	 * @param image
	 *            BufferedImage in memory to be saved in standalone file
	 *
	 * @param fileType
	 *            Type of file to be saved
	 *
	 * @param outputFileName
	 *            Name of output file. Has to have same type(suffix) that fileType
	 *
	 */
	public BufImage(BufferedImage image, OutputFileType fileType, String outputFileName) {
		
		File output = new File(outputFileName);
		try {
			System.out.println("Saving image...");
			ImageIO.write(image, fileType.name, output);
		} catch (IOException e) {
			System.out.println("BufferedImage error");
		}
	}

	
	
}
