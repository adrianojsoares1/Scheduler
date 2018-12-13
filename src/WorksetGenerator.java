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
    private static int totalProcessTime = 0; //this is a number
    private static String type = null;

    private static int TypeA = 0;
    private static int TypeB = 0;
    private static int TypeC = 0;
    private static int Proc1 = 0;
    private static int Proc2 = 0;
    private static int Proc3 = 0;
    private static int Proc4 = 0;
    private static Process theProcess;

    public void getProcesses(){
        initProcesses();
        restProcesses();
    }


    private Process createdProcess(){
        int number = RNG.RNG_Max(100);

        if (number < 49) {
            theProcess = new ProcessI(A, B);
            Proc1 ++;
            type = "1";
            TypeA ++;
            TypeB ++;
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
            TypeA ++;
            TypeB ++;
            TypeC ++;
        }
        else{
            theProcess = new ProcessIV(B, C);
            Proc4 ++;
            type = "4";
            TypeB ++;
            TypeC ++;
        }
        return theProcess;
    }

    public void initProcesses() {
        int number = RNG.RNG_Min(3, 8);
        for(int i = 0; i < number; i++) {
            processList.add(createdProcess().setArrivalTime(0));
            totalProcessTime += processList.get(i).getFinishTime();
        }
    }

    public void restProcesses(){
        int i = 0;
        while(25000 > totalProcessTime) {
            Process p = createdProcess();
            processList.add(p.setArrivalTime(totalProcessTime + p.getFinishTime()));
            totalProcessTime += processList.get(i).getFinishTime();
            i ++;
        }
    }

    public static void main(String args[]){
        WorksetGenerator fuckthisshit = new WorksetGenerator();

        fuckthisshit.initProcesses();
        fuckthisshit.restProcesses();

        for(int i = 0; i < fuckthisshit.processList.size(); i++){
            String type = (fuckthisshit.processList.get(i) instanceof ProcessI) ? "1" :
                    (fuckthisshit.processList.get(i) instanceof ProcessII) ? "2" :
                            (fuckthisshit.processList.get(i) instanceof ProcessIII) ? "3" : "4";

            System.out.println("ID: p" + i + " | Type: " + type + " | Arrival: " +
                    fuckthisshit.processList.get(i).getArrivalTime() + " | Running Time: " + fuckthisshit.processList.get(i).getFinishTime());
        }
        System.out.println("Total Running Time: " + totalProcessTime + "  Type A: " + TypeA + " Type B: " + TypeB + " Type C: " + TypeC );


    }
}
