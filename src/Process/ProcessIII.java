package Process;
import Utilities.RNG;

class ProcessIII extends Process {

    public void ProcessRunTime() {
        int runTime = (int) Math.ceil(150 + 350 * Math.sqrt(Math.pow(RNG.RNG_Float(), 5)));
        setFinishTime(runTime);


    }

    public void generateNextBlock() {
        int runTime = getFinishTime();

        while(runTime > 0){

            
        }

    }
}