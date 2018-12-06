import java.util.Random;
public class RNG1{
    static Random RNG = new Random();

    public static int RNG (int max) {
        int number;
        number = RNG.nextInt(max);
        return number;
    }
    public static int RNG (int min, int max) {
        int number;
        number = RNG.nextInt(max - min) + min;
        return number;
    }
    public static float RNG_Float() {
        float number;
        number = RNG.nextFloat();
        return number;
    }
}

