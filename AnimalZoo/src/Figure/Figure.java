package Figure;

abstract class Figure {

    double length;
    double width;
    double x;
    double y;

    public Figure() {

    }

    public Figure(double length, double width, double x, double y) {
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public void moveX() {
        System.out.println("Сдвигаем по оси Х");
    }

    public void moveY() {
        System.out.println("Сдвигаем по оси У");
    }

    public abstract void square();
    public abstract void perimeter();

}
