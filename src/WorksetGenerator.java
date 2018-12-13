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
    private int index = 0;
    private String type = null;

    public int TypeA = 0;
    public int TypeB = 0;
    public int TypeC = 0;
    public int TypeTot = 0;
    public int Proc1 = 0;
    public int Proc2 = 0;
    public int Proc3 = 0;
    public int Proc4 = 0;
    public int ProcTot = 0;
    //Globally define process

    private Process createdProcess(){
        Process theProcess;

        int number = RNG.RNG_Max(100);

        if (number < 49) {
            theProcess = new ProcessI(A, C);
            Proc1 ++;
            type = "1";
        }
        else if (number < 79) {
            theProcess = new ProcessII();
            Proc2 ++;
            type = "2";
        }
        else if (number < 96) {
            theProcess = new ProcessIII(A, B, C);
            Proc3 ++;
            type = "3";
        }
        else{
            theProcess = new ProcessIV(B, C);
            Proc4 ++;
            type = "4";
        }
        ProcTot ++;
        theProcess.setID("P" + Integer.toString(index));
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

    public static void main(String args[]){
        System.out.println("ID, Type, Arrive, Running, Block List, Total Blocked");

        for (int i = 0; i < 4; i ++){
            restProcesses();
            //this is where I'm going
            System.out.println((Integer.toString(index)) + type + );
        }
    }
}
