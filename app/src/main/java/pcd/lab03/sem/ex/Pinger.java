package pcd.lab03.sem.ex;

import java.util.concurrent.Semaphore;

public class Pinger extends Thread {

	private Semaphore pongDone;
	private Semaphore pingDone;

	public Pinger(Semaphore pingDone, Semaphore pongDonSemaphore) {
		this.pingDone = pingDone;
		this.pongDone = pongDonSemaphore;
	}	

	public void run() {
		while (true) {
			try {
				pongDone.acquire();
				System.out.println("ping!");
				this.sleep(1000);
				pingDone.release();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}