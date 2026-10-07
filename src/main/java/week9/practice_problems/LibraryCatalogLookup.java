public class LibraryCatalogLookup {

    public static String findBook(String[][] catalog, String targetIsbn) {
        int low = 0;
        int high = catalog.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int comparison = catalog[mid][0].compareTo(targetIsbn);

            if (comparison == 0) {
                return catalog[mid][1];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {

        String[][] catalog = {
            {"0001112223", "Introduction to Java"},
            {"0002223334", "Data Structures"},
            {"0003334445", "Classic Mythology"},
            {"0004445556", "Object Oriented Programming"},
            {"0005556667", "Computer Networks"}
        };

        String target1 = "0003334445";
        String target2 = "0009998887";

        String result1 = findBook(catalog, target1);
        String result2 = findBook(catalog, target2);

        System.out.println("Search ISBN: " + target1);
        System.out.println("Result: " + result1);

        System.out.println();

        System.out.println("Search ISBN: " + target2);
        System.out.println("Result: " + result2);

        System.out.println();
        System.out.println("Time Complexity: O(log n)");
        System.out.println("Additional Space Complexity: O(1)");
    }
}