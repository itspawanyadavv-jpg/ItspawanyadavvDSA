class Solution {

    public int maxVowels(String s, int k) {

        int vowelCount = 0;
        int maxVowels = 0;

        // Build the first window of size k
        for (int i = 0; i < k; i++) {

            if (isVowel(s.charAt(i))) {
                vowelCount++;
            }
        }

        // First window is our initial maximum
        maxVowels = vowelCount;

        // Slide the window
        for (int i = k; i < s.length(); i++) {

            // Remove the character leaving the window
            if (isVowel(s.charAt(i - k))) {
                vowelCount--;
            }

            // Add the character entering the window
            if (isVowel(s.charAt(i))) {
                vowelCount++;
            }

            // Update maximum
            maxVowels = Math.max(maxVowels, vowelCount);
        }

        return maxVowels;
    }

    private boolean isVowel(char c) {
        return c == 'a' ||
               c == 'e' ||
               c == 'i' ||
               c == 'o' ||
               c == 'u';
    }
}