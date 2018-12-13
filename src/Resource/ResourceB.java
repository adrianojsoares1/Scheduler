package Resource;

import Scheduler.Scheduler;
import Utilities.RNG;
import Process.Process;
import java.util.ArrayList;
import java.util.HashMap;

public class ResourceB extends Resource{

    private HashMap<Integer, ArrayList<Process>> blockedProcessesMap;
    @Override
    public int generateBlockTime(){
        return RNG.RNG_Min(75, 125);
    }

    public void updateNextUnblock(int time){
    }
/*
    public void updateNextUnblock(int time) {
        nextUnblockTime = time;
    }

    public void arrivingProcess(Process theProcess){
        servingProcess = theProcess;
    }
    public void finishService(){
        int finishedBlockTime = ;//something.poll;

        ArrayList<Process> blockedProcesses;
        blockedProcesses = blockedProcessesMap.get(finishedBlockTime);
        blockedProcessesMap.remove(blockedProcesses);

        for (Process aProcess: blockedProcesses){
            Scheduler.readyQueue.addToReadyQueue(aProcess);

        }

        public void arrivingProcess(Process theProcess, int time){
            theProcess.setServiceTime(time);

            int unblockTime = time + theProcess.getNextBlockTime();

            if ( blockedProcessesQueue.isEmpty()){

                updateIdleTime(time - startIdleTime);
            }
        }
*/
}
