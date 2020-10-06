public class Cube extends Shape3D {
    private String name = "cube";
    private double side;

    public Cube(double side){
        this.side = side;
    }

    @Override
    public double getVolume() {
        double volume;

        volume = side*side*side;

        return volume;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        double area;

        area = 6*side*side;

        return area;
    }
}
