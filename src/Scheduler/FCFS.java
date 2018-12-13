package Scheduler;
import Process.Process;
import Utilities.Queue;
import Resource.Resource;
import Process.Block;
import java.util.LinkedList;

public class FCFS extends Scheduler {
	
	public final int QUANTUM = 1; //ticks
	public final int SCHEDULER_TIME = 5;
	public StringBuilder logs;

    public FCFS(LinkedList<Process> processes, Resource[] resources){
        super(processes, resources, new Queue<Process>());

        logs = new StringBuilder();
}

    @Override
    void updatePriorities(int byTime) { return; }

    @Override
    void addToReadyQueue(Process process) {
		getReadyQueue().add(process.setArrivalTime(getGlobalTime()));
    }
	
	@Override
	public void handleEvent(){
    	if(getNextEvent() == getNextArrival()){
    		logs.append("Reached event: Arrival at tick ").append(getNextArrival());
    		getReadyQueue().add(getProcesses().pop());

    		if(getProcesses().size() > 0)
    			setNextArrival(getProcesses().peek().getArrivalTime());
		}
    	else if(getNextEvent() == getNextUnblock()){
			logs.append("Reached event: Unblock at tick ").append(getNextUnblock());
    		getNextUnblockResource().finishService();
		}
    	else if(getNextEvent() == getNextExit()){
			logs.append("Reached event: Process ").append(getActiveProcess().toString())
			.append(" at tick ").append(getNextUnblock());

    		setActiveProcess(getReadyQueue().poll());
    		updateOverheadTime(SCHEDULER_TIME);
		}
    	else if(getNextEvent() == getActiveProcess().getNextBlockStartTime()){
    		logs.append("Reached event: Block at ").append(getActiveProcess().getNextBlockStartTime());
    		Block o = getActiveProcess().blocks.poll();
    		Resource resource;
    		if(o != null) {
				resource = o.getBlockResource();
				resource.blockedProcesses.add(getActiveProcess());
			}

    		setActiveProcess(getReadyQueue().poll());

			updateOverheadTime(SCHEDULER_TIME);
		}
	}
	 
	@Override
    void runScheduler() {
		//First Process
		setActiveProcess(getReadyQueue().poll());
		setNextExit(getActiveProcess().getFinishTime());
		
		while(getNextEvent() != Integer.MAX_VALUE){
			
			updateNextEvent().handleEvent();
			
			updateGlobalTime(QUANTUM);
			if(getActiveProcess() != null)
				updateActiveTime(1);
			else updateIdleTime(1);
		}
    }
}
