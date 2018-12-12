package Resource;

import Utilities.RNG;

public class ResourceC extends ResourceAC {

    public int generateBlockTime(){
        int num = RNG.RNG_Max(80);
        return (int)Math.ceil((70.0 / 3) + Math.pow(num, 2) / 80.0);
    }
}
