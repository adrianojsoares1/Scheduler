import Utilities.RNG;
import  java.util.ArrayList;
import Resource.*;
import Process.Process;
import Process.ProcessI;
import Process.ProcessII;
import Process.ProcessIII;
import Process.ProcessIV;


public class WorksetGenerator {
    public int maxInt = 25000; //this is a number
    public ArrayList<Process> processList = new ArrayList<Process>()
    public ResourceA A = new ResourceA();
    public ResourceB B = new ResourceB();
    public ResourceC C = new ResourceC();
    public int totalProcessTime = 0; //this is a number

    public Process createdProcess(){
            Process theProcess = null;
            int number = RNG.RNG_Max(100);
        if (number < 49) {
            theProcess = new ProcessI();
        }
        else if (number < 79) {
            theProcess = new ProcessII();
        }
        else if (number < 96) {
            theProcess = new ProcessIII();
        }
        else{
            theProcess = new ProcessIV();
        }
        return theProcess;
    }

    public void initProcesses() {
        int number = RNG.RNG_Min(3, 8);
        for(int i = 0; i <= number; i--)
        {
            processList.add(createdProcess());
            totalProcessTime += processList.get(i).getFinishTime();
        }
    }

    public void restProcesses(){
        Process theProcess = null;
        while(maxInt > totalProcessTime) {
            processList.add(createdProcess());
            totalProcessTime += processList.get(i).getFinishTime();
        }
    }
}
