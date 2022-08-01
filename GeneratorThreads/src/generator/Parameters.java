package generator;

import java.util.Date;

public class Parameters {
    private int number;
    private String date;
    private Date dateNow;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getDateNow() {
        return dateNow;
    }

    public void setDateNow(Date dateNow) {
        this.dateNow = dateNow;
    }

    public Parameters(int number, String date, Date dateNow) {
        this.number = number;
        this.date = date;
        this.dateNow = dateNow;
    }

    @Override
    public String toString() {
        return "  Номер: " + number + "  Дата: " + date + "]";
    }
}
