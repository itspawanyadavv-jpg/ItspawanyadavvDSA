
class Solution {
    public int countDays(int days, int[][] meetings) {

        // Sort meetings by start day
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        long occupied = 0;

        int start = meetings[0][0];
        int end = meetings[0][1];

        for (int i = 1; i < meetings.length; i++) {

            // Overlapping meetings
            if (meetings[i][0] <= end) {
                end = Math.max(end, meetings[i][1]);
            }
            // Non-overlapping meeting
            else {
                occupied += (long) end - start + 1;

                start = meetings[i][0];
                end = meetings[i][1];
            }
        }

        // Add the last merged interval
        occupied += (long) end - start + 1;

        return (int) (days - occupied);
    }
}