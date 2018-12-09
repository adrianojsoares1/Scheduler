package Process;
import Resource.Resource;

public class Block {
    private int blockStartTime;
    private Resource blockResource;
    private int blockLength;

    public Block(int startTime, int length, Resource block) {
        this.blockStartTime = startTime;
        this.blockLength = length;
        this.blockResource = block;
    }

    public int getBlockStartTime() {
        return blockStartTime;
    }

    public Block setBlockStartTime(int blockStartTime) {
        this.blockStartTime = blockStartTime;
        return this;
    }

    public Resource getBlockResource() {
        return blockResource;
    }

    public Block setBlockResource(Resource blockResource) {
        this.blockResource = blockResource;
        return this;
    }

    public int getBlockLength() {
        return blockLength;
    }

    public Block setBlockLength(int blockLength) {
        this.blockLength = blockLength;
        return this;
    }
}

