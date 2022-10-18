public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Listener listener = new Listener();
        listener.show();
        Initializator initializator = new Initializator();
        Person person = new Person();
        initializator.initialization(person, Person.class);
        System.out.println(person.toString());
    }
}