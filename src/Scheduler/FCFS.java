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
    void updatePriorities(int byTime) { return; }

    @Override
    void addToReadyQueue(Process process) {
		getReadyQueue().add(process.setArrivalTime(getGlobalTime()));
    }
	
	@Override
	void handleNextEvent(){
		switch(getNextEvent()){
			case getNextArrival():{
				
			} break;
			case getNextEvent():{
				
			} break;
			case getNextExit():{
				
			} break;
			case getNextTimeout():{
				
			} break;
			default:{
				
			}
		}
	}
	 
	@Override
    void runScheduler() {
		//First Process
		setActiveProcess(getReadyQueue().poll());
		setNextExit(getActiveProcess().getFinishTime());
		
		while(getNextEvent() != Integer.MAX_INT){
			
			updateEvent();
			handleNextEvent();
			
			setGlobalTime(getGlobalTime() + QUANTUM);
		}
    }

}
