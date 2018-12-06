import java.lang.Math;

public class processGenerator {
    int ProcessRunTime;
    static int ProcessRunTimeI;
    int BlockRunTime;
    static int BlockRunTimeI;
    String BlockType;
    static int BlockTypeI;

    public static int TypeI(){
        int number;
        int min = 25;
        int max = 75;
        number = RNG1.RNG(min,max);
        return number;
    }
    public static int TypeII() {
        int number;
        int min = 200;
        int max = 600;
        int num = RNG1.RNG_float();
        number = Math.ceil(200 + 400 * num.pow(5 / 3));
        return number;
    }
    public static int TypeIII() {
        int number;
        int min = 150;
        int max = 500;
        int num = RNG1.RNG_float();
        number = Math.ceil(150 + 350 * num.pow(5 / 2));
        return number;
    }
    public static int nextblockInterval() {
        int number;
        int min = 25;
        int max = 75;
        int num = RNG1.RNG_float();
        number = Math.ceil(25 + 50 * num.pow(7 / 3));
        return number;
    }
    public static int TypeIV(){
        int number;
        int min = 400;
        int max = 1000;
        number = RNG1.RNG(min,max);
        return number;
    }
    public static int A() {
        int number;
        int min = 60;
        int max = 100;
        number = RNG1.RNG(min, max);
        return number;
    }
    public static int B(){
        int number;
        int min = 75;
        int max = 125;
        number = RNG1.RNG(min,max);
        return number;
    }
    public static int C(){
        int number;
        int min = 100;
        int max = 400;
        int num = RNG1.RNG_Float();
        number = Math.ceil(100 + 300 * num.pow(2));
        return number;
    }

    public static int ProcessI() {
        int number;
        int max = 100;
        number = RNG1.RNG(max);
        ProcessRunTimeI = TypeI();
        processGenerator ProcessRunTime1 = new processGenerator();
        ProcessRunTime1.ProcessRunTime = TypeI();
        if (number < 59) {
            processGenerator BlockRunTime1 = new processGenerator();
            BlockRunTime1.BlockRunTime = 0;
            processGenerator BlockType1 = new processGenerator();
            BlockType1.BlockType = null;
        } else {
            int max = 2;
            number = RNG1.RNG(max);
        }
        if (number < 1) {
            processGenerator BlockRunTime2 = new processGenerator();
            BlockRunTime2.BlockRunTime = A();
            processGenerator BlockType2 = new processGenerator();
            BlockType2.BlockType = "A";
        } else {
            processGenerator BlockRunTime3 = new processGenerator();
            BlockRunTime3.BlockRunTime = B();
            processGenerator BlockType3 = new processGenerator();
            BlockType3.BlockType = "B";
        }
    }
    public static int ProcessII(){
        processGenerator ProcessRunTime2 = new processGenerator();
        ProcessRunTime2.ProcessRunTime = TypeII();
        processGenerator BlockRunTime4 = new processGenerator();
        BlockRunTime4.BlockRunTime = 0;
        processGenerator BlockType4 = new processGenerator();
        BlockType4.BlockType = null;
    }
    public static int ProcessIII(){
        int number;
        int max = 100;
        number = RNG1.RNG(max);
        processGenerator ProcessRunTime3 = new processGenerator();
        ProcessRunTime3.ProcessRunTime = TypeIII();
        if (number < 34) {
            processGenerator BlockRunTime5 = new processGenerator();
            BlockRunTime5.BlockRunTime = A();
            processGenerator BlockType5 = new processGenerator();
            BlockType5.BlockType = "A";
        }
        else if (number < 84) {
            processGenerator BlockRunTime6 = new processGenerator();
            BlockRunTime6.BlockRunTime = B();
            processGenerator BlockType6 = new processGenerator();
            BlockType6.BlockType = "B";
        }
        else{
            processGenerator BlockRunTime7 = new processGenerator();
            BlockRunTime7.BlockRunTime = C();
            processGenerator BlockType7 = new processGenerator();
            BlockType7.BlockType = "C";
        }
    }
    public static int ProcessIV(){
        int number;
        processGenerator ProcessRunTime4 = new processGenerator();
        ProcessRunTime4.ProcessRunTime = TypeIV();
        int max = 2;
        number = RNG1.RNG(max);
        if (number < 1) {
            processGenerator BlockRunTime8 = new processGenerator();
            BlockRunTime8.BlockRunTime = B();
            processGenerator BlockType8 = new processGenerator();
            BlockType8.BlockType = "B";
        }
        else{
            processGenerator BlockRunTime9 = new processGenerator();
            BlockRunTime9.BlockRunTime = C();
            processGenerator BlockType9 = new processGenerator();
            BlockType9.BlockType = "C";
        }
    }
}
