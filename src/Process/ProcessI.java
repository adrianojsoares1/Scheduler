package Process;
import Utilities.RNG;

class ProcessI extends Process {

    public void ProcessRunTime() {
        setFinishTime(RNG.RNG_Min(25, 75));
    }

    public void generateNextBlock() {

    }
}
