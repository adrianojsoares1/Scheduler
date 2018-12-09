package Process;
import Utilities.RNG;

class ProcessIV extends Process {

    public void ProcessRunTime() {
        setFinishTime(RNG.RNG_Min(400, 1000));
    }
    public void generateNextBlock() {

    }
}