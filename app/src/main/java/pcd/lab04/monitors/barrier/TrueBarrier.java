package pcd.lab04.monitors.barrier;

public class TrueBarrier implements Barrier {

    private final int nWorkers; 
    private int counter;


    public TrueBarrier(int nWorkers) {
        this.nWorkers = nWorkers;
    }
    
    @Override
    public synchronized void hitAndWaitAll() throws InterruptedException {
        // if(++counter != nWorkers) wait(); else  notifyAll();
        counter++;
        while(counter < nWorkers){
            wait();
        }
        notifyAll();
        // if(counter != nWorkers) wait(); else  notifyAll();
    }
}
