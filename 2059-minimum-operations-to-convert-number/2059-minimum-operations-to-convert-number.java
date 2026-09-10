import java.util.*;

class Solution {

    public int minimumOperations(int[] nums, int start, int goal) {

        // If start is already goal, no operation is needed.
        if (start == goal) {
            return 0;
        }

        // We only need to keep track of states from 0 to 1000.
        boolean[] visited = new boolean[1001];

        // BFS queue
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);

        // Mark start as visited
        visited[start] = true;

        // Number of operations
        int operations = 0;

        while (!queue.isEmpty()) {

            // Number of states at the current BFS level
            int size = queue.size();

            operations++;

            // Process all states reachable in the current number of operations
            for (int j = 0; j < size; j++) {

                int current = queue.poll();

                // Try every number in nums
                for (int num : nums) {

                    // Three possible operations
                    int[] nextValues = {
                        current + num,
                        current - num,
                        current ^ num
                    };

                    for (int next : nextValues) {

                        // If we reached the goal,
                        // this is the minimum number of operations.
                        if (next == goal) {
                            return operations;
                        }

                        // Only values in [0, 1000]
                        // can be used for further operations.
                        if (next >= 0 && next <= 1000
                                && !visited[next]) {

                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                }
            }
        }

        // Goal cannot be reached.
        return -1;
    }
}