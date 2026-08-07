import java.util.Arrays;

class Solution {

    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);
        int n = nums.length;

        // Prefix sum
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int answer = 1;

        // Try every element as the target value
        for (int i = 0; i < n; i++) {

            int low = 0;
            int high = i;
            int bestLeft = i;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                int len = i - mid + 1;

                long sum = prefix[i + 1] - prefix[mid];

                long cost = (long) nums[i] * len - sum;

                if (cost <= k) {
                    bestLeft = mid;
                    high = mid - 1;   // Try to include more elements
                } else {
                    low = mid + 1;
                }
            }

            answer = Math.max(answer, i - bestLeft + 1);
        }

        return answer;
    }
}