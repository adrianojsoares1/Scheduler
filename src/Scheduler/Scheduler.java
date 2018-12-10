package Scheduler;
import Resource.Resource;

import Utilities.*;
import java.util.List;

public class Scheduler{
    private int globalTime;
    private IQueue readyQueue;
    private Process activeProcess;
    private List<Resource> resources;
    private Resource nextUnblockResource;
    private int nextArrival, nextExit, nextTimeOut, nextUnblock, nextEvent;
    private int activeTime, idleTime, overheadTime;

    private void updateNextEvent(){
        nextEvent = Math.min(nextArrival, Math.min(nextExit, Math.min(nextTimeOut, nextUnblock)));
    }

    private void updateNextUnblock(int block, Resource resource){
        if(nextUnblock < block){
            nextUnblock = block;
            nextUnblockResource = resource;
        }
    }

    public void handleEvent(){
        if(nextEvent == nextUnblock) {
            nextUnblockResource.finishService();
            updateNextEvent();
        }
        else if(nextEvent == nextArrival){

        }
        else if(nextEvent == nextExit){

        }
        else{

        }
    }

    private void updatePriorities(int byTime){

    }

    private void scheduleNextProcess(int byTime){

    }
}