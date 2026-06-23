class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        HashMap<Integer, Long> map = new HashMap<>();

        long prefix = 0;
        long ans = Long.MIN_VALUE;

        for (int num : nums) {

            // Check if a good subarray can end here
            if (map.containsKey(num - k)) {
                ans = Math.max(ans, prefix + num - map.get(num - k));
            }

            if (map.containsKey(num + k)) {
                ans = Math.max(ans, prefix + num - map.get(num + k));
            }

            // Store minimum prefix before this value
            map.put(num, Math.min(
                    map.getOrDefault(num, Long.MAX_VALUE),
                    prefix
            ));

            prefix += num;
        }

        return ans == Long.MIN_VALUE ? 0 : ans;
    }
}