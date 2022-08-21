public class Student implements Runnable {
    public void studentOnExamen() throws InterruptedException {

        boolean math = false;
        boolean programming = false;
        boolean physics = false;
        boolean literature = false;
        boolean physicalEducation = false;

        while (true) {

            int id = (int) Math.random() * 100;
            int group = 8111;
            StudentInfo studentInfo = new StudentInfo(id, group);

            if ((Main.consumer.classes.getSemaphoreMath().availablePermits() == 0) || (math == true)) {
                continue;
            } else {
                Main.consumer.classes.getSemaphoreMath().acquire();
                Main.consumer.classes.getMath().put(studentInfo);
                System.out.println(Thread.currentThread().getName() + " сдал матешу");
                math = true;
                Main.consumer.classes.getSemaphoreMath().release();
            }

            if (Main.consumer.classes.getSemaphorePhysics().availablePermits() == 0 || physics == true) {
                continue;
            } else {
                Main.consumer.classes.getSemaphorePhysics().acquire();
                Main.consumer.classes.getPhysics().put(studentInfo);
                System.out.println(Thread.currentThread().getName() + " сдал физику");
                physics = true;
                Main.consumer.classes.getSemaphorePhysics().release();
            }

            if (Main.consumer.classes.getSemaphorePhysicalEducation().availablePermits() == 0 || physicalEducation == true) {
                continue;
            } else {
                Main.consumer.classes.getSemaphorePhysicalEducation().acquire();
                Main.consumer.classes.getPhysicalEducation().offer(studentInfo);
                System.out.println(Thread.currentThread().getName() + " сдал физру");
                physicalEducation = true;
                Main.consumer.classes.getSemaphorePhysicalEducation().release();
            }

            if (Main.consumer.classes.getSemaphoreLiterature().availablePermits() == 0 || literature == true) {
                continue;
            } else {
                Main.consumer.classes.getSemaphoreLiterature().acquire();
                Main.consumer.classes.getLiterature().offer(studentInfo);
                System.out.println(Thread.currentThread().getName() + " сдал литру");
                literature = true;
                Main.consumer.classes.getSemaphoreLiterature().release();
            }

            if (Main.consumer.classes.getSemaphoreProgramming().availablePermits() == 0 || programming == true) {
                continue;
            } else {
                Main.consumer.classes.getSemaphoreProgramming().acquire();
                Main.consumer.classes.getProgramming().offer(studentInfo);
                System.out.println(Thread.currentThread().getName() + " сдал инфу");
                programming = true;
                Main.consumer.classes.getSemaphoreProgramming().release();
            }

            System.out.println(Thread.currentThread().getName() + math + physicalEducation + programming + physics + literature);
        }
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
        Thread student2 = new Thread(this, "Студент 2");
        Thread student3 = new Thread(this, "Студент 3");
        Thread student4 = new Thread(this, "Студент 4");
        Thread student5 = new Thread(this, "Студент 5");
        Thread student6 = new Thread(this, "Студент 6");
        Thread student7 = new Thread(this, "Студент 7");
        Thread student8 = new Thread(this, "Студент 8");
        Thread student9 = new Thread(this, "Студент 9");
        Thread student10 = new Thread(this, "Студент 10");

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
