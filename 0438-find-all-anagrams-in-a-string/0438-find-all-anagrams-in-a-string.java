
import java.util.*;

class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        // Edge case: pattern is longer than source.
        if (m > n) {
            return result;
        }

        // Frequency arrays for 26 lowercase letters.
        int[] target = new int[26];
        int[] window = new int[26];

        // Step 1: Count characters in p.
        for (int i = 0; i < m; i++) {
            target[p.charAt(i) - 'a']++;
        }

        // Step 2: Build the first window.
        for (int i = 0; i < m; i++) {
            window[s.charAt(i) - 'a']++;
        }

        // Step 3: Check the first window.
        if (Arrays.equals(target, window)) {
            result.add(0);
        }

        // Step 4: Slide the window.
        for (int right = m; right < n; right++) {

            // Remove the outgoing character.
            char outgoing = s.charAt(right - m);
            window[outgoing - 'a']--;

            // Add the incoming character.
            char incoming = s.charAt(right);
            window[incoming - 'a']++;

            // Calculate the current window's start.
            int left = right - m + 1;

            // Check whether the current window is an anagram.
            if (Arrays.equals(target, window)) {
                result.add(left);
            }
        }

        return result;
    }
}
