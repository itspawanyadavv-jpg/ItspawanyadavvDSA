
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(n, k, 1, current, result);

        return result;
    }

    private void backtrack(
            int n,
            int k,
            int start,
            List<Integer> current,
            List<List<Integer>> result) {

        // Save only combinations containing exactly k numbers.
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try each available number.
        for (int i = start; i <= n; i++) {

            // Choose.
            current.add(i);

            // Continue with larger numbers only.
            backtrack(n, k, i + 1, current, result);

            // Undo the choice.
            current.remove(current.size() - 1);
        }
    }
}
