package Process;
import Utilities.RNG;
import Resource.Resource;

public class ProcessII extends Process {

    public ProcessII() {
        int runTime = (int) Math.ceil(200 + 400 * Math.cbrt(Math.pow(RNG.RNG_Float(), 5)));
        setFinishTime(runTime);

        setNextBlock(null);
        setNextBlockStartTime(-1);
        setNextBlockTime(0);
    }

    @Override
    public void generateNextBlock(Resource A, Resource B, Resource C) {
        //No blocks!
    }
}