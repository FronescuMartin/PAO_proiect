package Classes;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static Classes.AverageRecordTypes.*;
import static Classes.SingleRecordTypes.*;


public class Competitor extends Person {
    protected int numberOfNRs, numberOfCRs, numberOfWRs;
    ArrayList<Result> results;
    Result[] bestResultsSingle; //length 17;
    Result[] bestResultsAverage; //length 17;
    double[] averageResult; //length 17
    boolean[] hasResultInEvent; //length 17
    private int id;
    private static int staticId;
    static {
        staticId = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Competitor(String name, String country, int age) {
        super(name, country, age);
        this.results=new ArrayList<Result>();
        this.numberOfNRs=0;
        this.numberOfCRs=0;
        this.numberOfWRs=0;
        bestResultsSingle = new Result[17];
        bestResultsAverage = new Result[17];
        averageResult = new double[17];
        hasResultInEvent = new boolean[17];
        for(int i=0; i<17; i++){
            hasResultInEvent[i]=false; //initializarea vectorului care spune daca concurentul are vreun rezultat in proba respectiva
        }
        this.id=staticId;
        staticId++;
    }

    public void calculateRecords(){
        //calculeaza numarul de recorduri (NR=national record, CR=continental record, WR=world record)
        //parcurgand vectorul de rezultate din cadrul unui competitor, si numarand fiecare aparitie a unui enum
        //de tip record, fie el la average, fie la single.
        numberOfNRs=0;
        numberOfCRs=0;
        numberOfWRs=0;

        for(int i=0; i<results.size(); i++){
            if(results.get(i).getSingleRecord()==NR_Single){
                numberOfNRs++;
            }
            if(results.get(i).getAverageRecord()==NR_Average){
                numberOfNRs++;
            }
            if(results.get(i).getSingleRecord()==CR_Single){
                numberOfCRs++;
            }
            if(results.get(i).getAverageRecord()==CR_Average){
                numberOfCRs++;
            }
            if(results.get(i).getSingleRecord()==WR_Single){
                numberOfWRs++;
            }
            if(results.get(i).getAverageRecord()==WR_Average){
                numberOfWRs++;
            }

        }

    }
    public int getNumberOfRecords(){
        return numberOfNRs+numberOfCRs+numberOfWRs;
    }

    public String eventNameFromEnum(int e){ //functia primeste un enum de fapt, dar valoarea e transmisa ca intreg
        if(e==0) return "2x2";
        if(e==1) return "3x3";
        if(e==2) return "4x4";
        if(e==3) return "5x5";
        if(e==4) return "6x6";
        if(e==5) return "7x7";
        if(e==6) return "Megaminx";
        if(e==7) return "Pyraminx";
        if(e==8) return "One Handed";
        if(e==9) return "Blindfolded";
        if(e==10) return "Square-1";
        if(e==11) return "Multi-Blind";
        if(e==12) return "4x4 Blindfolded";
        if(e==13) return "5x5 Blindfolded";
        if(e==14) return "Skewb";
        if(e==15) return "Fewest Moves Challenge";
        if(e==16) return "Clock";
        return "";
    }
    @Override
    public void printDetailed() {
        System.out.println("Nume: " + name);
        System.out.println("Tara: " + country);
        System.out.println("Numar Recorduri: " + getNumberOfRecords());
        System.out.println("Toate Rezultatele:");

        for (Result result : results) {
            Events event = result.getEvent();
            String eventName = event.toString();
            if (eventName.startsWith("_")) {
                eventName = eventName.substring(1); //ca sa afiseze _2x2 de exemplu ca 2x2
            }
            System.out.print(eventName + ": ");
            System.out.println(result);
        }

        System.out.println("Cele mai bune rezultate obtinute:");

        for (int i = 0; i < 17; i++) {
            if (hasResultInEvent[i]) {
                String tmp = eventNameFromEnum(i);
                System.out.print(tmp + " ");
                System.out.print("Single: ");
                double temp = bestResultsSingle[i].getSingle();
                if (temp < 60) {
                    System.out.print(temp + " ");
                } else {
                    int mins = (int) Math.floor(temp / 60);
                    double seconds = temp - mins * 60;
                    System.out.print(mins + ":");
                    System.out.print((seconds < 10 ? "0" : "") + new DecimalFormat("0.00").format(seconds) + " ");
                }
                System.out.print(" Average: ");
                temp = bestResultsAverage[i].getAverage();
                if (temp < 60) {
                    System.out.print(new DecimalFormat("0.00").format(temp) + " ");
                } else {
                    int mins = (int) Math.floor(temp / 60);
                    double seconds = temp - mins * 60;
                    System.out.print(mins + ":");
                    System.out.print((seconds < 10 ? "0" : "") + new DecimalFormat("0.00").format(seconds) + " ");
                }
                System.out.println();
            }
        }

        System.out.println("Timpul mediu pentru fiecare proba:");

        for (int i = 0; i < 17; i++) {
            if (hasResultInEvent[i]) {
                String tmp = eventNameFromEnum(i);
                System.out.print(tmp + ": ");
                double temp = averageResult[i];
                if (temp < 60) {
                    System.out.print(new DecimalFormat("0.00").format(temp));
                } else {
                    int mins = (int) Math.floor(temp / 60);
                    double seconds = temp - mins * 60;
                    System.out.print(mins + ":");
                    System.out.print((seconds < 10 ? "0" : "") + new DecimalFormat("0.00").format(seconds) + " ");
                }
                System.out.println();
            }
        }

        System.out.println("#################################");
    }

    public void findBestResults() {
        for (int i = 0; i < 17; i++) { //Verifica pentru toate cele 17 probe cele mai bune rezultate (i va fi proba
            // respectiva, chiar daca aceasta este enum in mod normal, valoarea implicita a ei este intreg.
            double bestSingle = -1, bestAverage = -1;
            for (Result result : results) {
                if (result.getEventIndex() == i) {
                    hasResultInEvent[i] = true;
                    if (result.getSingle() < bestSingle || bestSingle == -1) {
                        bestResultsSingle[i] = result;
                        bestSingle = result.getSingle();
                    }
                    if (result.getAverage() < bestAverage || bestAverage == -1) {
                        bestResultsAverage[i] = result;
                        bestAverage = result.getAverage();
                    }
                }
            }
        }
    }

    private void calculateAverageResult() { //calculeaza rezultatul mediu al concurentului pentru fiecare proba
        for (int i = 0; i < 17; i++) { //pentru toate cele 17 probe
            int numOfTimes = 0;
            double sum = 0;
            for (Result result : results) {
                if (result.getEventIndex() == i) {
                    double[] temp = result.getTimes();
                    int len = result.getTimes_len();
                    for (int k = 0; k < len; k++) {
                        sum += temp[k];
                        numOfTimes++;
                    }
                }
            }
            averageResult[i] = numOfTimes == 0 ? 0 : sum / numOfTimes;
        }
    }

    public void addResultData(Events event, double[] times, int length, int rank, SingleRecordTypes recordSg, AverageRecordTypes recordAvg, Competition comp, int compId) {
        Result result = new Result(event, times, length, rank, recordSg, recordAvg, comp, compId);
        results.add(result);
        calculateAverageResult();
        calculateRecords();
        findBestResults();
    }

    public ArrayList<Result> getResults() {
        return results;
    }



    @Override
    public String typeOfPerson(){
        return "Competitor";
    }
}
