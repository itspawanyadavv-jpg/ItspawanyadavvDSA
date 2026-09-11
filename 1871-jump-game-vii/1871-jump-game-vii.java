class Solution {

    public boolean canReach(String s, int minJump, int maxJump) {

        int n = s.length();

        // reachable[i] = true means index i can be reached
        boolean[] reachable = new boolean[n];

        // We start at index 0
        reachable[0] = true;

        // Number of reachable indexes inside the current window
        int reachableCount = 0;

        for (int i = 1; i < n; i++) {

            // Index that has just entered the valid jump range
            int addIndex = i - minJump;

            if (addIndex >= 0 && reachable[addIndex]) {
                reachableCount++;
            }

            // Index that is no longer inside the valid jump range
            int removeIndex = i - maxJump - 1;

            if (removeIndex >= 0 && reachable[removeIndex]) {
                reachableCount--;
            }

            // Current index must be '0'
            // and there must be at least one reachable
            // previous index in the valid range
            if (s.charAt(i) == '0' && reachableCount > 0) {
                reachable[i] = true;
            }
        }

        return reachable[n - 1];
    }
}