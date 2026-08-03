class Solution {

    public int arrangeCoins(int n) {

        long left = 1;
        long right = n;
        long answer = 0;

        while (left <= right) {

            // Middle number of rows to test
            long mid = left + (right - left) / 2;

            // Coins needed to build 'mid' rows
            long coinsNeeded = mid * (mid + 1) / 2;

            // If exactly equal, we found the answer
            if (coinsNeeded == n) {
                return (int) mid;
            }

            // We can build 'mid' rows
            if (coinsNeeded < n) {
                answer = mid;       // Save current valid answer
                left = mid + 1;     // Try building more rows
            } else {
                // Too many coins needed
                right = mid - 1;
            }
        }

        return (int) answer;
    }
}