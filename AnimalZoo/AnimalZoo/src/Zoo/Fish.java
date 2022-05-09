package Zoo;

public class Fish extends Animal implements AbleToHideInSand {

    int countOfTeeth = 0;
    boolean canIHaveTail = true;

    public Fish(){

    }

    public Fish(int length, int width, String typeOfFood) {
        this.length = length;
        this.width = width;
        this.typeOfFood = typeOfFood;
    }

    @Override
    public void hideInSand() {
        System.out.println("you cant see me now");
    }

    @Override
    public void sound() {
        System.out.println("...");
    }

    @Override
    public void eat() {
        System.out.println("Eat dry food");
    }
}
