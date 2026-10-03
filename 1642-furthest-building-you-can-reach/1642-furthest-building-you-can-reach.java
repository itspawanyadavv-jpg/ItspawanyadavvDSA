import java.util.*;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        // Min heap containing climbs currently
        // being covered by ladders.
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {

            // Calculate the upward climb.
            int climb = heights[i + 1] - heights[i];

            // If the next building is lower or equal,
            // we don't need bricks or a ladder.
            if (climb <= 0) {
                continue;
            }

            // Temporarily use a ladder for this climb.
            pq.offer(climb);

            // If we have assigned ladders to more climbs
            // than the number of ladders available,
            // convert the smallest climb to bricks.
            if (pq.size() > ladders) {

                int smallestClimb = pq.poll();

                bricks -= smallestClimb;
            }

            // If we don't have enough bricks,
            // we cannot reach the next building.
            if (bricks < 0) {
                return i;
            }
        }

        // We successfully crossed every building.
        return heights.length - 1;
    }
}