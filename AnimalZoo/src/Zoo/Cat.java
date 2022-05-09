package Zoo;

public class Cat extends Animal implements AbleToRun {

    int countOfTeeth = 30;
    boolean canIHaveTail = true;

    public Cat(){

    }

    public Cat(int length, int width, String typeOfFood) {
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
        System.out.println("Meow");
    }

    @Override
    public void eat() {
        System.out.println("Eat fish");
    }
}
