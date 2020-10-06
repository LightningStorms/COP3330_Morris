public class Circle extends Shape2D{
    private String name = "circle";
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        double area;

        area = Math.PI*radius*radius;

        return area;
    }
}
