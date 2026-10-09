
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {

        Set<Integer> seen = new HashSet<>();

        int left = 0;
        int sum = 0;
        int maxScore = 0;

        for (int right = 0; right < nums.length; right++) {

            // Remove elements until nums[right] is unique.
            while (seen.contains(nums[right])) {
                seen.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            // Add the new unique element.
            seen.add(nums[right]);
            sum += nums[right];

            // Record the best score.
            maxScore = Math.max(maxScore, sum);
        }

        return maxScore;
    }
}
