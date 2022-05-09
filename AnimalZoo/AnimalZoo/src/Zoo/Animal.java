package Zoo;

abstract class Animal {

    int length;
    int width;
    String typeOfFood;

    public Animal() {
    }

    public Animal(int length, int width, String typeOfFood) {
        this.length = length;
        this.width = width;
        this.typeOfFood = typeOfFood;
    }

    public void breathe() {
        System.out.println("Breaaaaathe");
    }

    public void fart() {
        System.out.println("Faaaart");
    }

    public abstract void sound();

    public abstract void eat();
}
