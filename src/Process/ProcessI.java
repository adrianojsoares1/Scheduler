package Process;
import Utilities.RNG;
import Resource.*;

class ProcessI extends Process {

    public void ProcessRunTime() {
        setFinishTime(RNG.RNG_Min(25, 75));
        setBlockType(RNG.RNG_Max(100) < 60 ? 'A' : 'B');
        if(getBlockType() != 0)
            generateNextBlock();
    }

    public void generateNextBlock() {
        int blockStart = RNG.RNG_Min(2, getFinishTime() - 1);
        int blockLength = RNG.RNG_Min(60, 100);

        Resource newResource = getBlockType() == 'A' ? new ResourceA() : new ResourceB();
        setNextBlockStartTime(blockStart);
        setNextBlockTime(blockStart);
    }
}
