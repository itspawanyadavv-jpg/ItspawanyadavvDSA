import java.util.Arrays;

class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        int groups = 1;
        int start = nums[0]; // minimum of current group

        for (int i = 1; i < nums.length; i++) {
            // Current number cannot fit in the current group
            if (nums[i] - start > k) {
                groups++;
                start = nums[i]; // Start a new group
            }
        }

        return groups;
    }
}