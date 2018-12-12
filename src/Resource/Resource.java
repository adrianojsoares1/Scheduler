package Resource;
import Scheduler.Scheduler;
import Process.Process;
import java.util.ArrayList;

public abstract class Resource{
    private String id;
    private int startIdleTime;
    protected int nextUnblockTime;
    private int activeTime, idleTime;
    public ArrayList<Process> blockedProcesses;
    protected Process servingProcess;

    public abstract void updateNextUnblock (int time );

    public void finishService ( ) {
        int oldTime = nextUnblockTime;		// current process finish time—for legibility
        Process oldProcess = servingProcess;

        updateActiveTime (oldProcess.getBlockedTime());
        if (!blockedProcesses.isEmpty()) {
            Process theProcess = blockedProcesses.remove(0);
            nextUnblockTime = oldTime + theProcess.getBlockedTime();
            servingProcess = theProcess;
            servingProcess.setServiceStartTime(oldTime);
        }
        else {
            Process theProcess = null;
            startIdleTime = oldTime;
            nextUnblockTime = 25000;
            servingProcess = null;
        }
        Scheduler.insertReadyList (servingProcess);
        Scheduler.updateNextUnblock (nextUnblockTime, this);	// this identifies the resource
    }

    public void arrivingProcess (Process theProcess, int time) {
        theProcess.setBlockedTime(0);
        if (blockedProcesses == null) {
            servingProcess = theProcess;
            theProcess.setNextBlockStartTime(time);
            updateIdleTime (time - idleTime);
            nextUnblockTime = time + theProcess.getBlockedTime();
            Scheduler.updateNextUnblock (this.nextUnblockTime);
        }
        else {
            blockedProcesses.add(theProcess);
        }
    }

    public void updateActiveTime (int time) {
        this.activeTime += time;
    }
    public void updateIdleTime (int time) {
        this.idleTime += time;
    }

    public abstract int generateBlockTime();

    public String getId(){
        return(this.id);
    }
}