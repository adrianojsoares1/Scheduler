package Process;
import Utilities.RNG;

public class ProcessII extends Process {

    public void ProcessRunTime() {
        int runTime = (int) Math.ceil(200 + 400 * Math.cbrt(Math.pow(RNG.RNG_Float(), 5)));
        setFinishTime(runTime);

        setNextBlock(null);
        setNextBlockStartTime(-1);
        setNextBlockTime(0);
    }

    public void generateNextBlock() {
        //No blocks!
    }
}