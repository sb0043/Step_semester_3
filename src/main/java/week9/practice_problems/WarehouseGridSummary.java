public class WarehouseGridSummary {

    public static String warehouseSummary(int[][] grid) {
        int totalItems = 0;
        int maxItems = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxColumn = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {

                totalItems += grid[row][column];

                if (grid[row][column] > maxItems) {
                    maxItems = grid[row][column];
                    maxRow = row;
                    maxColumn = column;
                }
            }
        }

        return "(" + totalItems + ",(" + maxRow + "," + maxColumn + "))";
    }

    public static void main(String[] args) {

        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        String result = warehouseSummary(grid);

        System.out.println("Warehouse Summary: " + result);
        System.out.println("Time Complexity: O(m * n)");
        System.out.println("Additional Space Complexity: O(1)");
    }
}