package Resource;

import Utilities.RNG;

public class ResourceA extends ResourceAC {

    public int generateBlockTime(){
        return RNG.RNG_Min(60,100);
    }
}
