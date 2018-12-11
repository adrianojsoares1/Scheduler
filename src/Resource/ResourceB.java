package Resource;

import Utilities.RNG;

public class ResourceB extends Resource{

    @Override
    public int generateBlockTime(){
        return RNG.RNG_Min(75, 125);
    }
}
