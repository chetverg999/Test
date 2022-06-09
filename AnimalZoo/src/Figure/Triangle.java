package Figure;

public class Triangle extends Figure{

    private double length;
    private double width;
    private double x;
    private double y;
    private double h;

    public Triangle() {
    }

    public Triangle(double length, double width, double x, double y, double length1, double width1, double x1, double y1, double h) {
        super(length, width, x, y);
        this.length = length1;
        this.width = width1;
        this.x = x1;
        this.y = y1;
        this.h = h;
    }

    @Override
    public void square() {
        System.out.println("Вычисляем площадь треугольника");
    }

    @Override
    public void perimeter() {
        System.out.println("Вычисляем периметр треугольника");
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

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }
}
