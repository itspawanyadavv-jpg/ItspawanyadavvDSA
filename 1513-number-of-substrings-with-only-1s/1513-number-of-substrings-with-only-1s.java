
class Solution {
    public int numSub(String s) {

        final int MOD = 1_000_000_007;

        long count = 0;
        long answer = 0;

        for (int i = 0; i < s.length(); i++) {

            // If the current character is '1',
            // extend the consecutive run of ones.
            if (s.charAt(i) == '1') {
                count++;
            } else {
                // A zero breaks the consecutive run.
                count = 0;
            }

            // Every run of count ones contributes
            // count valid substrings ending here.
            answer = (answer + count) % MOD;
        }

        return (int) answer;
    }
}
