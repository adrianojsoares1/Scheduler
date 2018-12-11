package Resource;

import Utilities.RNG;

public class ResourceA extends Resource {

    @Override
    public int generateBlockTime(){
        return RNG.RNG_Min(60,100);
    }
}
