class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        long sum = 0;
        long max = 0;

        int distinct = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            sum += num;

            if (map.getOrDefault(num, 0) == 0) {
                distinct++;
            }

            map.put(num, map.getOrDefault(num, 0) + 1);

            if (i - left + 1 > k) {

                int old = nums[left];

                sum -= old;

                map.put(old, map.get(old) - 1);

                if (map.get(old) == 0) {
                    distinct--;
                }

                left++;
            }

            if (i - left + 1 == k && distinct == k) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}