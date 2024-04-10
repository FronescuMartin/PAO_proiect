package Classes;

public class Tournament extends Date implements CompetitionInterface {
    private String winner, locationCountry, runnerUp;
    private int numberOfCompetitors;
    private int[] bracket;
    private int id;
    private static int staticId;
    static{
        staticId=0;
    }

    String[] competitors;

    public Tournament(int day, int month, int year, String winner, String locationCountry, String runnerUp, int numberOfCompetitors, int[] bracket, String[] competitors){
        super(day, month, year);
        this.winner=winner;
        this.locationCountry=locationCountry;
        this.runnerUp=runnerUp;
        this.numberOfCompetitors=numberOfCompetitors;
        this.bracket=bracket;
        this.competitors=competitors;
        this.id=staticId;
        staticId++;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public String getRunnerUp() {
        return runnerUp;
    }

    public void setRunnerUp(String runnerUp) {
        this.runnerUp = runnerUp;
    }

    public int getNumberOfCompetitors() {
        return numberOfCompetitors;
    }

    public void setNumberOfCompetitors(int numberOfCompetitors) {
        this.numberOfCompetitors = numberOfCompetitors;
    }

    public int[] getBracket() {
        return bracket;
    }

    public void setBracket(int[] bracket) {
        this.bracket = bracket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getStaticId() {
        return staticId;
    }

    public static void setStaticId(int staticId) {
        Tournament.staticId = staticId;
    }

    public String[] getCompetitors() {
        return competitors;
    }

    public void setCompetitors(String[] competitors) {
        this.competitors = competitors;
    }

    @Override
    public void printDetailed() {
        System.out.println("Turneul Mondial din " + this.year);
        System.out.println("Numar participanti: " + this.numberOfCompetitors);
        System.out.println("Castigatorul turneului a fost " + this.winner);
        System.out.println();
    }

    @Override
    public String toString(){
        return ("Turneul Mondial din " + this.year+"\n");
    }

    @Override
    public String typeOfCompetition() {
        return "Tournament";
    }

}
