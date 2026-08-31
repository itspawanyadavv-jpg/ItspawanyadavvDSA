import java.util.Stack;

class Solution {

    public boolean isValid(String s) {

        // Stack stores opening brackets
        Stack<Character> stack = new Stack<>();

        // Traverse the string from left to right
        for (char ch : s.toCharArray()) {

            // If we see an opening bracket,
            // store it for future matching.
            if (ch == '(' || ch == '[' || ch == '{') {

                stack.push(ch);

            } else {

                // A closing bracket needs an opening
                // bracket to match with.
                if (stack.isEmpty()) {
                    return false;
                }

                // Get the most recently opened bracket.
                char top = stack.pop();

                // Check whether the brackets match.
                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) {

                    return false;
                }
            }
        }

        // All brackets must have been matched.
        // Therefore, the stack must be empty.
        return stack.isEmpty();
    }
}