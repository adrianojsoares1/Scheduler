package src.Process;
import java.util.Random;
public class RNG {
    static Random RNG = new Random();

    public static int RNG_Max (int max) {
        return RNG.nextInt(max);
    }

    public static int RNG_Min (int min, int max) {
        return RNG.nextInt(max - min) + min;
    }

    public static float RNG_Float() {
        return RNG.nextFloat();
    }
}

