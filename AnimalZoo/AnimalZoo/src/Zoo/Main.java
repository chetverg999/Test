package Zoo;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog(15, 16, "predator");
        Cat cat = new Cat(18, 13, "predator");
        Fish fish = new Fish(9,3,"herbivore");
        Snake snake = new Snake(5,1,"predator");

        dog.sound();
        dog.eat();
        dog.breathe();
        dog.fart();
        dog.run();

        System.out.println("--------");

        fish.sound();
        fish.eat();
        fish.breathe();
        fish.fart();
        fish.hideInSand();
    }
}


