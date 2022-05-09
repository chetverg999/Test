package Zoo;

public class Snake extends Animal implements AbleToHideInSand{

    int countOfTeeth = 4;
    boolean canIHaveTail = true;

    public Snake(){

    }

    public Snake(int length, int width, String typeOfFood) {
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
        System.out.println("Ssssssss");
    }

    @Override
    public void eat() {
        System.out.println("Eat mouse");
    }
}
