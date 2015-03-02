package hangman;

import java.awt.Graphics;

public class Noose {

	private int width;
	private int height;
	
	public Noose(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public void draw(Graphics g){
		g.drawLine((int)(width*.5), (int)(height*.2), (int)(width*.5), (int)(height*.4));
		g.drawLine((int)(width*.5), (int)(height*.2), (int)(width*.8), (int)(height*.2));
		g.drawLine((int)(width*.8), (int)(height*.2), (int)(width*.8), (int)(height*.8));
		g.drawLine((int)(width*.3), (int)(height*.8), (int)(width*.9), (int)(height*.8));

	}
}
