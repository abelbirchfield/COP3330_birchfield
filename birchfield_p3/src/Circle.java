public class Circle extends Shape2D {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public String getName() {
        return "circle";
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
