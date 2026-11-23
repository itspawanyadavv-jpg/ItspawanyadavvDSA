import java.util.*;

class Solution {

    public int makeConnected(int n, int[][] connections) {

        // Not enough cables to connect n computers.
        if (connections.length < n - 1) {
            return -1;
        }

        // Build adjacency list.
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n];

        int components = 0;

        // Start DFS from every unvisited computer.
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                components++;

                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                visited[i] = true;

                while (!stack.isEmpty()) {

                    int node = stack.pop();

                    for (int neighbor : graph[node]) {

                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            stack.push(neighbor);
                        }
                    }
                }
            }
        }

        return components - 1;
    }
}