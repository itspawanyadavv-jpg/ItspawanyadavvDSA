import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            // If current number already exists
            // in the last k elements, we found a valid duplicate.
            if (set.contains(nums[i])) {
                return true;
            }

            // Add current number to the window.
            set.add(nums[i]);

            // Keep only the last k elements.
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}