package modulesRaster;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dip.DrawingCounter;
import dip.Loader;
import dip.Pixel;
import javafx.scene.shape.Line;

public class GibberishLines2 {

	private BufferedImage imageOut;
	private BufferedImage imageIn;

	public BufferedImage getImageOut() {
		return imageOut;
	}

	public GibberishLines2(BufferedImage imageIn) {
		this.imageIn = imageIn;
	}

	public void getImage(int numberOfRandomLines) {
		Pixel[][] grid = new Pixel[imageIn.getHeight()][imageIn.getWidth()];
		imageOut = new BufferedImage(imageIn.getWidth(), imageIn.getHeight(), BufferedImage.TYPE_INT_ARGB);

		for (int yPosition = 0; yPosition < imageIn.getHeight(); yPosition++) {
			for (int xPosition = 0; xPosition < imageIn.getWidth(); xPosition++) {

				Pixel pixel = new Pixel(xPosition, yPosition, new Color(imageIn.getRGB(xPosition, yPosition), true));
				grid[yPosition][xPosition] = pixel;

			}
		}

		Graphics2D g2d = imageOut.createGraphics();

		for (int x = 0; x < numberOfRandomLines; x++) {
			int aX = (int) (Math.random() * imageIn.getWidth());
			int aY = (int) (Math.random() * imageIn.getHeight());

			int bX = (int) (Math.random() * imageIn.getWidth());
			int bY = (int) (Math.random() * imageIn.getHeight());

			List<Pixel> ololo = getPixelsfromLine(grid, aX, aY, bX, bY);
			Color temp = getAverageColorFromLine(ololo);

			g2d.setColor(temp);
			g2d.draw(new Line2D.Double(aX, aY, bX, bY));
		}

		g2d.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));

	}

	public Color getAverageColorFromLine(List<Pixel> pixelList) {

		int r = 0;
		int g = 0;
		int b = 0;

		for (Pixel singlePixel : pixelList) {
			r += singlePixel.getColor().getRed();
			g += singlePixel.getColor().getGreen();
			b += singlePixel.getColor().getBlue();
		}

		return new Color((int) (r / pixelList.size()), (int) (g / pixelList.size()), (int) (b / pixelList.size()));
	}

	public List<Pixel> getPixelsfromLine(Pixel[][] grid, int x0, int y0, int x1, int y1) {

		List<Pixel> line = new ArrayList<Pixel>();

		int dx = Math.abs(x1 - x0);
		int dy = Math.abs(y1 - y0);

		int sx = x0 < x1 ? 1 : -1;
		int sy = y0 < y1 ? 1 : -1;

		int err = dx - dy;
		int e2;
		int currentX = x0;
		int currentY = y0;

		while (true) {
			line.add(grid[currentY][currentX]);

			if (currentX == x1 && currentY == y1) {
				break;
			}

			e2 = 2 * err;
			if (e2 > -1 * dy) {
				err = err - dy;
				currentX = currentX + sx;
			}

			if (e2 < dx) {
				err = err + dx;
				currentY = currentY + sy;
			}
		}

		return line;

	}

}
