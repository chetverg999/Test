package generator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Threads implements Runnable {

    private final Counter counter;
    private long id;
    private final Map<Long, Parameters> map;
    private final SimpleDateFormat formatForDateNow;
    private boolean status;
    private int value;

    public Threads() {
        this.counter = new Counter();
        this.id = 0;
        this.map = new HashMap<>();
        this.formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");
        this.status = true;
        this.value = 1;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public Counter getCounter() {
        return counter;
    }

    public Map<Long, Parameters> getMap() {
        return map;
    }

    public void work() {
        synchronized (map) {
            id++;
            final Date dateNow = new Date();
            final int number = (int) (Math.random() * 10);
            final String date = formatForDateNow.format(dateNow);
            map.put(id, new Parameters(number, date, dateNow));
            counter.getCount().put(id, new Parameters(number, date, dateNow));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    @Override
    public void run() {
        System.out.println("Начал выполнение " + Thread.currentThread().getName());
            while (status) {
                work();
                System.out.println("Отработал " + Thread.currentThread().getName());
            }
        System.out.println("Закончил выполнение " + Thread.currentThread().getName());
    }

    public void genThreads() {
        Thread thread1 = new Thread(this, "1 поток");
        Thread thread2 = new Thread(this, "2 поток");
        Thread thread3 = new Thread(this, "3 поток");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
