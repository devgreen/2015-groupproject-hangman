package hangman;

import java.awt.Graphics;
import javax.swing.JComponent;

public class HangmanComponent extends JComponent {

	private Noose noose;

	private Person person;

	public Person getPerson() {
		return person;
	}

	public HangmanComponent(int width, int height) {
		// public HangmanComponent() {

		this.noose = new Noose(width, height);
		this.person = new Person(width, height);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		noose.draw(g);
		person.draw(g);
	}
}
