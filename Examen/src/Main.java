public class Main {

    static Consumer consumer = new Consumer();
    static Student student = new Student();

    public static void main(String[] args) {

        consumer.startConsumer();
        student.startStudent();
    }
}
