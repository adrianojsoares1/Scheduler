package Resource;

import Scheduler.Scheduler;
import Process.Process;
import java.util.ArrayList;

public abstract class ResourceAC extends Resource {
    public void finishService () {
        Process theProcess = getMinTimeProcess(blockedProcesses);
        blockedProcesses.remove(0);
        updateServiceTimes (blockedProcesses, theProcess.getBlockedTime());
        nextUnblockTime = (nextUnblockTime + theProcess.getBlockedTime());
        Scheduler.addToReadyQueue (servingProcess);
        servingProcess = theProcess;
        Scheduler.updateNextUnblock (nextUnblockTime, this);	// this identifies the resource
    }

    public void arrivingProcess (Process theProcess, int time) {
        super.arrivingProcess (theProcess, time);	// executes method of Resource

        int elapsedTime = (time - servingProcess.getServiceStartTime());
        if (theProcess.getServiceStartTime() < servingProcess.getServiceStartTime() - elapsedTime) {
            blockedProcesses.add(servingProcess);
            updateServiceTimes (blockedProcesses, time - servingProcess.getServiceStartTime());
            servingProcess = theProcess;
            nextUnblockTime = time + theProcess.getBlockedTime();
            Scheduler.updateNextUnblock (nextUnblockTime, this);
        }
    }
    private void updateServiceTimes (ArrayList<Process> blockedProcesses, int time) {
        // for each process in blockedProcesses
        // add time to its blockedTime
        // subtract time from serviceTime
        for (Process p : blockedProcesses){
            p.setBlockedTime(p.getBlockedTime() + time);
        }

    }
    public Process getMinTimeProcess (ArrayList<Process> blockedProcesses){
        Process low = blockedProcesses.get(0);
        for (int i = 1; i < blockedProcesses.size(); i++){
            if (blockedProcesses.get(i).getBlockedTime() < low.getBlockedTime()){
                low = blockedProcesses.get(i);
            }
        }
        return(low);
    }
    public void updateNextUnblock(int time) {
        nextUnblockTime += time;
    }
}
