package Figure;

public class Rectangle extends Figure{

    private double length;
    private double width;
    private double x;
    private double y;

    public Rectangle() {
    }

    public Rectangle(double length, double width, double x, double y, double length1, double width1, double x1, double y1) {
        super(length, width, x, y);
        this.length = length1;
        this.width = width1;
        this.x = x1;
        this.y = y1;
    }

    @Override
    public void square() {
        System.out.println("Вычисляем площадь прямоугольника");
    }

    @Override
    public void perimeter() {
        System.out.println("Вычисляем периметр прямоугольника");
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
