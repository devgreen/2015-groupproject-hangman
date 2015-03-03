package hangman;

import java.awt.Graphics;

import javax.swing.JComponent;

public class HangmanComponent extends JComponent {

	Noose noose;

	 Person person;

	 public HangmanComponent(int width, int height){
	//public HangmanComponent() {

		this.noose = new Noose(width, height);
		 this.person = new Person(width, height);
		//this.noose = new Noose();

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		noose.draw(g);
		person.draw(g);
		//g.drawLine(200, 300, 400, 500);
		// person.draw(g);
	}
}
