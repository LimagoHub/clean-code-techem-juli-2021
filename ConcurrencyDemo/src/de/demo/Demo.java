package de.demo;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo {

	public static void main(String[] args) throws Exception{
		
		Instant start = Instant.now();
		
		//ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			service.execute(new Worker());
			
		}
		
		service.shutdown();
		System.out.println("noch nicht Fertig");
		service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		
		Instant ende = Instant.now();
		
		Duration duration = Duration.between(start, ende);
		System.out.println("Duration = " + duration.toMillis());
		
		System.out.println("Fertig");
	}
	
	static class Worker implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep((long) (Math.random() * 200));
				System.out.println("Thread Nr. " +Thread.currentThread().getId() + " terminated");
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}

}
