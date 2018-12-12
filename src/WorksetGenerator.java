import Utilities.RNG;
import  java.util.ArrayList;
import Resource.*;
import Process.Process;
import Process.ProcessI;
import Process.ProcessII;
import Process.ProcessIII;
import Process.ProcessIV;


public class WorksetGenerator {
    private ArrayList<Process> processList = new ArrayList<Process>();
    private ResourceA A = new ResourceA();
    private ResourceB B = new ResourceB();
    private ResourceC C = new ResourceC();
    private int totalProcessTime = 0; //this is a number

    private Process createdProcess(){
        Process theProcess;
        int number = RNG.RNG_Max(100);

        if (number < 49) {
            theProcess = new ProcessI(A, C);
        }
        else if (number < 79) {
            theProcess = new ProcessII();
        }
        else if (number < 96) {
            theProcess = new ProcessIII(A, B, C);
        }
        else{
            theProcess = new ProcessIV(B, C);
        }
        return theProcess;
    }

    public void initProcesses() {
        int number = RNG.RNG_Min(3, 8);
        for(int i = 0; i < number; i++) {
            processList.add(createdProcess());
            totalProcessTime += processList.get(i).getFinishTime();
        }
    }

    public void restProcesses(){
        int i = 0;
        while(25000 > totalProcessTime) {
            processList.add(createdProcess());
            totalProcessTime += processList.get(i).getFinishTime();
            i ++;
        }
    }
    public int getTotalProcessTime(){
        return(this.totalProcessTime);
    }
}
