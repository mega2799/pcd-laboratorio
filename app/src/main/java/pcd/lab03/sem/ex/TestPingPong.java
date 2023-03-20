package pcd.lab03.sem.ex;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Unsynchronized version
 * 
 
 * @author aricci
 *
 */
public class TestPingPong {
	public static void main(String[] args) {
		Semaphore ping = new Semaphore(0, true);
		Semaphore pong = new Semaphore(0, true);
		new Pinger(ping, pong).start();
		new Ponger(ping, pong).start();	

		ping.release();
	}

}
