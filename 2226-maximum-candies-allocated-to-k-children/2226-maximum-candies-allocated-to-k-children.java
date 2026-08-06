class Solution {

    public int maximumCandies(int[] candies, long k) {

        // Minimum possible candies per child
        int left = 1;

        // Maximum possible candies per child = largest pile
        int right = 0;
        for (int pile : candies) {
            right = Math.max(right, pile);
        }

        int answer = 0;

        // Binary search on the answer
        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Check if every child can receive 'mid' candies
            if (canDistribute(candies, k, mid)) {
                answer = mid;      // Store current valid answer
                left = mid + 1;    // Try to increase candies per child
            } else {
                right = mid - 1;   // Reduce the target candies
            }
        }

        return answer;
    }

    // Returns true if we can make at least k piles,
    // each containing exactly 'target' candies.
    private boolean canDistribute(int[] candies, long k, int target) {

        long count = 0;

        for (int pile : candies) {
            count += pile / target;

            // Early exit if we've already made enough piles
            if (count >= k) {
                return true;
            }
        }

        return false;
    }
}