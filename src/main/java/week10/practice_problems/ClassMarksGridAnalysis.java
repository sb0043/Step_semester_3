package week10.practice_problems;

import java.util.Scanner;

public class ClassMarksGridAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = new String[3];
        int[][] marks = new int[3][3];
        int[] totals = new int[3];

        for (int i = 0; i < 3; i++) {
            names[i] = sc.next();
            for (int j = 0; j < 3; j++) {
                marks[i][j] = sc.nextInt();
                totals[i] += marks[i][j];
            }
        }

        System.out.print("Totals ");
        for (int i = 0; i < 3; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(names[i] + " " + totals[i]);
        }
        System.out.println();

        System.out.print("averages ");
        for (int j = 0; j < 3; j++) {
            double sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += marks[i][j];
            }
            if (j > 0) System.out.print(", ");
            System.out.printf("%.2f", sum / 3);
        }
        System.out.println();

        int topper = 0;
        for (int i = 1; i < 3; i++) {
            if (totals[i] > totals[topper]) {
                topper = i;
            }
        }

        System.out.println("topper " + names[topper]
                + " (" + totals[topper] + ")");

        sc.close();
    }
}