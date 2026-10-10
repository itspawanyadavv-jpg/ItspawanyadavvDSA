
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        // Products of positive integers cannot be less than 1.
        if (k <= 1) {
            return 0;
        }

        int left = 0;
        long product = 1;
        int answer = 0;

        // Expand the window by moving right.
        for (int right = 0; right < nums.length; right++) {

            // Include the new element in the product.
            product *= nums[right];

            // Shrink while the product is invalid.
            while (product >= k) {
                product /= nums[left];
                left++;
            }

            // Count all valid subarrays ending at right.
            answer += right - left + 1;
        }

        return answer;
    }
}
