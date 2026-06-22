class Solution {
    public int[][] constructProductMatrix(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] productES = new int[n][m];

        long prefixProduct = 1;

        // Prefix pass
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                productES[i][j] = (int) (prefixProduct % 12345);

                prefixProduct =
                        (prefixProduct * grid[i][j]) % 12345;
            }
        }

        long suffixProduct = 1;

        // Suffix pass
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                productES[i][j] =
                        (int) ((productES[i][j] * suffixProduct) % 12345);

                suffixProduct =
                        (suffixProduct * grid[i][j]) % 12345;
            }
        }

        return productES;
    }
}