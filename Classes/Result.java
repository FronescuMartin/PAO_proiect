package Classes;

import java.text.DecimalFormat;
import java.util.Arrays;


public class Result {
    private Events event;
    private double times[]; //3 or 5 times
    private int times_len;
    private int rankInRound;
    private double single, average;
    private SingleRecordTypes singleRecord;
    private AverageRecordTypes averageRecord;
    private Competition competition;
    private int competitionId;

    public Result(Events event, double[] times, int times_len, int rankInRound, SingleRecordTypes singleRecord, AverageRecordTypes averageRecord, Competition competition, int competitionId) {
        this.event = event;
        this.times = times;
        this.times_len = times_len;
        this.rankInRound = rankInRound;
        this.singleRecord = singleRecord;
        this.averageRecord = averageRecord;
        this.competition = competition;
        this.competitionId = competitionId;
        this.calculateAverageAndSingle();
    }

    //Constructorul fara obiectul Competition
    /*public Result(Events event, double[] times, int times_len, int rankInRound, SingleRecordTypes singleRecord, AverageRecordTypes averageRecord, int competitionId) {
        this.event = event;
        this.times = times;
        this.times_len = times_len;
        this.rankInRound = rankInRound;
        this.singleRecord = singleRecord;
        this.averageRecord = averageRecord;
        this.competitionId = competitionId;
        this.calculateAverageAndSingle();
    }*/

    public Events getEvent() {
        return event;
    }

    public int getEventIndex() {
        // Get the index of the enum constant
        return event.ordinal();
    }

    public void setEvent(Events event) {
        this.event = event;
    }

    public double[] getTimes() {
        return times;
    }

    public void setTimes(double[] times) {
        this.times = times;
    }

    public int getTimes_len() {
        return times_len;
    }

    public void setTimes_len(int times_len) {
        this.times_len = times_len;
    }

    public int getRankInRound() {
        return rankInRound;
    }

    public void setRankInRound(int rankInRound) {
        this.rankInRound = rankInRound;
    }

    public double getSingle() {
        return single;
    }

    public void setSingle(double single) {
        this.single = single;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public SingleRecordTypes getSingleRecord() {
        return singleRecord;
    }

    public void setSingleRecord(SingleRecordTypes singleRecord) {
        this.singleRecord = singleRecord;
    }

    public AverageRecordTypes getAverageRecord() {
        return averageRecord;
    }

    public void setAverageRecord(AverageRecordTypes averageRecord) {
        this.averageRecord = averageRecord;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public int getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }

    private double roundTo2DecimalPlaces(double num) {
        return Math.round(num * 100) / 100.0;
        //aproximeaza rezultatele la 2 zecimale, folosit pentru calcularea mediei
    }
    private void calculateAverageAndSingle(){
        //single reprezinta cel mai bun rezultat din cele 3 sau 5 din cadrul rezultatului
        //average reprezinta media celor 3 timpi mijlocii in cazul probelor cu 5 timpi
        //sau media celor 3 timpi in cazul probelor cu 3 timpi
        double sum=times[0];
        double best=-1;
        double worst=-1;
        for(int i=1; i<times_len; i++){
            sum+=times[i];
            if(times[i]<best || best==-1){
                best=times[i];
            }
            if(times[i]>worst){
                worst=times[i];
            }

        }
        if(times_len==5){
            sum=sum-best-worst; //in cazul probelor cu 5 rezultate, se scade timpul cel mai rapid cat si cel mai lent
        }
        average=roundTo2DecimalPlaces(sum/3); //aproximarea deoarece in baza de date totul este stocat cu 2 zecimale
        single=best;
    }

    @Override
    public String toString() {
        //afiseaza timpii din cadrul obiectului Result
        //realizeaza formatare pentru a afisa corect timpii de peste 1 minut
        //scriind timpii in minute:secunde.sutimi in loc de secunde.sutimi
        //de asemenea afiseaza toti timpii cu 2 zecimale, chiar si in cazul timpilor de forma 2.00 pentru a nu arata 2
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < times_len; i++) {
            if (times[i] < 60) {
                sb.append(new DecimalFormat("0.00").format(times[i])).append(" ");
            } else {
                int mins = (int) Math.floor(times[i] / 60);
                double seconds = times[i] - mins * 60;
                sb.append(mins).append(":");
                sb.append((seconds < 10 ? "0" : "")).append(new DecimalFormat("0.00").format(seconds)).append(" ");
            }
        }

        sb.append("\n");

        sb.append("Competition: ").append(competition.getName()).append("\n");
        return sb.toString();
    }
}
