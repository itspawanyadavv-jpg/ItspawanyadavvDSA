class Solution {
    public int maximumSum(int[] nums) {

        int noDelete = nums[0];
        int oneDelete = 0;

        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int prevNoDelete = noDelete;

            noDelete = Math.max(nums[i], noDelete + nums[i]);

            oneDelete = Math.max(prevNoDelete,
                                 oneDelete + nums[i]);

            ans = Math.max(ans,
                    Math.max(noDelete, oneDelete));
        }

        return ans;
    }
}