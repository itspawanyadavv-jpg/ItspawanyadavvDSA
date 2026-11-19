
class Solution {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int provinces = 0;

        // Check every city.
        for (int i = 0; i < n; i++) {

            // Found a new province.
            if (!visited[i]) {

                provinces++;

                // Explore the complete province.
                dfs(i, isConnected, visited);
            }
        }

        return provinces;
    }

    private void dfs(
            int node,
            int[][] isConnected,
            boolean[] visited) {

        // Mark current city as visited.
        visited[node] = true;

        // Check every possible neighboring city.
        for (int neighbor = 0;
             neighbor < isConnected.length;
             neighbor++) {

            // Check connection and visited status.
            if (isConnected[node][neighbor] == 1
                    && !visited[neighbor]) {

                // Explore the connected city.
                dfs(neighbor, isConnected, visited);
            }
        }
    }
}
