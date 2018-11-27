package src.Process;

public abstract class Process {

    public String ID;				// unique—suggest appending integer to ‘P’
    public int CPUTime, blockedTime;
    public int readyTime, lastEventTime;	// all initialized to 0
    public int finishTime;			// initialized to MAXINT
    public Resource nextBlock;		// NULL if no block
    public int nextBlockTime;		// set to MAXINT if no future block
    public int blockServiceTime;		// set when process arrives at resource, else 0
    public int serviceStartTime;		// used to update blockedTime and for SharedResource
    public float fPriority;
    public int iPriority;

    public String toString ( ) {
        return ID;
    }
    public void updateBlocked (int time) {
        blockedTime += time - lastEventTime;
    }
    public void updateReady (int time) {
        readyTime += time;
    }
    public void updateCPU (int time) {
        blockedTime += lastEventTime;
    }
    public abstract void generateNextBlock ( );
}