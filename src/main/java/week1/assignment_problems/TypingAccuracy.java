import java.util.Scanner;

public class TypingAccuracy {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter original text: ");
        String original = scanner.nextLine();

        System.out.print("Enter typed text: ");
        String typed = scanner.nextLine();

        if (original.length() != typed.length()) {
            System.out.println("The two strings must have the same length.");
            scanner.close();
            return;
        }

        int matchedCharacters = 0;
        int firstMismatchPosition = -1;

        for (int i = 0; i < original.length(); i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i + 1;
            }
        }

        double accuracy =
                (matchedCharacters * 100.0) / original.length();

        System.out.println("Matched Characters: "
                + matchedCharacters + "/" + original.length());

        System.out.printf("Accuracy: %.2f%%%n", accuracy);

        if (firstMismatchPosition == -1) {
            System.out.println("No Mismatch Found");
        } else {
            int index = firstMismatchPosition - 1;

            System.out.println("First Mismatch Position: "
                    + firstMismatchPosition);

            System.out.println("Original Character: "
                    + original.charAt(index));

            System.out.println("Typed Character: "
                    + typed.charAt(index));
        }

        scanner.close();
    }
}