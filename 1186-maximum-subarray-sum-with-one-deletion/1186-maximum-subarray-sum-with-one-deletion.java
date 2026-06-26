class Solution {
    public int maximumSum(int[] nums) {
        int noDel = nums[0];
        int oneDel = 0;
        int ans = nums[0];

        for(int i = 1; i < nums.length; i++){
            int prevNoDel = noDel;

            noDel = Math.max(nums[i], noDel + nums[i]);
            oneDel = Math.max(prevNoDel , oneDel + nums[i]);

            ans= Math.max(ans, Math.max(noDel, oneDel));

        }
        return ans;
        
    }
}