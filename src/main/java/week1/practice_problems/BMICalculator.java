import java.util.Scanner;

public class BMICalculator {

    public static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {

        System.out.printf("%-10s %-10s %-10s %-10s %-15s%n",
                "Person", "Height", "Weight", "BMI", "Status");

        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {

            double bmi = weights[i] / (heights[i] * heights[i]);

            System.out.printf("%-10d %-10.2f %-10.2f %-10.2f %-15s%n",
                    i + 1,
                    heights[i],
                    weights[i],
                    bmi,
                    getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] heights = new double[10];
        double[] weights = new double[10];

        for (int i = 0; i < 10; i++) {

            System.out.print("Enter height in meters for Person " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();

            System.out.print("Enter weight in kg for Person " + (i + 1) + ": ");
            weights[i] = scanner.nextDouble();
        }

        System.out.println();
        System.out.println("Wellness Report");
        System.out.println("================");

        printWellnessReport(heights, weights);

        scanner.close();
    }
}