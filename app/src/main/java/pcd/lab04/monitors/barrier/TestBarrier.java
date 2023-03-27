package pcd.lab04.monitors.barrier;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * La barrier blocca i worker che arrivano e fin quando non ci sono tutti non lascia passare, vedo tutti i before e poi appena arrivano tutti li sincronizzati
 * scrivono after
 * 
 */
public class TestBarrier {

	public static void main(String[] args) {
		
		int nWorkers = 10;

		/* this barrier is not working */
		// Barrier barrier = new FakeBarrier();
		Barrier barrier = new TrueBarrier(nWorkers);
		
		List<Worker> workers = new ArrayList<Worker>();
		for (int i = 0; i < nWorkers; i++) {
			workers.add(new Worker("Worker-"+i, barrier));
		}

		for (Worker w: workers) {
			w.start();
		}
		
	}
}
