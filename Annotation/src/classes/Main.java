package classes;

import classes.Initializator;
import classes.Listener;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Listener listener = new Listener();
        listener.show();
        Initializator initializator = new Initializator();
        Person person = new Person();
        initializator.initialization(person);
        System.out.println(person.toString());
        Person person2 = new Person();
        PersonInitializator personInitializator = new PersonInitializator();
        personInitializator.initializator(person2);
        System.out.println(person2.toString());
    }
}