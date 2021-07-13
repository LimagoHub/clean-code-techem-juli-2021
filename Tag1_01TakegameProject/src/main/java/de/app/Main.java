package de.app;

import de.techem.clients.GameClient;
import de.techem.games.takegame.TakeGameImpl;
import de.techem.games.takegame.players.ComputerPlayer;
import de.techem.games.takegame.players.HumanPlayer;

public class Main {

	public static void main(String[] args) {
		TakeGameImpl impl = new TakeGameImpl();
		impl.addPlayer(new HumanPlayer());
		impl.addPlayer(new ComputerPlayer());
		GameClient client = new GameClient(impl);
		client.run();
	}

}
