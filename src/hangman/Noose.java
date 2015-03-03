package hangman;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Noose {

	private int width;
	private int height;

	public Noose(/* int width, int height */) {
		// this.width = width;
		// this.height = height;
	}

	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.drawLine(450, 250, 450, 450);
		g.drawLine(450, 600, 380, 545);
		// g.drawLine((int)(width*.8), (int)(height*.2), (int)(width*.8),
		// (int)(height*.8));
		// g.drawLine((int)(width*.3), (int)(height*.8), (int)(width*.9),
		// (int)(height*.8));

	}
}
