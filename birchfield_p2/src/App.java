import java.util.ArrayList;
import java.util.Scanner;

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

//        displayBmiStatistics(bmiData);
    }

    public static boolean moreInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nWould you like to enter more information? Enter 'Y' for yes or 'N' for no: ");
        if (input.next().equals("Y")) {
            return true;
        } else {
            return false;
        }
    }

    public static double getUserHeight() {
        Scanner input = new Scanner(System.in);
        System.out.print("What is your height (in inches)? ");
        double height = input.nextDouble();
        input.nextLine();
        return height;
    }

    public static double getUserWeight() {
        Scanner input = new Scanner(System.in);
        System.out.print("What is your weight (in pounds)? ");
        double weight = input.nextDouble();
        input.nextLine();
        return weight;
    }

    public static void displayBmiInfo(BodyMassIndex bmi) {
        System.out.printf("%.1f%n", bmi.bmiScore());
        System.out.printf("%s", bmi.bmiCategory());
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {

    }




}
