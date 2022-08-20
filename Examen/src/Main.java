public class Main {
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        Student student = new Student();
        consumer.startConsumer();
        student.startStudent();
    }
}
