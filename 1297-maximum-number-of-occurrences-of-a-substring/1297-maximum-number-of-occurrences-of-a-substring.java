class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        HashMap<String, Integer> map = new HashMap<>();

        int answer = 0;

        // Only check substrings of length minSize
        for (int i = 0; i <= s.length() - minSize; i++) {

            int[] freq = new int[26];
            int unique = 0;

            // Build the current substring
            for (int j = i; j < i + minSize; j++) {

                int index = s.charAt(j) - 'a';

                if (freq[index] == 0) {
                    unique++;
                }

                freq[index]++;
            }

            // Check unique-character condition
            if (unique <= maxLetters) {

                String substring =
                        s.substring(i, i + minSize);

                int count =
                        map.getOrDefault(substring, 0) + 1;

                map.put(substring, count);

                answer = Math.max(answer, count);
            }
        }

        return answer;
    }
}