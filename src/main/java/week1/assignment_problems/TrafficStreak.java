import java.util.Scanner;

public class TrafficStreak {

    public static void findLongestStreak(String signalLog) {

        if (signalLog.length() == 0) {
            System.out.println("Signal Log is Empty");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == currentColor) {
                currentLength++;
            } else {
                currentColor = signalLog.charAt(i);
                currentLength = 1;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestColor = currentColor;
            }
        }

        System.out.println("Longest Streak Color: " + longestColor);
        System.out.println("Longest Streak Length: " + longestLength);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter traffic signal log: ");
        String signalLog = scanner.nextLine();

        findLongestStreak(signalLog);

        scanner.close();
    }
}