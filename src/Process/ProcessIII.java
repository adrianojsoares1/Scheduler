package Process;

import Resource.*;
import Utilities.RNG;
import java.util.LinkedList;

public class ProcessIII extends Process {

    public ProcessIII(Resource A, Resource B, Resource C){
        int runTime = (int) Math.ceil(150 + 350 * Math.sqrt(Math.pow(RNG.RNG_Float(), 5)));
        setFinishTime(runTime);

        generateNextBlock(A, B, C);
    }

    @Override
    public void generateNextBlock(Resource A, Resource B, Resource C){
        int start = 0, end = getFinishTime() - 1;
        int type, blockStart, blockLength;
        while(start <= end){
            //Determine when the block occurs
            type = RNG.RNG_Max(100) + 1;
            start += (int)Math.ceil(25 + 50 * Math.cbrt(Math.pow(RNG.RNG_Float(), 7)));

            //Determine the type of the Block(15% : 50% : 35%)
            Resource generatedBlock = type > 85 ? C : type > 35 ? B : A;

            blockLength = generatedBlock.generateBlockTime();

            blocks.add(new Block(start, blockLength, generatedBlock));
        }
        //Set instance variables for the next block - the first in the list
        Block firstBlock = this.blocks.peekFirst();

        setNextBlock(firstBlock.getBlockResource()).
        setNextBlockStartTime(firstBlock.getBlockStartTime()).
        setNextBlockTime(firstBlock.getBlockLength());
    }
}