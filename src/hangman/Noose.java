package hangman;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class Noose  {

	private int width;
	private int height;
	
	public Noose(int width, int height){
	//public Noose(){
		//this.width = 800;
		//this.height = 600;
		this.width = width;
		this.height = height;
	}
	
	public void draw(Graphics g){
	
		g.drawLine((int)(width*.4), (int)(height*.1), (int)(width*.4), (int)(height*.2));
		g.drawLine((int)(width*.4), (int)(height*.1), (int)(width*.67), (int)(height*.1));
		g.drawLine((int)(width*.67), (int)(height*.1), (int)(width*.67), (int)(height*.8));
		g.drawLine((int)(width*.45), (int)(height*.8), (int)(width*.75), (int)(height*.8));
		
	}
}
