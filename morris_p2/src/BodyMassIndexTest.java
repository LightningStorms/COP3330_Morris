import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    @Test
    public void testGetHeight(){
        BodyMassIndex bmi = new BodyMassIndex(68, 100);

        double answer = bmi.getHeight();

        assertEquals(68,answer);
    }

    @Test
    public void testGetWeight(){
        BodyMassIndex bmi = new BodyMassIndex(68, 100);

        double answer = bmi.getWeight();

        assertEquals(100,answer);
    }

    //test getBMI, and through that the findBMI method which calculates the BMI
    @Test
    public void testBMICalculationUnderweight(){
        BodyMassIndex bmi = new BodyMassIndex(68, 100);

        double answer = bmi.getBMI();
        double math_answer = 703*bmi.getWeight()/(bmi.getHeight()*bmi.getHeight());

        assertEquals(math_answer, answer);
    }

    //test getCategory, and through that the findBodyMassType method which gets the BMI category
    @Test
    public void testBMICalculationCategoryUnderweight(){
        BodyMassIndex bmi = new BodyMassIndex(68, 100);

        String answer = bmi.getCategory();

        assertEquals("Underweight", answer);
    }

    /* Below are further tests of each category along the lines of the above mentions
    * there is one of each type above for each of the four BMI categories */

    @Test
    public void testBMICalculationNormal(){
        BodyMassIndex bmi = new BodyMassIndex(68, 150);

        double answer = bmi.getBMI();
        double math_answer = 703*bmi.getWeight()/(bmi.getHeight()*bmi.getHeight());

        assertEquals(math_answer, answer);
    }

    @Test
    public void testBMICalculationCategoryNormal(){
        BodyMassIndex bmi = new BodyMassIndex(68, 150);

        String answer = bmi.getCategory();

        assertEquals("Normal", answer);
    }

    @Test
    public void testBMICalculationOverweight(){
        BodyMassIndex bmi = new BodyMassIndex(68, 175);

        double answer = bmi.getBMI();
        double math_answer = 703*bmi.getWeight()/(bmi.getHeight()*bmi.getHeight());

        assertEquals(math_answer, answer);
    }

    @Test
    public void testBMICalculationCategoryOverweight(){
        BodyMassIndex bmi = new BodyMassIndex(68, 175);

        String answer = bmi.getCategory();

        assertEquals("Overweight", answer);
    }

    @Test
    public  void testBMICalculationObese(){
        BodyMassIndex bmi = new BodyMassIndex(68, 200);

        double answer = bmi.getBMI();
        double math_answer = 703*bmi.getWeight()/(bmi.getHeight()*bmi.getHeight());

        assertEquals(math_answer, answer);
    }

    @Test
    public  void testBMICalculationCategoryObese(){
        BodyMassIndex bmi = new BodyMassIndex(68, 200);

        String answer = bmi.getCategory();

        assertEquals("Obese", answer);
    }

}

