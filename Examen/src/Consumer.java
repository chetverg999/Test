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
            M:
            {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " готов к работе");
                    final int estimation = (int) (Math.random() * 5);
                    final Date dateNow = new Date();
                    final String date = formatForDateNow.format(dateNow);
                    try {
                        Thread.sleep(3000);
                        mathTeacher.getDiary().put(classes.getMath().take(), new Diary(estimation, date));
                        System.out.println(Thread.currentThread().getName() + " принял студента");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + mathTeacher.getDiary().toString());
                    if (mathTeacher.getDiary().size() == 10) {
                        System.out.println("Учитель математики закончил работать");
                        break M;
                    }
                }
            }
        }
    }, "Учитель математики");

    Thread teacherProgramming = new Thread(new Runnable() {
        @Override
        public void run() {
            M2:
            {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " готов к работе");
                    final int estimation = (int) (Math.random() * 10);
                    final Date dateNow = new Date();
                    final String date = formatForDateNow.format(dateNow);
                    try {
                        Thread.sleep(3000);
                        programmingTeacher.getDiary().put(classes.getProgramming().take(), new Diary(estimation, date));
                        System.out.println(Thread.currentThread().getName() + " принял студента");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + programmingTeacher.getDiary().toString());
                    if (programmingTeacher.getDiary().size() == 10) {
                        System.out.println("Учитель программирования закончил работать");
                        break M2;
                    }
                }
            }
        }
    }, "Учитель программирования");

    Thread teacherPhysics = new Thread(new Runnable() {

        @Override
        public void run() {
            M3:
            {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " готов к работе");
                    final int estimation = (int) (Math.random() * 10);
                    final Date dateNow = new Date();
                    final String date = formatForDateNow.format(dateNow);
                    try {
                        Thread.sleep(3000);
                        physicsTeacher.getDiary().put(classes.getPhysics().take(), new Diary(estimation, date));
                        System.out.println(Thread.currentThread().getName() + " принял студента");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + physicsTeacher.getDiary().toString());
                    if (physicsTeacher.getDiary().size() == 10) {
                        System.out.println("Учитель физики закончил работать");
                        break M3;
                    }
                }
            }
        }
    }, "Учитель физики");

    Thread teacherLiterature = new Thread(new Runnable() {

        @Override
        public void run() {
            M4:
            {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " готов к работе");
                    final int estimation = (int) (Math.random() * 10);
                    final Date dateNow = new Date();
                    final String date = formatForDateNow.format(dateNow);
                    try {
                        Thread.sleep(3000);
                        literatureTeacher.getDiary().put(classes.getLiterature().take(), new Diary(estimation, date));
                        System.out.println(Thread.currentThread().getName() + " принял студента");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + literatureTeacher.getDiary().toString());
                    if (literatureTeacher.getDiary().size() == 10) {
                        System.out.println("Учитель литературы закончил работать");
                        break M4;
                    }
                }
            }
        }
    }, "Учитель литературы");

    Thread teacherPhysicalEducation = new Thread(new Runnable() {

        @Override
        public void run() {
            M5:
            {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " готов к работе");
                    final int estimation = (int) (Math.random() * 10);
                    final Date dateNow = new Date();
                    final String date = formatForDateNow.format(dateNow);
                    try {
                        Thread.sleep(3000);
                        physicalEducationTeacher.getDiary().put(classes.getPhysicalEducation().take(), new Diary(estimation, date));
                        System.out.println(Thread.currentThread().getName() + " принял студента");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + physicalEducationTeacher.getDiary().toString());
                    if (physicalEducationTeacher.getDiary().size() == 10) {
                        System.out.println("Учитель физры закончил работать");
                        break M5;
                    }
                }
            }
        }
    }, "Учитель физкультуры");
}
