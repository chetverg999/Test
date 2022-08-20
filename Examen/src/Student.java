public class Student implements Runnable {
    Consumer consumer = new Consumer();

    public void studentOnExamen() throws InterruptedException {

        int id = (int) Math.random() * 100;
        int group = 8111;
        StudentInfo studentInfo = new StudentInfo(id, group);

        consumer.classes.getSemaphoreMath().acquire();
        consumer.classes.getMath().put(studentInfo);
        System.out.println(Thread.currentThread().getName() + " сдал матешу");
        consumer.classes.getSemaphoreMath().release();

        consumer.classes.getSemaphorePhysics().acquire();
        consumer.classes.getPhysics().put(studentInfo);
        System.out.println(Thread.currentThread().getName() + " сдал физику");
        consumer.classes.getSemaphorePhysics().release();

        consumer.classes.getSemaphorePhysicalEducation().acquire();
        consumer.classes.getPhysicalEducation().offer(studentInfo);
        System.out.println(Thread.currentThread().getName() + " сдал физру");
        consumer.classes.getSemaphorePhysicalEducation().release();

        consumer.classes.getSemaphoreLiterature().acquire();
        consumer.classes.getLiterature().offer(studentInfo);
        System.out.println(Thread.currentThread().getName() + " сдал литру");
        consumer.classes.getSemaphoreLiterature().release();

        consumer.classes.getSemaphoreProgramming().acquire();
        consumer.classes.getProgramming().offer(studentInfo);
        System.out.println(Thread.currentThread().getName() + " сдал инфу");
        consumer.classes.getSemaphoreProgramming().release();
    }

    @Override
    public void run() {
        try {
            studentOnExamen();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void startStudent() {
        Thread student1 = new Thread(this, "Студент 1");
        Thread student2 = new Thread(this,"Студент 2");
        Thread student3 = new Thread(this,"Студент 3");
        Thread student4 = new Thread(this,"Студент 4");
        Thread student5 = new Thread(this,"Студент 5");
        Thread student6 = new Thread(this,"Студент 6");
        Thread student7 = new Thread(this,"Студент 7");
        Thread student8 = new Thread(this,"Студент 8");
        Thread student9 = new Thread(this,"Студент 9");
        Thread student10 = new Thread(this,"Студент 10");

        student1.start();
        student2.start();
        student3.start();
        student4.start();
        student5.start();
        student6.start();
        student7.start();
        student8.start();
        student9.start();
        student10.start();
    }
}
