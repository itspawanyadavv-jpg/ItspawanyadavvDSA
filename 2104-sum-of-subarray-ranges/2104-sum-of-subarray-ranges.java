class Solution {

    public long subArrayRanges(int[] nums) {
        return sumOfMaximums(nums) - sumOfMinimums(nums);
    }

    private long sumOfMaximums(int[] nums) {
        int n = nums.length;

        long sum = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Find previous greater element
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        stack.clear();

        // Find next greater or equal element
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                   nums[stack.peek()] < nums[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty() ? n : stack.peek();

            stack.push(i);
        }

        // Calculate contribution
        for (int i = 0; i < n; i++) {

            long leftChoices = i - left[i];
            long rightChoices = right[i] - i;

            sum += (long) nums[i] * leftChoices * rightChoices;
        }

        return sum;
    }

    private long sumOfMinimums(int[] nums) {
        int n = nums.length;

        long sum = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Find previous smaller element
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        stack.clear();

        // Find next smaller or equal element
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                   nums[stack.peek()] > nums[i]) {
                stack.pop();
            }

            right[i] = stack.isEmpty() ? n : stack.peek();

            stack.push(i);
        }

        // Calculate contribution
        for (int i = 0; i < n; i++) {

            long leftChoices = i - left[i];
            long rightChoices = right[i] - i;

            sum += (long) nums[i] * leftChoices * rightChoices;
        }

        return sum;
    }
}