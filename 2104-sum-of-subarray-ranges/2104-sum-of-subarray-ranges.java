class Solution {
    public long subArrayRanges(int[] nums) {
        return getSum(nums, true) - getSum(nums, false);
    }

    private long getSum(int[] nums, boolean maximum) {
        int n = nums.length;
        long sum = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {

            while (!stack.isEmpty() &&
                   (i == n ||
                   (maximum
                       ? nums[stack.peek()] < nums[i]
                       : nums[stack.peek()] > nums[i]))) {

                int mid = stack.pop();

                int left = stack.isEmpty() ? -1 : stack.peek();

                int right = i;

                long leftCount = mid - left;
                long rightCount = right - mid;

                sum += (long) nums[mid] * leftCount * rightCount;
            }

            stack.push(i);
        }

        return sum;
    }
}