package de.app;

import de.techem.clients.GameClient;
import de.techem.games.takegame.TakeGameImpl;

public class Main {

	public static void main(String[] args) {
		TakeGameImpl impl = new TakeGameImpl();
		GameClient client = new GameClient(impl);
		client.run();
	}

}
