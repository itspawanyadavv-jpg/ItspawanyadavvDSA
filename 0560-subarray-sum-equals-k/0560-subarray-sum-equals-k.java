class Solution {
    public int subarraySum(int[] nums, int k) {

        // Stores: Prefix Sum -> Frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 exists once before the array starts
        map.put(0, 1);

        int currSum = 0;
        int count = 0;

        for (int num : nums) {

            // Update running prefix sum
            currSum += num;

            // If (currSum - k) exists, then there are
            // that many subarrays ending here with sum = k
            if (map.containsKey(currSum - k)) {
                count += map.get(currSum - k);
            }

            // Store the current prefix sum
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}