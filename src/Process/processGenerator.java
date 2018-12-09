package Process;
import java.lang.Math;
import Utilities.RNG;
import Resource.Resource;

public final class ProcessGenerator {
    static int ProcessRunTime;
    static int BlockRunTime;
    static Resource BlockType;

    public static int nextBlockInterval() {
        return (int) Math.ceil(25 + 50 * Math.pow(RNG.RNG_Float(), 7 / 3));
    }
    //These are the blocks
    public static int A () {
        return RNG.RNG_Min(60, 100);
    }
    public static int B(){
        return RNG.RNG_Min(75,125);
    }
    public static int C(){
        return (int) Math.ceil(100 + 300 * Math.pow(RNG.RNG_Float(),2));
    }


    //Rewrite this so processruntime makes sense.
    //
    public static void ProcessI(){
        int number = RNG.RNG_Max(100);
        ProcessRunTime = TypeI();
        if (number < 60) {
            BlockRunTime = 0;
            BlockType = null;
        }
        else{
            number = RNG.RNG_Max(2);
            if (number == 1) {
                BlockRunTime = A();
                BlockType = "A";
            }
            else{
                BlockRunTime = B();
                BlockType = "B";
            }
        }
    }
    public static void ProcessII(){
        ProcessRunTime = TypeII();
        BlockRunTime = 0;
        BlockType = null;
    }
    public static void ProcessIII(){
        int number = RNG.RNG_Max(100);
        ProcessRunTime = TypeIII();
        if (number < 34) {
            BlockRunTime = A();
            BlockType = "A";
        }
        else if (number < 84) {
            BlockRunTime = B();
            BlockType = "B";
        }
        else{
            BlockRunTime = C();
            BlockType = "C";
        }
    }
    public static void ProcessIV(){
        ProcessRunTime = TypeIV();
        if (RNG.RNG_Max(2) < 1) {
            BlockRunTime = B();
            BlockType = "B";
        }
        else{
            BlockRunTime = C();
            BlockType = "C";
        }
    }
}
