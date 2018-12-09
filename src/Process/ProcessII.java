package Process;
import Utilities.RNG;

class ProcessII extends Process {

    public void ProcessRunTime() {
        int runTime = (int) Math.ceil(200 + 400 * Math.cbrt(Math.pow(RNG.RNG_Float(), 5)));
        setFinishTime(runTime);
    }

    public void generateNextBlock() {

    }
}