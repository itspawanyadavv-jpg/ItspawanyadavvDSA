class Solution {
    public int longestValidParentheses(String s) {

        int left = 0;
        int right = 0;
        int max = 0;

        // First pass: left -> right
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            // We have a valid substring
            if (left == right) {
                max = Math.max(max, left * 2);
            }

            // Too many ')' -> invalid
            else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        // Reset counters for second pass
        left = 0;
        right = 0;

        // Second pass: right -> left
        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            // We have a valid substring
            if (left == right) {
                max = Math.max(max, left * 2);
            }

            // Too many '(' -> invalid
            else if (left > right) {
                left = 0;
                right = 0;
            }
        }

        return max;
    }
}