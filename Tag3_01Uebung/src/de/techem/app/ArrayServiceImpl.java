package de.techem.app;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArrayServiceImpl {
	
	private int feld[];
	private final int availableProcessors = Runtime.getRuntime().availableProcessors();
	private int runningThreads;
	

	public void fillArrayWithRandomNumbersParallel(int feld[]) {
		this.feld = feld;
		try {
			fillArrayWithRandomNumbersParallelImpl();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}

	private void fillArrayWithRandomNumbersParallelImpl() throws InterruptedException {
		
		for (runningThreads = 1; runningThreads <= availableProcessors + 1; runningThreads++) {

			zeitMessungDecorator();
		}
	}

	private void zeitMessungDecorator() throws InterruptedException {
		Instant start = Instant.now();
		
		startExecutorService();
		
		Instant ende = Instant.now();
		Duration duration = Duration.between(start, ende);

		System.out.println(String.format("Duration with %s threads is %s.", runningThreads ,duration.toMillis()));
	}

	private void startExecutorService() throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(availableProcessors);
		
		startSegmentFillWorker(service);

		service.shutdown();
		service.awaitTermination(Long.MAX_VALUE,TimeUnit.DAYS);
	}

	private void startSegmentFillWorker(ExecutorService service) {
		for(int activeThread = 0; activeThread < runningThreads; activeThread ++ ) {
			startSingleWorker(service, activeThread);
		}
	}

	private void startSingleWorker(ExecutorService service, int activeThread) {
		final int segmentSize = feld.length / runningThreads;
		final int segmentStart = activeThread * segmentSize;
		final int segmentEnde =(activeThread +1) * segmentSize;
		service.execute(new FillSegmentWorker(segmentStart, segmentEnde));
	}
	
	class FillSegmentWorker implements Runnable {
		
		private final Random random = new Random();
		private final int start;
		private final int ende;
		
		public FillSegmentWorker(int start, int ende) {
			
			this.start = start;
			this.ende = ende;
		}
		@Override
		public void run() {
			for (int i = start; i < ende; i++) {
				feld[i] = random.nextInt();
			}

			
		}
		
		
		
	}

}
