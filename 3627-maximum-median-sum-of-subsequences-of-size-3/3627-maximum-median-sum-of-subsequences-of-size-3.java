class Solution {

    public long maximumMedianSum(int[] nums) {

        // Step 1: Sort the array in ascending order
        Arrays.sort(nums);

        int n = nums.length;

        // Number of groups we need
        int groups = n / 3;

        long answer = 0;

        // Start from the second largest element
        int index = n - 2;

        // Pick exactly one median for each group
        for (int i = 0; i < groups; i++) {

            // Add current median
            answer = answer + nums[index];

            // Skip one element (the group's largest)
            index = index - 2;
        }

        return answer;
    }
}