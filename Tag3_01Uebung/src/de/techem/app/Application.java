package de.techem.app;

public class Application {

	
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE >> 1;
	private int feld [] = new int[MAX_ARRAY_SIZE];
	
	public static void main(String[] args) {
		new Application().run();

	}

	private void run() {
		ArrayServiceImpl service = new ArrayServiceImpl();
		service.fillArrayWithRandomNumbersParallel(feld);
	}

}
