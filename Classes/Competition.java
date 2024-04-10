package Classes;

public class Competition extends Date implements CompetitionInterface{
    private String name;
    private int numberOfCompetitors, id;
    private static int staticId;

    static {
        staticId = 0;
    }
    public Competition(String name, int numberOfCompetitors, int day, int month, int year) {
        super(day, month, year);
        this.name = name;
        this.numberOfCompetitors = numberOfCompetitors;
        this.id=this.getStaticId();
        staticId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfCompetitors() {
        return numberOfCompetitors;
    }

    public void setNumberOfCompetitors(int numberOfCompetitors) {
        this.numberOfCompetitors = numberOfCompetitors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStaticId(){
        return staticId;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void printDetailed() {
        System.out.println("Nume: " + this.name);
        System.out.println("Numar concurenti: " + numberOfCompetitors);
        System.out.println("Data: " + super.toString());
        System.out.println("ID: " + this.getId());
        System.out.println();
    }

    @Override
    public String typeOfCompetition() {
        return "WCA Competition";
    }
}
