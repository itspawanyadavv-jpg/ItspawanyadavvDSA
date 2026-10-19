class Solution {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        // Try every cell as the starting point.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (search(board, word, row, col, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(
            char[][] board,
            String word,
            int row,
            int col,
            int index,
            boolean[][] visited) {

        // All characters have been matched.
        if (index == word.length()) {
            return true;
        }

        // Reject invalid positions.
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Reject a used cell or a mismatched character.
        if (visited[row][col] ||
            board[row][col] != word.charAt(index)) {
            return false;
        }

        // Choose this cell.
        visited[row][col] = true;

        // Try all four directions.
        boolean found =
                search(board, word, row - 1, col, index + 1, visited) ||
                search(board, word, row + 1, col, index + 1, visited) ||
                search(board, word, row, col - 1, index + 1, visited) ||
                search(board, word, row, col + 1, index + 1, visited);

        // Undo the choice so another path can use this cell.
        visited[row][col] = false;

        return found;
    }
}