class Solution {
    public String removeDuplicates(String s, int k) {

        Deque<int[]> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {

            // Same character as the previous group
            if (!stack.isEmpty() && stack.peekLast()[0] == ch) {

                // Increase its consecutive count
                stack.peekLast()[1]++;

                // Remove the group when count reaches k
                if (stack.peekLast()[1] == k) {
                    stack.removeLast();
                }

            } else {

                // Start a new group
                stack.addLast(new int[]{ch, 1});
            }
        }

        // Build the final string
        StringBuilder result = new StringBuilder();

        for (int[] group : stack) {

            char ch = (char) group[0];
            int count = group[1];

            while (count > 0) {
                result.append(ch);
                count--;
            }
        }

        return result.toString();
    }
}