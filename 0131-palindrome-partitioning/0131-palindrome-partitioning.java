
import java.util.*;

class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        // There are n - 1 gaps where we can cut.
        generatePartitions(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void generatePartitions(
            String s,
            int start,
            List<String> current,
            List<List<String>> result) {

        // The entire string has been partitioned.
        if (start == s.length()) {

            // Check whether every piece is a palindrome.
            if (isValidPartition(current)) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        // Try every possible ending position.
        for (int end = start; end < s.length(); end++) {

            String piece = s.substring(start, end + 1);
            current.add(piece);

            generatePartitions(s, end + 1, current, result);

            // Undo the choice before trying another ending.
            current.remove(current.size() - 1);
        }
    }

    private boolean isValidPartition(List<String> parts) {
        for (String part : parts) {
            if (!isPalindrome(part)) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(String part) {
        int left = 0;
        int right = part.length() - 1;

        while (left < right) {
            if (part.charAt(left) != part.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
