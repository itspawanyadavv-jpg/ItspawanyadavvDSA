class Solution {

    public int singleNonDuplicate(int[] nums) {

        // Search space
        int low = 0;
        int high = nums.length - 1;

        // Binary Search
        while (low < high) {

            // Find middle index
            int mid = low + (high - low) / 2;

            // Make mid even so it always points
            // to the first element of a pair.
            if (mid % 2 == 1)
                mid--;

            // Pair is correct
            if (nums[mid] == nums[mid + 1]) {

                // Unique element lies on right side
                low = mid + 2;

            } else {

                // Pair is broken
                // Unique lies on left including mid
                high = mid;
            }
        }

        // low == high
        return nums[low];
    }
}