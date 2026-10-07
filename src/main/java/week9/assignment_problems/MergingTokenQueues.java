import java.util.Arrays;

public class MergingTokenQueues {

    public static int[] mergeTokens(int[] counterA, int[] counterB) {
        int[] merged = new int[counterA.length + counterB.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < counterA.length && j < counterB.length) {
            if (counterA[i] <= counterB[j]) {
                merged[k] = counterA[i];
                i++;
            } else {
                merged[k] = counterB[j];
                j++;
            }
            k++;
        }

        while (i < counterA.length) {
            merged[k] = counterA[i];
            i++;
            k++;
        }

        while (j < counterB.length) {
            merged[k] = counterB[j];
            j++;
            k++;
        }

        return merged;
    }

    public static void main(String[] args) {

        int[] counterA = {3, 8, 15, 20};
        int[] counterB = {5, 8, 12};

        int[] result1 = mergeTokens(counterA, counterB);

        System.out.println("Counter A: " + Arrays.toString(counterA));
        System.out.println("Counter B: " + Arrays.toString(counterB));
        System.out.println("Merged Queue: " + Arrays.toString(result1));

        System.out.println();

        int[] empty = {};
        int[] counterC = {4, 9};

        int[] result2 = mergeTokens(empty, counterC);

        System.out.println("Empty Queue: " + Arrays.toString(empty));
        System.out.println("Counter C: " + Arrays.toString(counterC));
        System.out.println("Merged Queue: " + Arrays.toString(result2));

        System.out.println();

        System.out.println("Merge Time Complexity: O(m + n)");
        System.out.println("Output Space Complexity: O(m + n)");
        System.out.println("Sorting After Concatenation: O((m + n) log(m + n))");
    }
}