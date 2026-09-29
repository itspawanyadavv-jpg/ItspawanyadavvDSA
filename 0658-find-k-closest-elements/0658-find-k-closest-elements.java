import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int n = arr.length;

        int left = 0;
        int right = n - k;

        // Find the starting index of the best window
        while (left < right) {

            int mid = left + (right - left) / 2;

            // If the right candidate is closer,
            // move the window to the right.
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // left is the starting index of the answer
        List<Integer> ans = new ArrayList<>();

        for (int i = left; i < left + k; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}