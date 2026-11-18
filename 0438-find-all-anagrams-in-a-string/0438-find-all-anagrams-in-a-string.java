
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        // Frequency of characters in p.
        int[] target = new int[26];

        for (char ch : p.toCharArray()) {
            target[ch - 'a']++;
        }

        // Generate every substring of length m.
        for (int i = 0; i <= n - m; i++) {

            int[] current = new int[26];

            // Calculate substring frequency.
            for (int j = i; j < i + m; j++) {
                current[s.charAt(j) - 'a']++;
            }

            // Compare frequencies.
            if (Arrays.equals(target, current)) {
                result.add(i);
            }
        }

        return result;
    }
}
