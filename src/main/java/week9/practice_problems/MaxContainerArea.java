public class MaxContainerArea {

    public static int maxContainerArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);

            int area = width * height;

            if (area > maxArea) {
                maxArea = area;
            }

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = maxContainerArea(heights);

        System.out.println("Maximum Container Area: " + result);
        System.out.println();
        System.out.println("Brute Force Time Complexity: O(n^2)");
        System.out.println("Brute Force Additional Space: O(1)");
        System.out.println("Two Pointer Time Complexity: O(n)");
        System.out.println("Two Pointer Additional Space: O(1)");
    }
}