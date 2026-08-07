import java.util.Arrays;

class Solution {

    public int maximumTastiness(int[] price, int k) {

        Arrays.sort(price);

        int low = 0;
        int high = price[price.length - 1] - price[0];
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canPick(price, k, mid)) {
                ans = mid;          // mid is possible
                low = mid + 1;      // try larger tastiness
            } else {
                high = mid - 1;     // reduce tastiness
            }
        }

        return ans;
    }

    // Can we pick k candies such that adjacent chosen candies
    // differ by at least 'gap'?
    private boolean canPick(int[] price, int k, int gap) {

        int count = 1;          // choose first candy
        int last = price[0];

        for (int i = 1; i < price.length; i++) {

            if (price[i] - last >= gap) {
                count++;
                last = price[i];

                if (count == k)
                    return true;
            }
        }

        return false;
    }
}