package Services;

import Classes.*;

import java.util.ArrayList;

import static Classes.AverageRecordTypes.*;
import static Classes.SingleRecordTypes.*;
import static Classes.Events.*;


public class PersonService {
    private ArrayList<Person> people;
    private CompetitionService competitionService;
    public PersonService(){
        people = new ArrayList<>();
    }

    public void setCompetitions(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    //adaugare competitor
    public void addCompetitor(String name, String country, int age){
        Competitor c = new Competitor(name, country, age);
        people.add(c);

    }

    //adaugare delegat
    public void addDelegate(String name, String country, int age, TypesOfDelegate delegateType, String regions){
        Delegate d = new Delegate(name, country, age, delegateType, regions);
        people.add(d);
    }

    //obtinere competitor dupa id
    public Competitor getCompetitorById(int id){
        for(Person person: people){
            if(person instanceof Competitor){
                Competitor c = (Competitor) person;
                if(c.getId() == id){
                    return c;
                }
            }
        }
        return null;
    }
    //adaugare rezultat pentru un competitor la o anumita competitie
    public void addResultToCompetitorById(int id, int competitionId, Events event, double[] times, int length, int rank, SingleRecordTypes recordSg, AverageRecordTypes recordAvg){
        //competitorul la care se adauga
        Competitor competitor = getCompetitorById(id);

        //competitia in cadrul careia s-a obtinut rezultatul
        Competition competition = competitionService.getCompetitionById(competitionId);
        competitor.addResultData(event, times,length, rank, recordSg, recordAvg, competition, competitionId);

    }

    //obtinere lista de persoane
    public ArrayList<Person> getAllPeople() {
        return people;
    }
}
