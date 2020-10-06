public class Pyramid extends Shape3D {
    private double length;
    private double width;
    private double height;

    public Pyramid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public String getName() {
        return "pyramid";
    }

    public double getArea() {
        return (length * width) + (length * (Math.pow((Math.pow(width/2, 2) + Math.pow(height, 2)), 0.5))) + (width * (Math.pow((Math.pow(length/2, 2) + Math.pow(height, 2)), 0.5)));
    }

    public double getVolume() {
        return (length * width * height)/3;
    }
}
