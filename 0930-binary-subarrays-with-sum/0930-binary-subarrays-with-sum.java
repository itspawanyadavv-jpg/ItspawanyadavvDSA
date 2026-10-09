
class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int limit) {

        // No non-empty subarray can have a negative sum.
        if (limit < 0) {
            return 0;
        }

        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            // Expand the window.
            sum += nums[right];

            // Shrink until the sum is within the limit.
            while (sum > limit) {
                sum -= nums[left];
                left++;
            }

            // Count all valid subarrays ending at right.
            count += right - left + 1;
        }

        return count;
    }
}
