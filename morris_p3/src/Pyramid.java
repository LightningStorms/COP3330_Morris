public class Pyramid  extends Shape3D{
    private String name = "pyramid";
    private double height;
    private double width;
    private double length;

    public Pyramid(double length, double width, double height){
        this.length=length;
        this.width=width;
        this.height=height;
    }

    @Override
    public double getVolume() {
        double volume;

        volume = (1.0/3)*length*width*height;

        return volume;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        double area;

        area = width*length
                + Math.sqrt((length*length)/4+(height*height))*width
                + Math.sqrt((width*width)/4+(height*height))*length;

        return area;
    }
}
