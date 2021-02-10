package modulesRaster;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Collections;

import dip.Loader;
import dip.Pixel;

// ok

public class ImageDestroyer {

	private BufferedImage imageOut;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	public enum Method {
		empty, randomColor, white, black;
	}

	/**
	 * Destroys the image with pixels
	 *
	 * @param imageIn BufferedImage to be changed
	 *
	 * @param percent percent of image to destroy
	 *
	 * @param method  type of pixels
	 */

	public ImageDestroyer(BufferedImage imageIn, double percent, Method method) {

		imageOut = imageIn;
		Loader loader = new Loader();

		int numberofPixelsModified = (int) (imageIn.getHeight() * imageIn.getWidth() * percent) / 100;
		for (int x = 0; x < numberofPixelsModified; x++) {

			loader.load(x, numberofPixelsModified);

			int randomWidth = (int) (Math.random() * imageIn.getWidth());
			int randomHeight = (int) (Math.random() * imageIn.getHeight());

			if (method == Method.empty) {

				Color newColor = new Color(0, 0, 0, 0);
				imageOut.setRGB(randomWidth, randomHeight, newColor.getRGB());

			} else if (method == Method.randomColor) {

				Color newColor = new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
						(int) (Math.random() * 255), 255);
				imageOut.setRGB(randomWidth, randomHeight, newColor.getRGB());

			} else if (method == Method.white) {

				Color newColor = new Color(255, 255, 255, 255);
				imageOut.setRGB(randomWidth, randomHeight, newColor.getRGB());

			} else if (method == Method.black) {
				Color newColor = new Color(0, 0, 0, 255);
				imageOut.setRGB(randomWidth, randomHeight, newColor.getRGB());

			}

		}

	}

	public ImageDestroyer(BufferedImage imageIn, double percent, Method method, double squareSize) {

		imageOut = imageIn;
		Loader loader = new Loader();

		int numberofPixelsModified = (int) (imageIn.getHeight() * imageIn.getWidth() * percent) / 100;
		for (int x = 0; x < numberofPixelsModified; x++) {

			loader.load(x, numberofPixelsModified);

			int randomWidth = (int) (Math.random() * imageIn.getWidth());
			int randomHeight = (int) (Math.random() * imageIn.getHeight());

			if (method == Method.empty) {

				for (int z = 0; z < squareSize; z++) {

					if (randomWidth + z >= imageIn.getWidth()) {
						break;
					}
					for (int zz = 0; zz < squareSize; zz++) {

						if (randomHeight + zz >= imageIn.getHeight()) {
							break;
						} else {
							Color newColor = new Color(0, 0, 0, 0);
							imageOut.setRGB(randomWidth + z, randomHeight + zz, newColor.getRGB());

						}

					}

				}

			} else if (method == Method.randomColor) {

				Color newColor = new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
						(int) (Math.random() * 255), 255);
				imageOut.setRGB(randomWidth, randomHeight, newColor.getRGB());

			} else if (method == Method.white) {

				Color newColor = new Color(255, 255, 255, 255);
				imageOut.setRGB(randomWidth, randomHeight, newColor.getRGB());

			} else if (method == Method.black) {
				Color newColor = new Color(0, 0, 0, 255);
				imageOut.setRGB(randomWidth, randomHeight, newColor.getRGB());

			}

		}

	}
// mnustwo bledow wyskakuje ale cos tam dziala :D
	
	public ImageDestroyer(BufferedImage imageIn, double percent, double squareSize) {

		imageOut = imageIn;
		Loader loader = new Loader();

		int numberofPixelsModified = (int) (imageIn.getHeight() * imageIn.getWidth() * percent) / 100;
		for (int x = 0; x < numberofPixelsModified; x++) {

			loader.load(x, numberofPixelsModified);

			int randomWidthInput = (int) (Math.random() * imageIn.getWidth());
			int randomHeightInput = (int) (Math.random() * imageIn.getHeight());

			Pixel[][] matrix = new Pixel[(int) squareSize][(int) squareSize];
			for (int z = 0; z < squareSize; z++) {

				if (randomWidthInput + z >= imageIn.getWidth()) {
					break;
				}
				for (int zz = 0; zz < squareSize; zz++) {
					try {
						matrix[z][zz] = new Pixel(randomWidthInput + z, randomHeightInput + zz,
								new Color(imageIn.getRGB(randomWidthInput + z, randomHeightInput + zz), true));
					} catch (ArrayIndexOutOfBoundsException e) {
						// e.printstackTrace();
					}
				}

			}

			//

			int randomWidthInput2 = (int) (Math.random() * imageIn.getWidth());
			int randomHeightInput2 = (int) (Math.random() * imageIn.getHeight());

			Pixel[][] matrix2 = new Pixel[(int) squareSize][(int) squareSize];
			for (int z = 0; z < squareSize; z++) {

				if (randomWidthInput2 + z >= imageIn.getWidth()) {
					break;
				}
				for (int zz = 0; zz < squareSize; zz++) {

					try {
						matrix2[z][zz] = new Pixel(randomWidthInput2 + z, randomHeightInput2 + zz,
								new Color(imageIn.getRGB(randomWidthInput2 + z, randomHeightInput2 + zz), true));
					} catch (ArrayIndexOutOfBoundsException e) {
						// e.printstackTrace();
					}
				}

			}

			for (int z = 0; z < squareSize; z++) {

				if (randomWidthInput2 + z >= imageIn.getWidth()) {
					break;
				}
				for (int zz = 0; zz < squareSize; zz++) {

					if (randomHeightInput2 + zz >= imageIn.getHeight()) {
						break;
					} else {

						if (matrix2[z][zz] == null && matrix[z][zz] == null) {
							try {
								imageIn.setRGB((int) matrix[z][zz].getxPosition(), (int) matrix[z][zz].getyPosition(),
										new Color(0, 0, 0).getRGB());

								imageIn.setRGB((int) matrix2[z][zz].getxPosition(), (int) matrix2[z][zz].getyPosition(),
										new Color(0, 0, 0).getRGB());
							} catch (NullPointerException e) {
								// e.printstackTrace();
							}

						} else if (matrix2[z][zz] == null) {
							try {
								imageIn.setRGB((int) matrix[z][zz].getxPosition(), (int) matrix[z][zz].getyPosition(),
										new Color(0, 0, 0).getRGB());
								imageIn.setRGB((int) matrix2[z][zz].getxPosition(), (int) matrix2[z][zz].getyPosition(),
										matrix[z][zz].getColor().getRGB());
							} catch (NullPointerException e) {
								// e.printstackTrace();
							}

						} else if (matrix[z][zz] == null) {
							try {
								imageIn.setRGB((int) matrix[z][zz].getxPosition(), (int) matrix[z][zz].getyPosition(),
										matrix2[z][zz].getColor().getRGB());
								imageIn.setRGB((int) matrix2[z][zz].getxPosition(), (int) matrix2[z][zz].getyPosition(),
										new Color(0, 0, 0).getRGB());
							} catch (NullPointerException e) {
								// e.printstackTrace();
							}

						} else {
							try {
								imageIn.setRGB((int) matrix[z][zz].getxPosition(), (int) matrix[z][zz].getyPosition(),
										matrix2[z][zz].getColor().getRGB());
								imageIn.setRGB((int) matrix2[z][zz].getxPosition(), (int) matrix2[z][zz].getyPosition(),
										matrix[z][zz].getColor().getRGB());

							} catch (NullPointerException e) {
								// e.printstackTrace();
							}

						}

					}

				}

			}

		}

	}
}
