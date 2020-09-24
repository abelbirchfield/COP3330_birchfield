import java.util.ArrayList;
import java.util.Scanner;

public class App {

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
        Scanner input = new Scanner(System.in);
        System.out.print("\nWould you like to enter more information? Enter 'Y' for yes or 'N' for no: ");
        boolean returnValue = false;

        while (!returnValue) {
            String response = input.next();
            if (response.equals("Y")) {
                returnValue = true;
            } else if (response.equals("N")) {
                returnValue = false;
                break;
            } else {
                System.out.print("\tThat is not a valid response. Please enter 'Y' for yes or 'N' for no: ");
            }
        }
        return returnValue;
    }

    public static double getUserHeight() {
        Scanner input = new Scanner(System.in);
        System.out.print("What is your height (in inches)? ");
        double height = input.nextDouble();
        input.nextLine();

        while(height<=0) {
            System.out.print("\tThat is not a valid height. Please enter a positive number: ");
            height = input.nextDouble();
            input.nextLine();
        }
        return height;
    }

    public static double getUserWeight() {
        Scanner input = new Scanner(System.in);
        System.out.print("What is your weight (in pounds)? ");
        double weight = input.nextDouble();
        input.nextLine();

        while(weight<=0) {
            System.out.print("\tThat is not a valid weight. Please enter a positive number: ");
            weight = input.nextDouble();
            input.nextLine();
        }
        return weight;
    }

    public static void displayBmiInfo(BodyMassIndex bmi) {
        System.out.printf("%nBMI Score: %.1f%n", bmi.bmiScore());
        System.out.printf("BMI Category: %s%n", bmi.bmiCategory());
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        double average = 0;
        for (int i = 0; i < bmiData.size(); i++) {
            average += bmiData.get(i).bmiScore();
        }
        average /= bmiData.size();
        average = Math.floor(average*100)/100;
        System.out.printf("%nAverage BMI Score: %.2f%n", average);
    }




}
