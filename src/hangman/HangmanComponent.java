package hangman;

import java.awt.Graphics;

import javax.swing.JComponent;

public class HangmanComponent extends JComponent {

	Noose noose;

	// Person person;

	 public HangmanComponent(int width, int height){
	//public HangmanComponent() {

		this.noose = new Noose(width, height);
		// this.person = person;
	}

	protected void paintComponenet(Graphics g) {
		super.paintComponent(g);
		noose.draw(g);
		// person.draw(g);
	}
}
