import java.util.Date;

public class Diary {

    private int estimation;
    private String dateNow;

    public Diary(int estimation, String dateNow) {
        this.estimation = estimation;
        this.dateNow = dateNow;
    }

    public int getEstimation() {
        return estimation;
    }

    public void setEstimation(int estimation) {
        this.estimation = estimation;
    }


    public String getDateNow() {
        return dateNow;
    }

    public void setDateNow(String dateNow) {
        this.dateNow = dateNow;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "estimation=" + estimation +
                ", dateNow=" + dateNow +
                '}';
    }
}
