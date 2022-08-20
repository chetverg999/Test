import java.text.SimpleDateFormat;
import java.util.Date;

public class Consumer {
    Classes classes = new Classes();
    SimpleDateFormat formatForDateNow = new SimpleDateFormat(("E yyyy.MM.dd 'и время' hh:mm:ss a zzz"));
    Teacher mathTeacher = new Teacher();
    Teacher physicsTeacher = new Teacher();
    Teacher programmingTeacher = new Teacher();
    Teacher literatureTeacher = new Teacher();
    Teacher physicalEducationTeacher = new Teacher();

    public void startConsumer() {
        teacherLiterature.start();
        teacherMath.start();
        teacherPhysics.start();
        teacherProgramming.start();
        teacherPhysicalEducation.start();
    }

    Thread teacherMath = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " готов к работе");
                final int estimation = (int) Math.random() * 5;
                final Date dateNow = new Date();
                final String date = formatForDateNow.format(dateNow);
                try {
                    Thread.sleep(3000);
                    mathTeacher.getDiary().put(classes.getMath().take(), new Diary(estimation, date));
                    System.out.println(Thread.currentThread().getName() + "принял студента");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(mathTeacher.getDiary().toString());
            }
        }
    }, "Учитель математики");

    Thread teacherProgramming = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " готов к работе");
                final int estimation = (int) Math.random() * 10;
                final Date dateNow = new Date();
                final String date = formatForDateNow.format(dateNow);
                try {
                    Thread.sleep(3000);
                    programmingTeacher.getDiary().put(classes.getProgramming().take(), new Diary(estimation, date));
                    System.out.println(Thread.currentThread().getName() + "принял студента");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(programmingTeacher.getDiary().toString());
            }
        }
    }, "Учитель программирования");

    Thread teacherPhysics = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " готов к работе");
                final int estimation = (int) Math.random() * 10;
                final Date dateNow = new Date();
                final String date = formatForDateNow.format(dateNow);
                try {
                    Thread.sleep(3000);
                    physicsTeacher.getDiary().put(classes.getPhysics().take(), new Diary(estimation, date));
                    System.out.println(Thread.currentThread().getName() + "принял студента");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(physicsTeacher.getDiary().toString());
            }
        }
    }, "Учитель физики");

    Thread teacherLiterature = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " готов к работе");
                final int estimation = (int) Math.random() * 10;
                final Date dateNow = new Date();
                final String date = formatForDateNow.format(dateNow);
                try {
                    Thread.sleep(3000);
                    literatureTeacher.getDiary().put(classes.getLiterature().take(), new Diary(estimation, date));
                    System.out.println(Thread.currentThread().getName() + "принял студента");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(literatureTeacher.getDiary().toString());
            }
        }
    }, "Учитель литературы");

    Thread teacherPhysicalEducation = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " готов к работе");
                final int estimation = (int) Math.random() * 10;
                final Date dateNow = new Date();
                final String date = formatForDateNow.format(dateNow);
                try {
                    Thread.sleep(3000);
                    physicalEducationTeacher.getDiary().put(classes.getPhysicalEducation().take(), new Diary(estimation, date));
                    System.out.println(Thread.currentThread().getName() + "принял студента");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(physicalEducationTeacher.getDiary().toString());
            }
        }
    }, "Учитель физкультуры");
}
