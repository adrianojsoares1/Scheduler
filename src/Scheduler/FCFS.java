package Scheduler;
import Process.Process;
import Utilities.Queue;
import Resource.Resource;

import java.util.LinkedList;

public class FCFS extends Scheduler {

    public FCFS(Process[] processes, Resource[] resources){
        super(processes, resources, new LinkedList<Process>());
    }


    @Override
    void updatePriorities(int byTime) {

    }

    @Override
    void runScheduler() {

    }

    @Override
    void addToReadyQueue(Process process) {

    }

}
