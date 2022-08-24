public class Student implements Runnable {

    Status status = new Status();

    @Override
    public void run() {
        try {
            studentOnExamen();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void studentOnExamen() throws InterruptedException {

        int id = (int) (Math.random() * 100);
        int group = 8111;
        StudentInfo studentInfo = new StudentInfo(id, group); // генереация информации о студенте

        boolean math = false;  // статус сдачи того или иного экзамена, изначально ничего не сдано
        boolean programming = false;
        boolean physics = false;
        boolean literature = false;
        boolean physicalEducation = false;


        ALL:
        {
            while (true) { // ученик (поток) поочередно пытается зайти в каждую аудиторию (очередь) и сдать экзамен (передать данные в очередь)

                first:
                {
                    if ((Main.consumer.classes.getSemaphoreMath().availablePermits() == 0) || (math == true)) {
                        // проверка наличия места в очереди и статуса экзамена
                        break first; // попытаться попасть в следующую аудиторию
                    } else {
                        Main.consumer.classes.getSemaphoreMath().acquire(); // занятие места в аудитории (очереди)
                        Main.consumer.classes.getMath().put(studentInfo); // сдача экзамена (передача данных)
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName() + " сдал матешу");
                        math = true; // изменение статуса экзамена
                        Main.consumer.classes.getSemaphoreMath().release(); // выход из аудитории
                    }
                }

                second:
                {
                    if (Main.consumer.classes.getSemaphorePhysics().availablePermits() == 0 || physics == true) {
                        break second;
                    } else {
                        Main.consumer.classes.getSemaphorePhysics().acquire();
                        Main.consumer.classes.getPhysics().put(studentInfo);
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName() + " сдал физику");
                        physics = true;
                        Main.consumer.classes.getSemaphorePhysics().release();
                    }
                }

                third:
                {
                    if (Main.consumer.classes.getSemaphorePhysicalEducation().availablePermits() == 0 || physicalEducation == true) {
                        break third;
                    } else {
                        Main.consumer.classes.getSemaphorePhysicalEducation().acquire();
                        Main.consumer.classes.getPhysicalEducation().offer(studentInfo);
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName() + " сдал физру");
                        physicalEducation = true;
                        Main.consumer.classes.getSemaphorePhysicalEducation().release();
                    }
                }

                fourth:
                {
                    if (Main.consumer.classes.getSemaphoreLiterature().availablePermits() == 0 || literature == true) {
                        break fourth;
                    } else {
                        Main.consumer.classes.getSemaphoreLiterature().acquire();
                        Main.consumer.classes.getLiterature().offer(studentInfo);
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName() + " сдал литру");
                        literature = true;
                        Main.consumer.classes.getSemaphoreLiterature().release();
                    }
                }

                fifth:
                {
                    if (Main.consumer.classes.getSemaphoreProgramming().availablePermits() == 0 || programming == true) {
                        break fifth;
                    } else {
                        Main.consumer.classes.getSemaphoreProgramming().acquire();
                        Main.consumer.classes.getProgramming().offer(studentInfo);
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName() + " сдал инфу");
                        programming = true;
                        Main.consumer.classes.getSemaphoreProgramming().release();
                    }
                }

                status.status();

                System.out.println(Thread.currentThread().getName() + " " + math + " " + physicalEducation + " " + programming + " " + physics + " " + literature);
                if (programming == true && literature == true && physicalEducation == true && physics == true && math == true) {
                    break ALL; // завершение работы при наличии всех сданных экзаменов
                }
            }
        }
        status.status();
    }


}
