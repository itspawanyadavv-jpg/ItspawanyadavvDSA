
class Solution {

    public boolean isAnagram(String s, String t) {

        // Step 1: Different lengths cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Create frequency array for 26 letters
        int[] frequency = new int[26];

        // Step 3: Count characters in s
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            frequency[ch - 'a']++;
        }

        // Step 4: Subtract characters from t
        for (int i = 0; i < t.length(); i++) {

            char ch = t.charAt(i);

            frequency[ch - 'a']--;
        }

        // Step 5: Check whether all frequencies are zero
        for (int count : frequency) {

            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
