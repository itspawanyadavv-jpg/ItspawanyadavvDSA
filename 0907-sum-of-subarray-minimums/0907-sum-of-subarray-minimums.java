class Solution {

    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        long ans = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {

            while (!stack.isEmpty() &&
                   (i == n || arr[stack.peek()] > arr[i])) {

                int mid = stack.pop();

                int left = stack.isEmpty() ? -1 : stack.peek();

                int right = i;

                long leftCount = mid - left;
                long rightCount = right - mid;

                ans += (long) arr[mid]
                        * leftCount
                        * rightCount;

                ans %= 1000000007;
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return (int) ans;
    }
}