package de.clientside;

import de.tiere.PigTooFatListener;
import de.tiere.Schwein;



public class Main {

	private Metzger metzger = new Metzger();
	private Spediteur spediteur = new Spediteur();

	public static void main(String[] args) {
		new Main().run();

	}

	private void run() {
		Schwein piggy = new Schwein("Miss Piggy");

		piggy.addPigTooFatListener(new SchweineMetgerAdapter());
		piggy.addPigTooFatListener(spediteur);

		for (int i = 0; i < 11; i++) {
			piggy.fuettern();

		}

	}

	class SchweineMetgerAdapter implements PigTooFatListener {

		@Override
		public void pigTooFat(Schwein dickesSchwein) {
			metzger.schlachten();
		}
	}

}


class Metzger  {



	public void schlachten() {
		System.out.println("Messer wetz");
	}
}

class Spediteur implements PigTooFatListener {


	@Override
	public void pigTooFat(Schwein dickesSchwein) {
		System.out.println("Wir fahren auf der Autobahn");

	}
}
