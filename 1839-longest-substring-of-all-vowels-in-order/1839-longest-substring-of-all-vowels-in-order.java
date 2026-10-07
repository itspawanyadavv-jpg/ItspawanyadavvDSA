class Solution {
    public int longestBeautifulSubstring(String word) {

        int currentLength = 1;
        int uniqueVowels = 1;
        int answer = 0;

        for (int i = 1; i < word.length(); i++) {

            // If the order goes backward, restart
            if (word.charAt(i) < word.charAt(i - 1)) {

                currentLength = 1;
                uniqueVowels = 1;
            }

            // If we moved to a new vowel
            else if (word.charAt(i) > word.charAt(i - 1)) {

                uniqueVowels++;
                currentLength++;
            }

            // Same vowel
            else {

                currentLength++;
            }

            // Beautiful substring must contain all 5 vowels
            if (uniqueVowels == 5) {
                answer = Math.max(answer, currentLength);
            }
        }

        return answer;
    }
} 