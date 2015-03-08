package hangman;

import java.awt.Color;
import java.awt.Graphics;

public class Person {

	private int width;
	private int height;
	private int numOuts = -1;
	private boolean out;

	public Person(int width, int height) {

		out = false;
		this.width = width;
		this.height = height;
		// numOuts = -1;

	}

	public int getNumOuts() {
		return numOuts;
	}

	public void setNumOuts() {
		this.numOuts++;
	}

	public void resetOuts() {
		this.numOuts = -1;
	}

	public void draw(Graphics g) {
		// numOuts = numOuts+2;

		switch (numOuts) {
		case 0:
			g.drawOval((int) (width * .33), (int) (height * .2), (int) (105), (int) (105));
			break;
		case 1:
			g.drawOval((int) (width * .33), (int) (height * .2), (int) (105), (int) (105));
			g.setColor(Color.GREEN);

			g.fillOval((int) (width * .36), (int) (height * .25), (int) (10), (int) (10));

			g.fillOval((int) (width * .42), (int) (height * .25), (int) (10), (int) (10));

			break;
		case 2:
			g.drawOval((int) (width * .33), (int) (height * .2), (int) (105), (int) (105));
			g.setColor(Color.GREEN);

			g.fillOval((int) (width * .36), (int) (height * .25), (int) (10), (int) (10));

			g.fillOval((int) (width * .42), (int) (height * .25), (int) (10), (int) (10));

			g.setColor(Color.RED);
			g.drawArc((int) (width * .37), (int) (height * .32), (int) (width * .06), (int) (height * .05), 0, 180);
			break;

		case 3:
			g.drawOval((int) (width * .33), (int) (height * .2), (int) (105), (int) (105));
			g.setColor(Color.GREEN);

			g.fillOval((int) (width * .36), (int) (height * .25), (int) (10), (int) (10));

			g.fillOval((int) (width * .42), (int) (height * .25), (int) (10), (int) (10));

			g.setColor(Color.RED);
			g.drawArc((int) (width * .37), (int) (height * .32), (int) (width * .06), (int) (height * .05), 0, 180);

			g.setColor(Color.BLACK);
			g.drawLine((int) (width * .4), (int) (height * .38), (int) (width * .4), (int) (height * .65));
			break;
		case 4:
			g.drawOval((int) (width * .33), (int) (height * .2), (int) (105), (int) (105));
			g.setColor(Color.GREEN);

			g.fillOval((int) (width * .36), (int) (height * .25), (int) (10), (int) (10));

			g.fillOval((int) (width * .42), (int) (height * .25), (int) (10), (int) (10));

			g.setColor(Color.RED);
			g.drawArc((int) (width * .37), (int) (height * .32), (int) (width * .06), (int) (height * .05), 0, 180);
			g.setColor(Color.BLACK);
			g.drawLine((int) (width * .4), (int) (height * .38), (int) (width * .4), (int) (height * .65));
			g.drawLine((int) (width * .3), (int) (height * .5), (int) (width * .4), (int) (height * .43));
			g.drawLine((int) (width * .4), (int) (height * .43), (int) (width * .5), (int) (height * .5));

			break;
		case 5:
			g.drawOval((int) (width * .33), (int) (height * .2), (int) (105), (int) (105));
			g.setColor(Color.GREEN);

			g.fillOval((int) (width * .36), (int) (height * .25), (int) (10), (int) (10));

			g.fillOval((int) (width * .42), (int) (height * .25), (int) (10), (int) (10));

			g.setColor(Color.RED);
			g.drawArc((int) (width * .37), (int) (height * .32), (int) (width * .06), (int) (height * .05), 0, 180);
			g.setColor(Color.BLACK);
			g.drawLine((int) (width * .4), (int) (height * .38), (int) (width * .4), (int) (height * .65));
			g.drawLine((int) (width * .3), (int) (height * .5), (int) (width * .4), (int) (height * .43));
			g.drawLine((int) (width * .4), (int) (height * .43), (int) (width * .5), (int) (height * .5));

			g.drawLine((int) (width * .4), (int) (height * .65), (int) (width * .3), (int) (height * .7));
			g.drawLine((int) (width * .4), (int) (height * .65), (int) (width * .5), (int) (height * .7));

			break;
		case 6:
			g.drawString("GAME OVER", (int) (width * .33), (int) (height * .4));
			// out = true;
			break;

		}
	}

	public boolean isOut() {
		return out;
	}

	public void setOut(boolean out) {
		this.out = out;
	}
}
