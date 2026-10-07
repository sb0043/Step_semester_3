import java.util.HashMap;
import java.util.Map;

public class MostPopularCanteenOrder {

    public static String mostPopular(String[] orders) {

        Map<String, Integer> frequency = new HashMap<>();

        for (String order : orders) {
            frequency.put(order, frequency.getOrDefault(order, 0) + 1);
        }

        String popularItem = orders[0];
        int maxCount = frequency.get(orders[0]);

        for (String order : orders) {
            int count = frequency.get(order);

            if (count > maxCount) {
                maxCount = count;
                popularItem = order;
            }
        }

        return "(" + popularItem + "," + maxCount + ")";
    }

    public static void main(String[] args) {

        String[] orders1 = {
            "dosa", "idli", "vada", "dosa",
            "idli", "dosa", "tea"
        };

        String[] orders2 = {
            "tea", "coffee", "coffee", "tea"
        };

        System.out.println("Orders 1 Result: " + mostPopular(orders1));
        System.out.println("Orders 2 Result: " + mostPopular(orders2));

        System.out.println();
        System.out.println("Hash Map Time Complexity: O(n)");
        System.out.println("Hash Map Additional Space Complexity: O(k)");
        System.out.println("Repeated Scan Approach: O(n^2)");
    }
}