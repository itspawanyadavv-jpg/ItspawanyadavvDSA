
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(1, k, n, current, result);

        return result;
    }

    private void backtrack(int start, int k, int remaining,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Found exactly k numbers with the required sum.
        if (current.size() == k && remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Cannot select more numbers or reach the target.
        if (current.size() >= k || remaining <= 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > remaining) {
                break;
            }

            current.add(i);

            backtrack(i + 1, k, remaining - i, current, result);

            // Backtrack: undo the choice.
            current.remove(current.size() - 1);
        }
    }
}
