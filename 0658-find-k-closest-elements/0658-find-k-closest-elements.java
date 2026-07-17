class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0;
        int right = arr.length - k;

        // Binary search on the starting index of the window
        while (left < right) {

            int mid = left + (right - left) / 2;

            /*
             * Compare the left element leaving the window
             * with the new right element entering the window.
             */
            if (x - arr[mid] > arr[mid + k] - x) {
                // Right side is closer
                left = mid + 1;
            } else {
                // Left side is better (or tie)
                right = mid;
            }
        }

        // Build answer
        List<Integer> ans = new ArrayList<>();

        for (int i = left; i < left + k; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}