
import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(candidates, target, 0, current, result);

        return result;
    }

    private void backtrack(
            int[] candidates,
            int remaining,
            int start,
            List<Integer> current,
            List<List<Integer>> result) {

        // We found a valid combination.
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicate values at the same recursion level.
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Array is sorted; later numbers are also too large.
            if (candidates[i] > remaining) {
                break;
            }

            // Choose.
            current.add(candidates[i]);

            // Explore. Each index can be used only once.
            backtrack(
                    candidates,
                    remaining - candidates[i],
                    i + 1,
                    current,
                    result
            );

            // Undo.
            current.remove(current.size() - 1);
        }
    }
}
