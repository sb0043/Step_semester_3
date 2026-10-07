import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSumUnsorted {

    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int number : nums) {
            int complement = target - number;

            if (seen.contains(complement)) {
                return true;
            }

            seen.add(number);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;

        int[] nums2 = {3, 4, 6};
        int target2 = 20;

        System.out.println("Array 1: [2, 7, 11, 15]");
        System.out.println("Target: " + target1);
        System.out.println("Has Pair: " + hasPairWithSum(nums1, target1));

        System.out.println();

        System.out.println("Array 2: [3, 4, 6]");
        System.out.println("Target: " + target2);
        System.out.println("Has Pair: " + hasPairWithSum(nums2, target2));

        System.out.println();

        System.out.println("Brute Force Approach:");
        System.out.println("Time Complexity: O(n^2)");
        System.out.println("Additional Space Complexity: O(1)");

        System.out.println();

        System.out.println("Hash Set Approach:");
        System.out.println("Average Time Complexity: O(n)");
        System.out.println("Additional Space Complexity: O(n)");
    }
}