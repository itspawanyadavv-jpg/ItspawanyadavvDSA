class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int group = 1;
        int start = nums[0];
        

        for(int num : nums){
            if(num - start <= k){
                continue;
            }else{
                group++;
                start = num;
            }

        }
        return group;
        
    }
}