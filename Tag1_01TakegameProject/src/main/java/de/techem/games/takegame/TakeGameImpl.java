package de.techem.games.takegame;

import java.util.Scanner;

import de.techem.games.Game;

public class TakeGameImpl implements Game {
	private static final String ERROR_MESSAGE = "Ungültiger Zug";
	private static final String USER_PROMPT = "Es gibt %s Steine. Bitte nehmen Sie 1, 2 oder 3.";
	private Scanner scanner = new Scanner(System.in);
	private int stones;
	private boolean gameover;
	
	public TakeGameImpl() {
		stones = 23;
		gameover = false;
	}

	private boolean isGameOver() {
		return stones <= 0;
	}
	@Override
	public void play() {
		while (! isGameOver()) {
			executeTurns();
		}

	}

	private void executeTurns() { // Integration
		humanTurn();
		computerTurn();
	}

	private void humanTurn() { // Operation
		if(isGameOver())
			return;
		int turn;
		while(true) {
			print(String.format(USER_PROMPT, stones));
			turn = readInt();
			if(turn >= 1 && turn <= 3) break;
			print(ERROR_MESSAGE);
		}
		stones -= turn;
		if(isGameOver()) {
			System.out.println("Du Loser");
		}
	}

	private void computerTurn() {
		if(isGameOver())
			return;
		int turn;
		final int zuege[] = {3,1,1,2};
		

		
		turn = zuege[stones % 4];
		
		print(String.format("Computer nimmt %s Steine.", turn));
		
		stones -= turn;
		if(isGameOver()) {
			System.out.println("Du hast nur Glück gehabt");
		}
	}
	
	private void print(String message) {
		System.out.println(message);
	}
	
	private int readInt() {
		return scanner.nextInt();
	}

}
