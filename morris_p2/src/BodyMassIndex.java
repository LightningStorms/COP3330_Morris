
public class BodyMassIndex {
    private double height;
    private double weight;
    public double BMI;
    public String category;

    public BodyMassIndex(double height, double weight){
        this.height=height;
        this.weight=weight;
        BMI=findBMI(height, weight);
        category=findBodyMassType(BMI);
    }

    public double getBMI(){
        return BMI;
    }

    public double getHeight(){
        return height;
    }

    public double getWeight(){
        return weight;
    }

    public String getCategory(){
        return category;
    }

    public double findBMI(double height, double weight){
        double BMI;

        BMI = 703*weight/(height*height);

        return BMI;
    }

    public String findBodyMassType(double BMI){
        String Category;

        if (BMI < 18.5) {
            Category = "Underweight";
            return Category;
        } else if (BMI <= 24.9) {
            Category = "Normal";
            return Category;
        } else if (BMI <= 29.9) {
            Category = "Overweight";
            return Category;
        }
        else {
            Category = "Obese";
            return Category;
        }
    }
}

