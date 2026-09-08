import java.util.*;

class Solution {

    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        long ans = 0;

        // Stack stores indices.
        // It maintains an increasing monotonic stack.
        Stack<Integer> stack = new Stack<>();

        // We go till i == n to force all remaining
        // elements in the stack to be processed.
        for (int i = 0; i <= n; i++) {

            // Pop while:
            // 1. We reached the end of the array, OR
            // 2. Current element is smaller than stack top.
            //
            // This means arr[mid] has found its
            // "next smaller" element.
            while (!stack.isEmpty() &&
                   (i == n || arr[stack.peek()] > arr[i])) {

                // Element whose contribution we are calculating
                int mid = stack.pop();

                // Previous smaller element's index
                // If there is none, use -1.
                int left = stack.isEmpty() ? -1 : stack.peek();

                // Current index is the next smaller element
                int right = i;

                // Number of choices for the left boundary
                long leftCount = mid - left;

                // Number of choices for the right boundary
                long rightCount = right - mid;

                // Number of subarrays where arr[mid]
                // is the minimum:
                //
                // leftCount × rightCount
                //
                // Contribution:
                // arr[mid] × leftCount × rightCount
                ans += (long) arr[mid]
                        * leftCount
                        * rightCount;

                // Keep answer within the required modulo
                ans %= 1000000007;
            }

            // Don't push i when i == n,
            // because arr[n] does not exist.
            if (i < n) {
                stack.push(i);
            }
        }

        return (int) ans;
    }
}