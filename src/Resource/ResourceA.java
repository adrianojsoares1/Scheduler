package Resource;
import Process.Process;
import Utilities.RNG;

public class ResourceA extends Resource {

    public void finishService ( ) {
        Process theProcess = blockedProcesses.getMinTimeProcess ( );
        blockedProcesses.remove(0);
        blockedProcesses.updateServiceTimes (theProcess.getBlockedTime());
        nextUnblockTime = nextUnblockTime + theProcess.serviceTime;
        Scheduler.insertReadyList (servingProcess);
        servingProcess = theProcess;
        Scheduler.updateNextUnblock (nextUnblockTime, this);	// this identifies the resource
    }

    public void arrivingProcess (Process theProcess, int time) {
        super.arrivingProcess (theProcess, time);	// executes method of Resource

        int elapsedTime = (time - servingProcess.getServiceStartTime());
        if (theProcess.getServiceStartTime() < servingProcess.getServiceStartTime() - elapsedTime) {
            blockedProcesses.add(servingProcess);
            blockedProcesses.updateServiceTimes (time - servingProcess.getServiceStartTime());
            servingProcess = theProcess;
            nextUnblockTime = time + theProcess.getBlockedTime();
            Scheduler.updateNextUnblock (nextUnblockTime, this);
        }
    }

    public void updateServiceTimes (int time) {
        // for each process in blockedProcesses
        // add time to its blockedTime
        // subtract time from serviceTime
    }


    public void updateNextUnblock(int time) {

    }
    public void arrivingProcess(Process theProcess) {

    }

    public int generateBlockTime(){
        return RNG.RNG_Min(60,100);
    }
}
