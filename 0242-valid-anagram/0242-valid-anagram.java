
import java.util.Arrays;

class Solution {

    public boolean isAnagram(String s, String t) {

        // Different lengths cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Convert strings into character arrays
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        // Sort both arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Compare sorted arrays
        return Arrays.equals(arr1, arr2);
    }
}
