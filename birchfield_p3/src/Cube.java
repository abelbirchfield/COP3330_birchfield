public class Cube extends Shape3D {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    public String getName() {
        return "cube";
    }

    public double getArea() {
        return 6 * side * side;
    }

    public double getVolume() {
        return Math.pow(side, 3);
    }
}
