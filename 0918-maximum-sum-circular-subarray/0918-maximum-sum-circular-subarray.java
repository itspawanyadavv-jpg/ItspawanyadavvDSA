class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int total = nums[0]; 

        int maxEnding = nums[0];
        int maxSum = nums[0];

        int minEnding = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            total += nums[i];

            // Kadane for Maximum Sum
            maxEnding = Math.max(nums[i], maxEnding + nums[i]);
            maxSum = Math.max(maxSum, maxEnding);

            // Kadane for Minimum Sum
            minEnding = Math.min(nums[i], minEnding + nums[i]);
            minSum = Math.min(minSum, minEnding);
        }

        // If all elements are negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Maximum of normal subarray and circular subarray
        return Math.max(maxSum, total - minSum);
    }
}