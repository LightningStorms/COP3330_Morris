public class Sphere extends Shape3D{
    private String name = "sphere";
    private double radius;

    public Sphere(double radius){
        this.radius=radius;
    }

    @Override
    public double getVolume() {
        double volume;

        volume = (4.0/3)*Math.PI*radius*radius*radius;

        return volume;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        double area;

        area = 4*Math.PI*radius*radius;

        return area;
    }
}
