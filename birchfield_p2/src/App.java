import java.util.ArrayList;
public class App {

//    DO NOT EDIT MAIN METHOD!!!!!
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static boolean moreInput() {

    }

    public static double getUserHeight() {

    }

    public static double getUserWeight() {

    }

    public static void displayBmiInfo(BodyMassIndex bmi) {

    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {

    }




}
