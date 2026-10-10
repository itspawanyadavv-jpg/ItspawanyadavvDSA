
class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        // Expand the window by moving right.
        for (int right = 0; right < nums.length; right++) {

            // Add the current element to the window sum.
            sum += nums[right];

            // While the sum meets the target,
            // try to make the window shorter.
            while (sum >= target) {

                int windowLength = right - left + 1;

                // Keep the shortest valid length.
                minLength = Math.min(minLength, windowLength);

                // Remove the leftmost element.
                sum -= nums[left];

                // Move the left boundary forward.
                left++;
            }
        }

        // Return 0 if no valid subarray was found.
        return minLength == Integer.MAX_VALUE
                ? 0
                : minLength;
    }
}
