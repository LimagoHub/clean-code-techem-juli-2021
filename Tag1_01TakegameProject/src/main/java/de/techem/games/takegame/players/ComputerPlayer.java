package de.techem.games.takegame.players;

public class ComputerPlayer extends AbstractTakeGamePlayer{

	private static final int zuege[] = {3,1,1,2};
	@Override
	public int doTurn(int stones) {
		
		int turn = zuege[stones % 4];
		System.out.println(String.format("Computer nimmt %s Steine.", turn));
		return turn;
	}

}
