import java.util.Arrays;

class Solution {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        // Binary search requires a sorted array
        Arrays.sort(arr2);

        int count = 0;

        // Check every element of arr1
        for (int x : arr1) {

            // First index having value >= (x-d)
            int idx = lowerBound(arr2, x - d);

            // If no element exists OR candidate exceeds x+d
            if (idx == arr2.length || arr2[idx] > x + d) {
                count++;
            }
        }

        return count;
    }

    // Standard Lower Bound
    private int lowerBound(int[] arr, int target) {

        int low = 0;
        int high = arr.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}