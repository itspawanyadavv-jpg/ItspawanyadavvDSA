
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {

        // Step 1: Put equal numbers next to each other.
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        // used[i] tells us whether index i is in current.
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, current, result);

        return result;
    }

    private void backtrack(
            int[] nums,
            boolean[] used,
            List<Integer> current,
            List<List<Integer>> result) {

        // Step 2: A complete permutation has been formed.
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Step 3: Try each possible next element.
        for (int i = 0; i < nums.length; i++) {

            // This index is already in the current permutation.
            if (used[i]) {
                continue;
            }

            // Skip duplicate choices at the same recursion level.
            if (i > 0
                    && nums[i] == nums[i - 1]
                    && !used[i - 1]) {
                continue;
            }

            // Choose the number.
            used[i] = true;
            current.add(nums[i]);

            // Fill the next position.
            backtrack(nums, used, current, result);

            // Undo the choice.
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
