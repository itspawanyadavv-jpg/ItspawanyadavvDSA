class Solution {

    public int findDuplicate(int[] nums) {

        // Phase 1: Find the intersection point inside the cycle
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];           // Move one step
            fast = nums[nums[fast]];     // Move two steps
        } while (slow != fast);

        // Phase 2: Find the entrance of the cycle
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow]; 
            fast = nums[fast];
        }

        // The entrance is the duplicate number
        return slow;
    }
}