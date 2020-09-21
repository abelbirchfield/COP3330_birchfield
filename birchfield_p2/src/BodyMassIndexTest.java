import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {
    @Test
    public void testBmiScore() {
        BodyMassIndex b = new BodyMassIndex(70, 175) {
            double answer = b.bmiScore();
            assertEquals(25.10, Math.floor(answer*100)/100);
        }
    }

    @Test
    public void testBmiCategory() {
        BodyMassIndex b = new BodyMassIndex(70, 175) {
            String answer = b.bmiCategory();
            assertEquals("Overweight", answer);
        }
    }

}