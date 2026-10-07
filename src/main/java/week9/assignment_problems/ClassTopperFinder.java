public class ClassTopperFinder {

    public static String findTopper(int[][] marks) {
        int topRow = 0;
        int highestTotal = Integer.MIN_VALUE;

        for (int row = 0; row < marks.length; row++) {
            int total = 0;

            for (int column = 0; column < marks[row].length; column++) {
                total += marks[row][column];
            }

            if (total > highestTotal) {
                highestTotal = total;
                topRow = row;
            }
        }

        return "(" + topRow + "," + highestTotal + ")";
    }

    public static void main(String[] args) {

        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };

        String result = findTopper(marks);

        System.out.println("Topper: " + result);
        System.out.println("Time Complexity: O(m * n)");
        System.out.println("Additional Space Complexity: O(1)");
    }
}