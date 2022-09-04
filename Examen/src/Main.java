public class Main {

    static Consumer consumer = new Consumer();
    static Producer student = new Producer();

    public static void main(String[] args) {

        consumer.startConsumer();
        student.startStudent();
    }
}
