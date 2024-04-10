import Classes.*;
import Services.CompetitionService;
import Services.PersonService;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static Classes.AverageRecordTypes.*;
import static Classes.Events.*;
import static Classes.SingleRecordTypes.*;

public class Main {
    public static void main(String[] args) {
        /*Competition c1 = new Competition( "comp", 23, 1, 23, 2024);
        Competition c2 = new Competition( "comp2", 23, 1, 23, 2024);
        Tournament t1 = new Tournament(1,1,1970,"Feliks Zemdegs", "USA", "Max Park", 4, new int[]{0,1,2,3,1,2,2}, new String[]{"Rowe Hessler", "Mats Valk", "Feliks Zemdegs", "Sebastian Weyer"});

        c1.printDetailed();
        c2.printDetailed();
        t1.printDetailed();
        */
        CompetitionService competitionService = new CompetitionService();
        competitionService.addCompetition("comp", 23, 1, 23, 2024);
        competitionService.addCompetition("comp2", 23, 1, 23, 2024);
        competitionService.addTournament(1,1,1970,"Feliks Zemdegs", "USA", "Max Park", 4, new int[]{0,1,2,3,1,2,2}, new String[]{"Rowe Hessler", "Mats Valk", "Feliks Zemdegs", "Sebastian Weyer"});
        Competition temp = competitionService.getCompetitionById(1);
        if(temp!=null){
            System.out.println("Competitia cu id-ul 2:");
            temp.printDetailed();
        }
        ArrayList<CompetitionInterface> allComps = competitionService.getAllCompetitionsAndTournaments();

        System.out.println("Lista competitii:");
        for(CompetitionInterface c: allComps){
            c.printDetailed();
        }
        competitionService.deleteTournamentById(0);

        System.out.println("Lista competitii dupa stergere:");
        allComps = competitionService.getAllCompetitionsAndTournaments();
        for(CompetitionInterface c: allComps){
            c.printDetailed();
        }


        //Result r = new Result(_2x2, new double[]{111.89, 211.88, 100.70, 200.39, 100.56},5,2, No_Single_Record, No_Average_Record, c1, 1);
        //System.out.println(r.getAverage());
        //System.out.println(r);
        PersonService personService = new PersonService();
        personService.setCompetitions(competitionService);

        personService.addCompetitor("Feliks Zemdegs", "Australia", 32);
        personService.addDelegate("Radu Faciu", "Romania", 30, TypesOfDelegate.SeniorDelegate, "Europa");
        personService.addResultToCompetitorById(0, 1, _5x5, new double[]{111.89, 211.88, 100.70, 200.39, 100.56},5,2, No_Single_Record, No_Average_Record);
        personService.addResultToCompetitorById(0, 0, _2x2, new double []{2.03, 1.02, 0.99, 1.85, 2.93}, 5, 1, NR_Single, CR_Average);
        personService.addResultToCompetitorById(0, 1, _2x2, new double []{4.02, 1.04, 4.21, 3.69, 3.71}, 5, 5, No_Single_Record, No_Average_Record);
        ArrayList<Person> people = personService.getAllPeople();
        System.out.println("Lista persoane:");
        for(Person p: people){
            p.printDetailed();
        }


    }


}