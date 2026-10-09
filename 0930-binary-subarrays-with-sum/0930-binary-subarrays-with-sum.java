
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int n = nums.length;

        for (int left = 0; left < n; left++) {
            int sum = 0;

            for (int right = left; right < n; right++) {
                sum += nums[right];

                if (sum == goal) {
                    count++;
                }
            }
        }

        return count;
    }
}
