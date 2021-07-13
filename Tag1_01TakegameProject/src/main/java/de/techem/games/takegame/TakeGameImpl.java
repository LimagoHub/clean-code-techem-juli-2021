package de.techem.games.takegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import de.techem.games.Game;
import de.techem.games.takegame.players.TakeGamePlayer;

public class TakeGameImpl implements Game {
	private static final String ERROR_MESSAGE = "Ung�ltiger Zug";

	private TakeGamePlayer currentPlayer = null;
	private int stones;
	private int turn;
	private List<TakeGamePlayer> players = new ArrayList<>();
	
	public TakeGameImpl() {
		stones = 23;
		
	}
	
	public void addPlayer(TakeGamePlayer player) {
		players.add(player);
	}

	public void removelayer(TakeGamePlayer player) {
		players.remove(player);
	}

	
	@Override
	public void play() {
		while (! isGameOver()) 		executeTurns();


	}

	private void executeTurns() { // operation 
		for(TakeGamePlayer player : players) prepareTurn(player);
	}

	private void prepareTurn(TakeGamePlayer player) { // Sorgenkind (falsche Abstraktion)
		currentPlayer = player;
		executeSingleTurn();
	}

	private void executeSingleTurn() { // Operation??
		if(isGameOver()) return;
		
		while(true) {
			
			turn =currentPlayer.doTurn(stones);
			
			if(turn >= 1 && turn <= 3) break;
			print(ERROR_MESSAGE);
		}
		
		terminateTurn();
	}


	
	
	private void terminateTurn() {// Integration
		updateScene();
		checkLosing();
	}

	private void checkLosing() {// Operation
		if(isGameOver()) print(String.format("%s hat verloren", currentPlayer.getName()));
		
	}

	private void updateScene() {
		stones -= turn;
	}
	
	private boolean isGameOver() {
		return stones <= 0 || players.isEmpty();
	}
	
	private void print(String message) {
		System.out.println(message);
	}

}
