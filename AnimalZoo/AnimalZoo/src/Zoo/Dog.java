package Zoo;

public class Dog extends Animal implements AbleToRun{

    int countOfTeeth = 42;
    boolean canIHaveTail = true;

    public Dog(){

    }

    public Dog(int length, int width, String typeOfFood) {
        this.length = length;
        this.width = width;
        this.typeOfFood = typeOfFood;
    }

    @Override
    public void run() {
        System.out.println("Im run now");
    }

    @Override
    public void sound() {
        System.out.println("Bark");
    }

    @Override
    public void eat() {
        System.out.println("Eat bones");
    }
}
