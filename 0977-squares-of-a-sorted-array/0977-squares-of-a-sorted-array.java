class Solution {

    public int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;
        int index = n - 1;

        while (left <= right) {

            if (Math.abs(nums[left]) > Math.abs(nums[right])) {

                // Left has bigger square
                result[index] = nums[left] * nums[left];
                left++;

            } else {

                // Right has bigger square
                result[index] = nums[right] * nums[right];
                right--;
            }

            // Move to the next position in the result array
            index--;
        }

        return result;
    }
}