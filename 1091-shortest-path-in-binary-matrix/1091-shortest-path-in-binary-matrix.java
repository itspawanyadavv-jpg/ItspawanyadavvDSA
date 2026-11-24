
class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        // Step 1: Check starting and ending cells
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        // Step 2: Define 8 directions
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1,  0,  1,-1, 1,-1, 0, 1};

        // Step 3: Create Queue
        Queue<int[]> q = new LinkedList<>();

        // {row, col, distance}
        q.offer(new int[]{0, 0, 1});

        // Mark starting cell visited
        grid[0][0] = 1;

        // Step 4: BFS traversal
        while (!q.isEmpty()) {

            int[] current = q.poll();

            int row = current[0];
            int col = current[1];
            int dist = current[2];

            // Step 5: Destination reached
            if (row == n - 1 && col == n - 1) {
                return dist;
            }

            // Step 6: Explore 8 neighbours
            for (int i = 0; i < 8; i++) {

                int newRow = row + dr[i];
                int newCol = col + dc[i];

                // Step 7: Check boundaries and obstacles
                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < n &&
                    grid[newRow][newCol] == 0) {

                    // Mark visited
                    grid[newRow][newCol] = 1;

                    // Add neighbour to queue
                    q.offer(new int[]{
                        newRow,
                        newCol,
                        dist + 1
                    });
                }
            }
        }

        return -1;
    }
}
