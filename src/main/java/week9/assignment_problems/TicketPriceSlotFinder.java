public class TicketPriceSlotFinder {

    public static int findSlot(int[] prices, int newPrice) {

        int left = 0;
        int right = prices.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (prices[mid] < newPrice) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        int[] prices = {120, 150, 200, 260};

        System.out.println("Prices: [120, 150, 200, 260]");
        System.out.println("Slot for 150: " + findSlot(prices, 150));
        System.out.println("Slot for 210: " + findSlot(prices, 210));
        System.out.println("Slot for 300: " + findSlot(prices, 300));

        System.out.println();
        System.out.println("Linear Search Time Complexity: O(n)");
        System.out.println("Binary Search Time Complexity: O(log n)");
        System.out.println("Additional Space Complexity: O(1)");
    }
}