package Scheduler;
import Resource.*;
import Utilities.*;
import Process.Process;

import java.util.LinkedList;

public abstract class Scheduler {
	public final int QUANTUM = 40; //ticks
	
    private int globalTime;
    private IQueue<Process> readyQueue;
    private Process activeProcess;
    private Resource[] resources;
	private LinkedList<Process> processes;
    private Resource nextUnblockResource;
    private int nextArrival, nextExit, nextTimeOut, nextUnblock, nextEvent;
    private int activeTime, idleTime, overheadTime;
	
    public Scheduler(LinkedList<Process> processes, Resource[] resources, IQueue<Process> readyQueue){
        this.resources = resources;
        this.readyQueue = readyQueue;
		this.processes = processes;
		
		this.nextArrival = Integer.MAX_VALUE;
		this.nextExit = Integer.MAX_VALUE;
		this.nextTimeOut = Integer.MAX_VALUE;
		this.nextUnblock = Integer.MAX_VALUE;
		
		this.globalTime = 1;
		this.nextEvent = 0;
		
        for(int i = 0; i < processes.size(); i++){
			if(processes.peek().getArrivalTime() == 0){
				readyQueue.add(processes.pop());
			}
			else {
				nextArrival = processes.peek().getArrivalTime();
				break;
			}	
		}
	
    }

    public Scheduler updateActiveTime(int byTime) {
        activeTime += byTime;
        return this;
    }

    public Scheduler updateIdleTime(int byTime) {
        idleTime += byTime;
        return this;
    }

    public Scheduler updateOverheadTime(int byTime) {
        overheadTime += byTime;
        return this;
    }
	
	public Scheduler updateGlobalTime(int byTime){
		globalTime += byTime;
		return this;
	}

    public Scheduler updateNextEvent() {
        nextEvent = Math.min(nextArrival, Math.min(nextExit, Math.min(nextTimeOut, Math.min(activeProcess.getNextBlockStartTime(), nextUnblock))));
        return this;
    }

    public boolean updateNextUnblock(int block, Resource resource) {
        if (nextUnblock < block) {
            nextUnblock = block;
            nextUnblockResource = resource;
            return true;
        }
        return false;
    }

    public LinkedList<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(LinkedList<Process> processes) {
        this.processes = processes;
    }

    public abstract void handleEvent();
	
	void generateNextArrival(){
		
	}

    abstract void updatePriorities(int byTime);

    abstract void addToReadyQueue(Process process);

    abstract void runScheduler();
	

    //Setters and Getters

    public int getGlobalTime() {
        return globalTime;
    }

    public Scheduler setGlobalTime(int globalTime) {
        this.globalTime = globalTime;
        return this;
    }

    public IQueue<Process> getReadyQueue() {
        return readyQueue;
    }

    public Scheduler setReadyQueue(Queue readyQueue) {
        this.readyQueue = readyQueue;
        return this;
    }

    public Process getActiveProcess() {
        return activeProcess;
    }

    public Scheduler setActiveProcess(Process activeProcess) {
        this.activeProcess = activeProcess;
        return this;
    }

    public Resource[] getResources() {
        return resources;
    }

    public Scheduler setResources(Resource[] resources) {
        this.resources = resources;
        return this;
    }

    public Resource getNextUnblockResource() {
        return nextUnblockResource;
    }

    public Scheduler setNextUnblockResource(Resource nextUnblockResource) {
        this.nextUnblockResource = nextUnblockResource;
        return this;
    }

    public int getNextArrival() {
        return nextArrival;
    }

    public Scheduler setNextArrival(int nextArrival) {
        this.nextArrival = nextArrival;
        return this;
    }

    public int getNextExit() {
        return nextExit;
    }

    public Scheduler setNextExit(int nextExit) {
        this.nextExit = nextExit;
        return this;
    }

    public int getNextTimeOut() {
        return nextTimeOut;
    }

    public Scheduler setNextTimeOut(int nextTimeOut) {
        this.nextTimeOut = nextTimeOut;
        return this;
    }

    public int getNextUnblock() {
        return nextUnblock;
    }

    public Scheduler setNextUnblock(int nextUnblock) {
        this.nextUnblock = nextUnblock;
        return this;
    }

    public int getNextEvent() {
        return nextEvent;
    }

    public Scheduler setNextEvent(int nextEvent) {
        this.nextEvent = nextEvent;
        return this;
    }

    public int getActiveTime() {
        return activeTime;
    }

    public Scheduler setActiveTime(int activeTime) {
        this.activeTime = activeTime;
        return this;
    }

    public int getIdleTime() {
        return idleTime;
    }

    public Scheduler setIdleTime(int idleTime) {
        this.idleTime = idleTime;
        return this;
    }

    public int getOverheadTime() {
        return overheadTime;
    }

    public Scheduler setOverheadTime(int overheadTime) {
        this.overheadTime = overheadTime;
        return this;
    }
}