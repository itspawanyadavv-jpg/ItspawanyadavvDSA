
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {

        int left = 0;
        int wC = 0;
        int answer = 0;

        for (int right = 0; right < s.length(); right++) {

            // Cost of changing s[right] to t[right]
            int cost = Math.abs(
                s.charAt(right) - t.charAt(right)
            );

            // Add the cost of the new character
            wC += cost;

            // Shrink the window while its cost exceeds the budget
            while (wC > maxCost) {
                wC -= Math.abs(
                    s.charAt(left) - t.charAt(left)
                );
                left++;
            }

            // Calculate the length of the valid window
            int wL = right - left + 1;

            // Update the maximum length
            answer = Math.max(answer, wL);
        }

        return answer;
    }
}
