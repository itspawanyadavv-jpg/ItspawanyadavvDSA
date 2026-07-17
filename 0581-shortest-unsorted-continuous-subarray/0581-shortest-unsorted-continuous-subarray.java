class Solution {
    public int findUnsortedSubarray(int[] nums) {

        int n = nums.length;

        int left = -1;
        int right = -1;

        // Pass 1: Find the right boundary
        int maxSeen = nums[0];
        for (int i = 1; i < n; i++) {
            maxSeen = Math.max(maxSeen, nums[i]);

            // Current element is smaller than a previous element
            if (nums[i] < maxSeen) {
                right = i;
            }
        }

        // Already sorted
        if (right == -1) {
            return 0;
        }

        // Pass 2: Find the left boundary
        int minSeen = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minSeen = Math.min(minSeen, nums[i]);

            // Current element is larger than a later element
            if (nums[i] > minSeen) {
                left = i;
            }
        }

        return right - left + 1;
    }
}