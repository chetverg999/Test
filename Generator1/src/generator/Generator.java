package generator;

import java.text.SimpleDateFormat;
import java.util.*;

public class Generator extends Thread {

    protected Counter counter;

    private long id;
    private Map<Long, Parameters> map;
    private SimpleDateFormat formatForDateNow;

    public Generator() {
        this.counter = new Counter();
        this.id = 0;
        this.map = new HashMap <>();
        this.formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");
    }


    public void run() {
        while (true) {
            id++;
            final Date dateNow = new Date();
            final int number = (int) (Math.random() * 10);
            final String date = formatForDateNow.format(dateNow);
            map.put(id, new Parameters(number, date, dateNow));
            counter.getCount().put(id, new Parameters(number, date, dateNow));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
