class Solution {
    public int[][] divideArray(int[] nums, int k) {

        //Sort the array
        Arrays.sort(nums);

        int groups = nums.length / 3;
        int[][] result = new int[groups][3];
        int index = 0;

        //process every 3 consecutive numbers;
        for(int i = 0; i < nums.length; i += 3){

            // Check if the group satisfies the condition 
            if(nums[i+2] - nums[i] > k){
                return new int[0][0];
            }

            //Store the froup;
            result[index][0] = nums[i] ;
            result[index][1] = nums[i+1];
            result[index][2] =nums[i+2];

            index++;
        }

        return result;

        
    }
}