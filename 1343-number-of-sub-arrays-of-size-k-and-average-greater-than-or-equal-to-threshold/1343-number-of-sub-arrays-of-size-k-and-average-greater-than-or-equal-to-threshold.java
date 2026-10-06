class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int requiredSum = k * threshold;
        int windowSum = 0;
        int count = 0;

        // First window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        // Check first window
        if (windowSum >= requiredSum) {
            count++;
        }

        // Slide the window
        for (int i = k; i < arr.length; i++) {

            windowSum -= arr[i - k]; // remove old
            windowSum += arr[i];     // add new

            if (windowSum >= requiredSum) {
                count++;
            }
        }

        return count;
    }
}