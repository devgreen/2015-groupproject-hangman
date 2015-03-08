package hangman;

import java.awt.Graphics;

public class Hangman {

	private Noose noose;
	private Person person;

	public Person getPerson() {
		return person;
	}

	public Hangman(int width, int height) {
		this.noose = new Noose(width, height);
		this.person = new Person(width, height);
	}

	public void draw(Graphics g) {
		noose.draw(g);
		person.draw(g);

	}
}
