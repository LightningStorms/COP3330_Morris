public class Triangle extends Shape2D{
    private String name = "triangle";
    private double base;
    private double height;

    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        double area;

        area = 0.5*base*height;

        return area;
    }
}
