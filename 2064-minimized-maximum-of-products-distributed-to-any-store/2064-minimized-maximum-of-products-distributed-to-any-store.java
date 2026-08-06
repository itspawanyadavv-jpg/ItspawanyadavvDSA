class Solution {

    public int minimizedMaximum(int n, int[] quantities) {

        // Minimum possible maximum products per store
        int left = 1;

        // Maximum possible maximum products per store
        // (One store gets all products of the largest type)
        int right = 0;

        // Find the maximum quantity
        for (int quantity : quantities) {
            right = Math.max(right, quantity);
        }

        // Binary Search on the answer
        while (left < right) {

            // Candidate maximum products allowed in one store
            int mid = left + (right - left) / 2;

            // Check if this maximum is possible
            if (canDistribute(quantities, n, mid)) {

                // mid works.
                // Try to find an even smaller maximum.
                right = mid;

            } else {

                // mid is too small.
                // Increase the allowed maximum.
                left = mid + 1;
            }
        }

        // Smallest possible maximum products per store
        return left;
    }

    // Returns true if all products can be distributed
    // using at most n stores when each store
    // can hold at most maxProducts products.
    private boolean canDistribute(int[] quantities, int n, int maxProducts) {

        int storesNeeded = 0;

        // Check every product type
        for (int quantity : quantities) {

            // Ceiling division:
            // Number of stores needed for this product type
            //
            // Example:
            // quantity = 11
            // maxProducts = 3
            //
            // Stores needed = ceil(11 / 3) = 4
            storesNeeded += (quantity + maxProducts - 1) / maxProducts;

            // If we need more than n stores,
            // this maximum is not possible.
            if (storesNeeded > n) {
                return false;
            }
        }

        // Successfully distributed all products
        // within n stores.
        return true;
    }
}