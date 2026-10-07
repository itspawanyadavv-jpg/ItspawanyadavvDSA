class Solution {
    public int minSwaps(int[] nums) {

        int n = nums.length;

        // Count total number of 1s
        int k = 0;

        for (int num : nums) {
            if (num == 1) {
                k++;
            }
        }

        // No need to swap
        if (k <= 1 || k == n) {
            return 0;
        }

        int left = 0;
        int ones = 0;
        int max = 0;

        // Circular sliding window
        for (int i = 0; i < n + k - 1; i++) {

            // Add current element
            if (nums[i % n] == 1) {
                ones++;
            }

            // If window becomes bigger than k
            if (i - left + 1 > k) {

                if (nums[left % n] == 1) {
                    ones--;
                }

                left++;
            }

            // Window has exactly k elements
            if (i - left + 1 == k) {
                max = Math.max(max, ones);
            }
        }

        return k - max;
    }
}