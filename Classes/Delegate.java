package Classes;

import java.util.ArrayList;

public class Delegate extends Person {
    TypesOfDelegate delegateType;
    String regions;
    ArrayList<Integer> competitionsDelegated;
    private int id;
    private static int staticId;
    static {
        staticId = 0;
    }

    public Delegate(String name, String country, int age, TypesOfDelegate delegateType, String regions) {
        super(name, country, age);
        this.delegateType = delegateType;
        this.regions = regions;
        this.id = staticId;
        staticId++;
    }

    public void addCompetitionDelegated(int comp) {
        this.competitionsDelegated.add(comp);
    }

    @Override
    public void printDetailed() {
        System.out.println("Nume: " + this.name);
        if (delegateType == TypesOfDelegate.SeniorDelegate) {
            System.out.println("Delegat Senior");
        } else if (delegateType == TypesOfDelegate.JuniorDelegate) {
            System.out.println("Delegat Junior");
        } else if (delegateType == TypesOfDelegate.CandidateDelegate) {
            System.out.println("Delegat Candidat");
        } else if (delegateType == TypesOfDelegate.RegionalDelegate) {
            System.out.println("Delegat Regional");
        } else if (delegateType == TypesOfDelegate.Delegate) {
            System.out.println("Delegat");
        }
        System.out.println("Regiune Delegata: " + regions);
        System.out.println("Tara: " + this.country);
        System.out.println("#################################");
        System.out.println();
    }

    @Override
    public String typeOfPerson() {
        return "Delegate";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
