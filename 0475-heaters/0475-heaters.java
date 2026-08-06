import java.util.Arrays;

class Solution {

    public int findRadius(int[] houses, int[] heaters) {

        // Sort heaters so binary search can be used
        Arrays.sort(heaters);

        int radius = 0;

        // Process every house
        for (int house : houses) {

            // Binary search for current house
            int index = Arrays.binarySearch(heaters, house);

            // If heater exists exactly at the house
            if (index >= 0) {
                continue;
            }

            // Convert negative result into insertion position
            index = -(index + 1);

            // Distance from left heater
            int leftDistance = Integer.MAX_VALUE;
            if (index > 0) {
                leftDistance = house - heaters[index - 1];
            }

            // Distance from right heater
            int rightDistance = Integer.MAX_VALUE;
            if (index < heaters.length) {
                rightDistance = heaters[index] - house;
            }

            // Nearest heater distance
            int nearestDistance = Math.min(leftDistance, rightDistance);

            // Update minimum required radius
            radius = Math.max(radius, nearestDistance);
        }

        return radius;
    }
}