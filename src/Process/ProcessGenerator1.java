import java.util.Random;
import java.lang.Math;

public class processGenerator {

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
        float num = RNG1.RNG_Float();
        number = (int)Math.ceil(200 + 400 * Math.cbrt(Math.pow(num, 5)));
        return number;
    }
    public static int TypeIII() {
        int number;
        int min = 150;
        int max = 500;
        float num = RNG1.RNG_Float();
        number = (int)Math.ceil(150 + 350 * Math.sqrt(Math.pow(num, 5)));
        return number;
    }
    public static int nextblockInterval() {
        int number;
        int min = 25;
        int max = 75;
        float num = RNG1.RNG_Float();
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

    public static int ProcessI(){
        int number;
        int max = 100;
        number = RNG1.RNG(max);
        ProcessRunTime = TypeI();
        if (number < 59) {
            BlockRunTime = 0;
            BlockType = null;
        }
        else{
            number = RNG1.RNG(1);
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
    public static int ProcessII(){
        ProcessRunTime = TypeII();
        BlockRunTime = 0;
        BlockType = null;
    }
    public static int ProcessIII(){
        int number;
        int max = 100;
        number = RNG1.RNG(max);
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
    public static int ProcessIV(){
        int number;
        ProcessRunTime = TypeIV();
        int max = 2;
        number = RNG1.RNG(max);
        if (number < 1) {
            BlockRunTime = B();
            BlockType = "B";
        }
        else{
            BlockRunTime = C();
            BlockType = "C";
        }
    }
}

}
