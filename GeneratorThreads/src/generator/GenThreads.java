package generator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GenThreads {
    private final Object sync;
    private final Counter counter;
    private long id;
    private final Map<Long, Parameters> map;
    private final SimpleDateFormat formatForDateNow;
    private boolean status;
    private int value;

    public GenThreads() {
        this.counter = new Counter();
        this.id = 0;
        this.map = new HashMap<>();
        this.formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");
        this.status = true;
        this.value = 1;
        this.sync = new Object();
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Counter getCounter() {
        return counter;
    }

    public Object getSync() {
        return sync;
    }

    public void work() {
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

    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (sync) {
                while (true) {

                    System.out.println("setting value to 1");
                    value = 1;
                    work();

                    sync.notify(); //передаем монитор другому потоку
                    System.out.println("Thread1 notified");

                    while (value != 2 || !status) { //ставим поток на ожидание
                        try {
                            sync.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    });

    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (sync) {
                while (true) {

                    System.out.println("setting value to 2");
                    value = 2;
                    work();

                    sync.notify(); //передаем монитор другому потоку
                    System.out.println("Thread2 notified");

                    while (value != 1 || !status) {  //ставим поток на ожидание
                        try {
                            sync.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    });
}
