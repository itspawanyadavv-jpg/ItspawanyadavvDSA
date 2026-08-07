import java.util.Arrays;

class Solution {

    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {

        int n = nums.length;
        int m = changeIndices.length;

        int left = 1;
        int right = m;
        int answer = -1;

        // Binary Search on the answer
        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Can we finish within first 'mid' seconds?
            if (canMark(nums, changeIndices, mid, n)) {
                answer = mid;
                right = mid - 1; // Try earlier
            } else {
                left = mid + 1; // Need more time
            }
        }

        return answer;
    }

    private boolean canMark(int[] nums, int[] changeIndices, int mid, int n) {

        // last[i] = last occurrence of index i within first 'mid' seconds
        int[] last = new int[n];
        Arrays.fill(last, -1);

        // Find last occurrence
        for (int i = 0; i < mid; i++) {
            last[changeIndices[i] - 1] = i;
        }

        // Every index must appear at least once
        for (int position : last) {
            if (position == -1)
                return false;
        }

        int free = 0; // Available decrement operations

        // Simulate every second
        for (int i = 0; i < mid; i++) {

            int index = changeIndices[i] - 1;

            // Not the last occurrence
            if (last[index] != i) {

                // Use this second as a decrement
                free++;

            } else {

                // Must mark here
                if (free < nums[index])
                    return false;

                // Consume required decrements
                free -= nums[index];
            }
        }

        return true;
    }
}