
class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int answer = 0;

        for (int right = 0; right < s.length(); right++) {

            // Convert the character into an index from 0 to 25.
            int index = s.charAt(right) - 'A';

            // Add the current character to the window.
            freq[index]++;

            // Track the highest frequency seen during expansion.
            maxFreq = Math.max(maxFreq, freq[index]);

            // Shrink if more than k replacements are required.
            while ((right - left + 1) - maxFreq > k) {

                int leftIndex = s.charAt(left) - 'A';

                // Remove the leftmost character from the window.
                freq[leftIndex]--;

                left++;
            }

            // Update the longest achievable length.
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}
