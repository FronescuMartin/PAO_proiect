package Classes;

public class Date {
    protected int day, month, year;

    public Date() {
    }
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        String formattedDay = (day < 10) ? "0" + day : String.valueOf(day);
        String formattedMonth = (month < 10) ? "0" + month : String.valueOf(month);
        return formattedDay + "." + formattedMonth + "." + year;
    }
}
