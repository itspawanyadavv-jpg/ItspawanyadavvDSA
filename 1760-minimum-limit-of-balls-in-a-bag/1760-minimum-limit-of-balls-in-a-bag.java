class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0;

        //find the largest bag size.
        for(int balls : nums){
            right = Math.max(right , balls);
        }
        //Binary search on answer

        while(left < right ){
            int mid = left + (right - left) / 2;
            if(canMake(nums , mid , maxOperations)){
                right = mid;
            }else{

                //Need a larger penality
                left = mid + 1;
            }
        }

        return left;
        
    }
     // Returns true if we can make every bag <= penalty
    private boolean canMake(int[] nums, int penalty, int maxOperations) {

        long operations = 0;

        for (int balls : nums) {

            // Number of operations needed for this bag
            operations += (balls - 1) / penalty;

            // Early exit if we already exceed the limit
            if (operations > maxOperations) {
                return false;
            }
        }

        return true;
    }
}