package Process;
import Resource.*;
import Utilities.RNG;
import java.util.LinkedList;

class ProcessIV extends Process {

    private LinkedList<Block> blocks = new LinkedList<>();

    public void ProcessRunTime() {
        setFinishTime(RNG.RNG_Min(400, 1000));
    }
    public void generateNextBlock() {
        int start = 0, end = getFinishTime() - 1;
        int type, blockStart, blockLength;

        while(start < end){
            //Determine when the block occurs
            type = RNG.RNG_Max(100) + 1;
            start += RNG.RNG_Min(40,120);

            //Determine the type of the Block(50% : 50%)
            Resource generatedBlock = type > 50 ? new ResourceC() : new ResourceB();

            blockLength = generatedBlock.generateBlockTime();

            blocks.add(new Block(start, blockLength, generatedBlock));
        }
        //Set instance variables for the next block - the first in the list
        Block firstBlock = this.blocks.peekFirst();

        setNextBlock(firstBlock.getBlockResource());
        setNextBlockStartTime(firstBlock.getBlockStartTime());
        setNextBlockTime(firstBlock.getBlockLength());
    }
}