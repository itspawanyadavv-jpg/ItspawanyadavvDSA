import java.util.*;

class Solution {
    public int maxSumMinProduct(int[] nums) {

        int n = nums.length;

        // ------------------------------------------------
        // 1. Prefix Sum
        // prefix[i] = sum of nums[0 ... i-1]
        // ------------------------------------------------
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // Stack stores indices.
        // Values corresponding to these indices are
        // maintained in increasing order.
        Stack<Integer> stack = new Stack<>();

        long ans = 0;

        // ------------------------------------------------
        // 2. Process every element
        // ------------------------------------------------
        for (int i = 0; i <= n; i++) {

            // When i == n, we use a virtual value of -1.
            // This forces all remaining elements in the
            // stack to be processed.
            long current = (i == n) ? -1 : nums[i];

            // Current element is smaller than stack top.
            // Therefore, we found the right boundary for
            // the element at stack.peek().
            while (!stack.isEmpty() &&
                   nums[stack.peek()] >= current) {

                int j = stack.pop();

                // After popping j, the new stack top is
                // the previous smaller element.
                int left = stack.isEmpty() ? -1 : stack.peek();

                // The current index i is the next smaller
                // element on the right.
                int right = i;

                // Range:
                // left + 1 ... right - 1
                //
                // Sum = prefix[right] - prefix[left + 1]
                long sum = prefix[right] - prefix[left + 1];

                // nums[j] is the minimum of this range.
                long minProduct = (long) nums[j] * sum;

                // Keep the maximum answer.
                ans = Math.max(ans, minProduct);
            }

            // Don't push the virtual index n.
            if (i < n) {
                stack.push(i);
            }
        }

        // Take modulo only AFTER finding the maximum.
        return (int) (ans % 1_000_000_007);
    }
}