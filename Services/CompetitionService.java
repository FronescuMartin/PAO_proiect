package Services;

import Classes.Competition;
import Classes.CompetitionInterface;
import Classes.Tournament;

import java.util.ArrayList;

public class CompetitionService {
    private ArrayList<CompetitionInterface> competitions; //pentru a putea adauga obiecte de tip
                                                          //Competition si Tournament
    public CompetitionService() {
        competitions = new ArrayList<>();
    }

    //adaugare competitie
    public void addCompetition(String name, int numberOfCompetitors, int day, int month, int year) {
        Competition competition = new Competition(name, numberOfCompetitors, day, month, year);
        competitions.add(competition);
    }

    //adaugare turneu
    public void addTournament(int day, int month, int year, String winner, String locationCountry, String runnerUp, int numberOfCompetitors, int[] bracket, String[] competitors){
        Tournament t = new Tournament(day, month, year, winner, locationCountry, runnerUp, numberOfCompetitors, bracket, competitors);
        competitions.add(t);
    }

    //obtinere lista de competitii/turnee
    public ArrayList<CompetitionInterface> getAllCompetitionsAndTournaments() {
        return competitions;
    }

    //obtinere competitie dupa id
    public Competition getCompetitionById(int id){
        for(CompetitionInterface competition: competitions){
            if(competition instanceof Competition){
                Competition comp = (Competition) competition;
                if(comp.getId() == id){
                    return comp;
                }
            }
        }
        return null;
    }
    //obtinere turneu dupa id
    public Tournament getTournamentById(int id){
        for(CompetitionInterface competition: competitions){
            if(competition instanceof Tournament){
                Tournament t = (Tournament) competition;
                if(t.getId() == id){
                    return t;
                }
            }
        }
        return null;
    }
    //stergere competitie dupa id
    public void deleteCompetitionById(int id) {
        for (int i = 0; i < competitions.size(); i++) {
            CompetitionInterface competition = competitions.get(i);
            if (competition instanceof Competition) {
                Competition comp = (Competition) competition;
                if (comp.getId() == id) {
                    competitions.remove(i);
                    return;
                }
            }
        }
        System.out.println("Competition with ID " + id + " not found.");
    }

    //stergere turneu dupa id
    public void deleteTournamentById(int id) {
        for (int i = 0; i < competitions.size(); i++) {
            CompetitionInterface competition = competitions.get(i);
            if (competition instanceof Tournament) {
                Tournament t = (Tournament) competition;
                if (t.getId() == id) {
                    competitions.remove(i);
                    return;
                }
            }
        }
        System.out.println("Tournament with ID " + id + " not found.");
    }
}
