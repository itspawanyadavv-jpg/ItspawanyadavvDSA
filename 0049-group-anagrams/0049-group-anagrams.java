
import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        // Key: Character frequency signature
        // Value: All strings having that signature
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // Count the frequency of each character.
            int[] frequency = new int[26];

            for (char ch : str.toCharArray()) {
                frequency[ch - 'a']++;
            }

            // Convert frequency array into a unique String key.
            StringBuilder keyBuilder = new StringBuilder();

            for (int count : frequency) {
                keyBuilder.append(count).append('#');
            }

            String key = keyBuilder.toString();

            // Create a group if the key does not exist.
            map.computeIfAbsent(
                key,
                k -> new ArrayList<>()
            );

            // Add the original string to its group.
            map.get(key).add(str);
        }

        // Return all groups.
        return new ArrayList<>(map.values());
    }
}
