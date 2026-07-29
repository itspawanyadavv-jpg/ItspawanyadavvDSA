import java.util.*;

class Solution {

    public int minSwaps(int[] nums) {
        int n = nums.length;

        // Step 1: Create sorted copy
        Integer[] sorted = new Integer[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = nums[i];
        }

        // Step 2: Sort by digit sum, then value
        Arrays.sort(sorted, (a, b) -> {
            int sumA = digitSum(a);
            int sumB = digitSum(b);

            if (sumA != sumB)
                return sumA - sumB;

            return a - b;
        });

        // Step 3: Map value -> final index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(sorted[i], i);
        }

        // Step 4: Build destination array
        int[] destination = new int[n];

        for (int i = 0; i < n; i++) {
            destination[i] = map.get(nums[i]);
        }

        // Step 5: Count cycles
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {

            if (visited[i] || destination[i] == i)
                continue;

            int cycle = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = destination[j];
                cycle++;
            }

            swaps += cycle - 1;
        }

        return swaps;
    }

    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}