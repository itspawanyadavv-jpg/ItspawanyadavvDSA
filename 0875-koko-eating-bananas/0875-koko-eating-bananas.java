class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int maxPile = 0;

        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int left = 1;
        int right = maxPile;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canFinish(int[] piles, int h, int speed) {

        long hours = 0;

        for (int pile : piles) {

            hours += (pile + speed - 1) / speed;

            if (hours > h)
                return false;
        }

        return true;
    }
}