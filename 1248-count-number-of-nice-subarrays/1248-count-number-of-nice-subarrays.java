
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int left = 0;
        int oddCount = 0;
        int answer = 0;
        int prefixEven = 0;

        for (int right = 0; right < nums.length; right++) {

            // Count odd numbers in the window.
            if (nums[right] % 2 != 0) {
                oddCount++;
                prefixEven = 0;
            }

            // Shrink until the window contains at most k odd numbers.
            while (oddCount > k) {
                if (nums[left] % 2 != 0) {
                    oddCount--;
                }
                left++;
            }

            // Count possible starts when the window has exactly k odds.
            while (oddCount == k && nums[left] % 2 == 0) {
                prefixEven++;
                left++;
            }

            if (oddCount == k) {
                answer += prefixEven + 1;
            }
        }

        return answer;
    }
}
