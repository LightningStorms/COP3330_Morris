public class Square extends Shape2D {
    private String name = "square";
    private double side;

    public Square(double side){
        this.side = side;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        double Area;

        Area = side*side;

        return Area;
    }
}
