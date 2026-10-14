
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        generate(nums, 0, result);

        return result;
    }

    private void generate(
            int[] nums,
            int start,
            List<List<Integer>> result) {

        // All positions have been fixed.
        if (start == nums.length) {
            List<Integer> permutation = new ArrayList<>();

            for (int num : nums) {
                permutation.add(num);
            }

            result.add(permutation);
            return;
        }

        // Try each remaining number at position start.
        for (int i = start; i < nums.length; i++) {

            swap(nums, start, i);

            // Generate permutations of the remaining positions.
            generate(nums, start + 1, result);

            // Restore the array for the next choice.
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
