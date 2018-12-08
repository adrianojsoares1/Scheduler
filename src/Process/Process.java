package src.Process;

public abstract class Process {

    private String ID;				// unique—suggest appending integer to ‘P’
    private int CPUTime, blockedTime;
    private int readyTime, lastEventTime;	// all initialized to 0
    private int finishTime;			// initialized to MAXINT
    private Resource nextBlock;		// NULL if no block
    private int nextBlockTime;		// set to MAXINT if no future block
    private int blockServiceTime;		// set when process arrives at resource, else 0
    private int serviceStartTime;		// used to update blockedTime and for SharedResource
    private float fPriority;
    private int iPriority;

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

    public String getID() {
        return ID;
    }

    public Process setID(String ID) {
        this.ID = ID;
        return this;
    }

    public int getCPUTime() {
        return CPUTime;
    }

    public Process setCPUTime(int CPUTime) {
        this.CPUTime = CPUTime;
        return this;
    }

    public int getBlockedTime() {
        return blockedTime;
    }

    public Process setBlockedTime(int blockedTime) {
        this.blockedTime = blockedTime;
        return this;
    }

    public int getReadyTime() {
        return readyTime;
    }

    public Process setReadyTime(int readyTime) {
        this.readyTime = readyTime;
        return this;
    }

    public int getLastEventTime() {
        return lastEventTime;
    }

    public Process setLastEventTime(int lastEventTime) {
        this.lastEventTime = lastEventTime;
        return this;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public Process setFinishTime(int finishTime) {
        this.finishTime = finishTime;
        return this;
}

    public Resource getNextBlock() {
        return nextBlock;
    }

    public Process setNextBlock(Resource nextBlock) {
        this.nextBlock = nextBlock;
        return this;
    }

    public int getNextBlockTime() {
        return nextBlockTime;
    }

    public Process setNextBlockTime(int nextBlockTime) {
        this.nextBlockTime = nextBlockTime;
        return this;
    }

    public int getBlockServiceTime() {
        return blockServiceTime;
    }

    public Process setBlockServiceTime(int blockServiceTime) {
        this.blockServiceTime = blockServiceTime;
        return this;
    }

    public int getServiceStartTime() {
        return serviceStartTime;
    }

    public Process setServiceStartTime(int serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
        return this;
    }

    public float getfPriority() {
        return fPriority;
    }

    public Process setfPriority(float fPriority) {
        this.fPriority = fPriority;
        return this;
    }

    public int getiPriority() {
        return iPriority;
    }

    public Process setiPriority(int iPriority) {
        this.iPriority = iPriority;
        return this;
    }

    public abstract void generateNextBlock ( );

}