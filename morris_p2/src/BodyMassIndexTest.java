import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    @Test
    public static void testTest(){
        BodyMassIndex bmi = new BodyMassIndex(68, 100);

        double answer = bmi.getHeight();

        assertEquals(68,answer);
    }

    @Test
    public void testBMICalculationUnderweight(){
        BodyMassIndex bmi = new BodyMassIndex(68, 100);

        double answer = bmi.getBMI();

        assertEquals(15.203287, answer);
    }

    @Test
    public void testBMICalculationCategoryUnderweight(){
        BodyMassIndex bmi = new BodyMassIndex(68, 100);

        String answer = bmi.getCategory();

        assertEquals("Underweight", answer);
    }

    @Test
    public void testBMICalculationNormal(){
        BodyMassIndex bmi = new BodyMassIndex(68, 150);

        double answer = bmi.getBMI();

        assertEquals(22.804931, answer);
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

        assertEquals(26.605753, answer);
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

        assertEquals(30.406574, answer);
    }

    @Test
    public  void testBMICalculationCategoryObese(){
        BodyMassIndex bmi = new BodyMassIndex(68, 200);

        String answer = bmi.getCategory();

        assertEquals("Obese", answer);
    }

}

