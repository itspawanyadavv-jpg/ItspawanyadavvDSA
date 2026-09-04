import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        // Stack stores all asteroids that are still alive
        Stack<Integer> stack = new Stack<>();

        // Process asteroids from left to right
        for (int current : asteroids) {

            // We use this to remember whether current asteroid exploded
            boolean destroyed = false;

            /*
             * Collision can happen only when:
             *
             * stack.peek() > 0  → previous asteroid is moving right
             * current < 0       → current asteroid is moving left
             *
             * Example:
             *     5 →  ← 3
             */
            while (!stack.isEmpty() &&
                   stack.peek() > 0 &&
                   current < 0) {

                // Get the asteroid at the top of the stack
                int top = stack.peek();

                // Case 1:
                // Top asteroid is smaller, so it explodes.
                if (top < -current) {

                    stack.pop();

                    /*
                     * Current asteroid is still alive.
                     * It may collide with the asteroid before 'top'.
                     *
                     * So go back to the while condition.
                     */
                    continue;
                }

                // Case 2:
                // Both asteroids have the same size.
                else if (top == -current) {

                    // Top asteroid explodes
                    stack.pop();

                    // Current asteroid also explodes
                    destroyed = true;

                    // No more collision for current asteroid
                    break;
                }

                // Case 3:
                // Top asteroid is bigger.
                else {

                    // Current asteroid explodes
                    destroyed = true;

                    // Stop checking collisions for current
                    break;
                }
            }

            /*
             * If current asteroid was NOT destroyed,
             * put it into the stack.
             */
            if (!destroyed) {
                stack.push(current);
            }
        }

        // Convert Stack<Integer> into int[]
        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}