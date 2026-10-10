
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int longestSubarray(int[] nums, int limit) {

        // Stores indices in decreasing order of values.
        // The front gives the maximum element in the window.
        Deque<Integer> maxDeque = new ArrayDeque<>();

        // Stores indices in increasing order of values.
        // The front gives the minimum element in the window.
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;
        int answer = 0;

        // Expand the window by moving right.
        for (int right = 0; right < nums.length; right++) {

            // Remove smaller or equal elements from the back.
            // They cannot be the maximum while nums[right] remains.
            while (!maxDeque.isEmpty()
                    && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }

            // Add the current index to the maximum deque.
            maxDeque.offerLast(right);

            // Remove greater or equal elements from the back.
            // They cannot be the minimum while nums[right] remains.
            while (!minDeque.isEmpty()
                    && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }

            // Add the current index to the minimum deque.
            minDeque.offerLast(right);

            // Shrink the window while max - min exceeds the limit.
            while ((long) nums[maxDeque.peekFirst()]
                    - nums[minDeque.peekFirst()] > limit) {

                // Remove the outgoing index if it is at the front.
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                // Move the left boundary forward.
                left++;
            }

            // The current window is valid.
            int windowLength = right - left + 1;

            // Store the longest valid window found so far.
            answer = Math.max(answer, windowLength);
        }

        return answer;
    }
}
