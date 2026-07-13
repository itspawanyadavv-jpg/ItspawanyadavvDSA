class Solution {
    public void moveZeroes(int[] nums) {

        // points where next non zero elements should be placed
        int insertPos = 0;

        //Traverse the arrays 
        for(int i = 0; i < nums.length; i++){

            //Process only non Zero elements

            if(nums[i] != 0){

                // Swap cuurent non zero elements with inser t position

                 int temp = nums[i];
                 nums[i] = nums[insertPos];
                 nums[insertPos] = temp;

                 // Move insert pos tot he next positionm 
                 insertPos++;
            }
        }
    }
}