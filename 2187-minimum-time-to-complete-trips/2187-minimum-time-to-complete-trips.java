class Solution {

    public long minimumTime(int[] time, int totalTrips) {

        long left = 1;

        int minTime = Integer.MAX_VALUE;

        // Find the fastest driver
        for (int t : time) {
            minTime = Math.min(minTime, t);
        }

        long right = (long) minTime * totalTrips;

        while (left < right) {

            long mid = left + (right - left) / 2;

            if (canComplete(time, totalTrips, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canComplete(int[] time, int totalTrips, long minutes) {

        long trips = 0;

        for (int t : time) {

            trips += minutes / t;

            // Early exit
            if (trips >= totalTrips)
                return true;
        }

        return false;
    }
}