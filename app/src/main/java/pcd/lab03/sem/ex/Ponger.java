package pcd.lab03.sem.ex;

import java.util.concurrent.Semaphore;

public class Ponger extends Thread {
	
	private Semaphore pingDone;
	private Semaphore pongDone;

	public Ponger(Semaphore pingDone, Semaphore pongDonSemaphore) {
		this.pongDone = pongDonSemaphore;
		this.pingDone = pingDone;
	}

	public void run() {
		while (true) {
				try {
					pingDone.acquire();
					this.sleep(1000);
					System.out.println("pong!");
					pongDone.release();
				} catch (Exception ex) {
					ex.printStackTrace();
				} 					
			}
	}
}