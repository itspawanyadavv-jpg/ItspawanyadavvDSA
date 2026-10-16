
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // Sort equal values next to each other.
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(nums, 0, current, result);

        return result;
    }

    private void backtrack(
            int[] nums,
            int start,
            List<Integer> current,
            List<List<Integer>> result) {

        // Every current selection is a valid subset.
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            // Skip duplicate choices at this recursion level.
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose.
            current.add(nums[i]);

            // Explore choices after this index.
            backtrack(nums, i + 1, current, result);

            // Undo the choice.
            current.remove(current.size() - 1);
        }
    }
}
