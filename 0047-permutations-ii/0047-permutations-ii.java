import java.util.*;

class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        generate(nums, 0, all);

        // Remove duplicate permutations afterward.
        Set<List<Integer>> unique = new LinkedHashSet<>(all);

        return new ArrayList<>(unique);
    }

    private void generate(
            int[] nums,
            int index,
            List<List<Integer>> result) {

        // Every position has been fixed.
        if (index == nums.length) {
            List<Integer> permutation = new ArrayList<>();

            for (int num : nums) {
                permutation.add(num);
            }

            result.add(permutation);
            return;
        }

        // Try every remaining element at this position.
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);

            generate(nums, index + 1, result);

            // Undo the choice before trying another.
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}