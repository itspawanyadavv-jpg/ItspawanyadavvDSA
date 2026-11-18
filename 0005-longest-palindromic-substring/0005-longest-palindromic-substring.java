
class Solution {

    public String longestPalindrome(String s) {

        int n = s.length();

        int maxLength = 0;
        int startIndex = 0;

        for (int i = 0; i < n; i++) {

            // Case 1: Odd-length palindrome.
            int oddLength = expandAroundCenter(s, i, i);

            if (oddLength > maxLength) {

                maxLength = oddLength;

                // Calculate starting index.
                startIndex = i - oddLength / 2;
            }

            // Case 2: Even-length palindrome.
            int evenLength = expandAroundCenter(s, i, i + 1);

            if (evenLength > maxLength) {

                maxLength = evenLength;

                // Calculate starting index.
                startIndex = i - evenLength / 2 + 1;
            }
        }

        return s.substring(startIndex, startIndex + maxLength);
    }

    private int expandAroundCenter(String s, int left, int right) {

        // Expand while characters match.
        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        // Return the length of the palindrome.
        return right - left - 1;
    }
}
