package Process;
import Utilities.RNG;
import Resource.*;

class ProcessI extends Process {

    public ProcessI(Resource A, Resource B){
        setFinishTime(RNG.RNG_Min(25, 75));

        //Only a 40% chance to block
        if(RNG.RNG_Max(10) < 4)
            generateNextBlock(A, B, null);
    }

    @Override
    public void generateNextBlock(Resource A, Resource B, Resource C) {
        //Determine the block start time
        int blockStart = RNG.RNG_Min(2, getFinishTime() - 1);

        //Determine Resource Type (A or B) and create the Resource (50% : 50%)
        int type = RNG.RNG_Max(100) + 1;
        Resource generatedBlock = type > 50 ? A : B;

        //Determine the block length
        int blockLength = generatedBlock.generateBlockTime();

        //Update the instance variables
        setNextBlock(generatedBlock);
        setNextBlockStartTime(blockStart);
        setNextBlockTime(blockStart);
    }
}
