import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class Classes { // создание аудиторий для сдачи экзаменов (очередей)

    private final BlockingQueue<StudentInfo> math = new ArrayBlockingQueue<>(3);
    private final BlockingQueue<StudentInfo> programming = new ArrayBlockingQueue<>(3);
    private final BlockingQueue<StudentInfo> physics = new ArrayBlockingQueue<>(3);
    private final BlockingQueue<StudentInfo> literature = new ArrayBlockingQueue<>(3);
    private final BlockingQueue<StudentInfo> physicalEducation = new ArrayBlockingQueue<>(3);

    private Semaphore semaphoreMath = new Semaphore(3);
    private Semaphore semaphoreProgramming = new Semaphore(3);
    private Semaphore semaphorePhysics = new Semaphore(3);
    private Semaphore semaphoreLiterature = new Semaphore(3);
    private Semaphore semaphorePhysicalEducation = new Semaphore(3);

    public BlockingQueue<StudentInfo> getMath() {
        return math;
    }

    public BlockingQueue<StudentInfo> getProgramming() {
        return programming;
    }

    public BlockingQueue<StudentInfo> getPhysics() {
        return physics;
    }

    public BlockingQueue<StudentInfo> getLiterature() {
        return literature;
    }

    public BlockingQueue<StudentInfo> getPhysicalEducation() {
        return physicalEducation;
    }

    public Semaphore getSemaphoreMath() {
        return semaphoreMath;
    }

    public void setSemaphoreMath(Semaphore semaphoreMath) {
        this.semaphoreMath = semaphoreMath;
    }

    public Semaphore getSemaphoreProgramming() {
        return semaphoreProgramming;
    }

    public void setSemaphoreProgramming(Semaphore semaphoreProgramming) {
        this.semaphoreProgramming = semaphoreProgramming;
    }

    public Semaphore getSemaphorePhysics() {
        return semaphorePhysics;
    }

    public void setSemaphorePhysics(Semaphore semaphorePhysics) {
        this.semaphorePhysics = semaphorePhysics;
    }

    public Semaphore getSemaphoreLiterature() {
        return semaphoreLiterature;
    }

    public void setSemaphoreLiterature(Semaphore semaphoreLiterature) {
        this.semaphoreLiterature = semaphoreLiterature;
    }

    public Semaphore getSemaphorePhysicalEducation() {
        return semaphorePhysicalEducation;
    }

    public void setSemaphorePhysicalEducation(Semaphore semaphorePhysicalEducation) {
        this.semaphorePhysicalEducation = semaphorePhysicalEducation;
    }
}
