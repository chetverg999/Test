package generator;

import java.text.SimpleDateFormat;
import java.util.*;

public class Generator extends Thread {

    protected final Counter counter = new Counter();

    private long id = 0;
    private String date;
    private int number;
    private Date dateNow;
    private final Map<Long, Parametrs> map = new HashMap<>();
    private SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");

    public Generator() {

    }

    public class Parametrs {
        protected int number;
        protected String date;
        protected Date dateNow;

        public Parametrs(int number, String date, Date dateNow) {
            this.number = number;
            this.date = date;
            this.dateNow = dateNow;
        }

        @Override
        public String toString() {
            return "  Номер: " + number + "  Дата: " + date + "]";
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
