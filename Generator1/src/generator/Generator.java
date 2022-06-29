package generator;

import java.text.SimpleDateFormat;
import java.util.*;

public class Generator extends Thread {

    Counter counter = new Counter();

    long id = 0;
    String date;
    int number;
    Date dateNow;
    Map<Long, Parametrs> map = new HashMap<>();
    SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");


    public class Parametrs {
        int number;
        String date;
        Date dateNow;

        @Override
        public String toString() {
            return "  Номер: " + number + "  Дата: " + date + "]";
        }

        public Parametrs(int number, String date, Date dateNow) {
            this.number = number;
            this.date = date;
            this.dateNow = dateNow;
        }
    }

    public void run() {
        while (true) {
            id++;
            number = (int) (Math.random() * 10);
            date = formatForDateNow.format(dateNow = new Date());
            map.put(id, new Parametrs(number, date, dateNow = new Date()));
            counter.count.put(id, new Parametrs(number, date, dateNow = new Date()));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
