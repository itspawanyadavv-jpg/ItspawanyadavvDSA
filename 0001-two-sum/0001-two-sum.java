import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Stores: number -> index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array once
        for (int i = 0; i < nums.length; i++) {

            // Calculate the number we need
            int complement = target - nums[i];

            // If we've already seen the complement,
            // we've found the answer.
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Store the current number and its index  
            map.put(nums[i], i);
        }

        // Problem guarantees one solution,
        // but this keeps the compiler happy.
        return new int[] {};
    }
}     