import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {
    @Test
    public void testBmiScoreUnderweight() {
        BodyMassIndex b = new BodyMassIndex(70, 125) {
            assertEquals(17.9, b.bmiScore());
        }
    }

    @Test
    public void testBmiScoreNormalWeight() {
        BodyMassIndex b = new BodyMassIndex(70, 160) {
            assertEquals(22.9, b.bmiScore());
        }
    }

    @Test
    public void testBmiScoreOverweight() {
        BodyMassIndex b = new BodyMassIndex(70, 175) {
            assertEquals(25.1, b.bmiScore());
        }
    }

    @Test
    public void testBmiScoreObesity() {
        BodyMassIndex b = new BodyMassIndex(70, 210) {
            assertEquals(30.1, b.bmiScore());
        }
    }

    @Test
    public void testBmiCategoryUnderweight() {
        BodyMassIndex b = new BodyMassIndex(70, 125) {
            assertEquals("Underweight", b.bmiCategory());
        }
    }

    @Test
    public void testBmiCategoryNormalWeight() {
        BodyMassIndex b = new BodyMassIndex(70, 160) {
            assertEquals("Normal weight", b.bmiCategory());
        }
    }

    @Test
    public void testBmiCategoryOverweight() {
        BodyMassIndex b = new BodyMassIndex(70, 175) {
            assertEquals("Overweight", b.bmiCategory());
        }
    }

    @Test
    public void testBmiCategoryObesity() {
        BodyMassIndex b = new BodyMassIndex(70, 210) {
            assertEquals("Obesity", b.bmiCategory());
        }
    }
}