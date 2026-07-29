import java.util.*;

class Solution {

    public List<String> topKFrequent(String[] words, int k) {

        // Step 1: Count frequency of every word
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Step 2: Store all unique words in a list
        List<String> list = new ArrayList<>(map.keySet());

        // Step 3: Sort according to problem requirements
        Collections.sort(list, (a, b) -> {

            // Higher frequency should come first
            if (!map.get(a).equals(map.get(b))) {
                return map.get(b) - map.get(a);
            }

            // If frequency is same,
            // alphabetically smaller word comes first
            return a.compareTo(b);
        });

        // Step 4: Return only first k words
        return list.subList(0, k);
    }
}