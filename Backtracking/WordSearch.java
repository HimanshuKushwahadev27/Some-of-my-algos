package Backtracking;

public class WordSearch {
   int[] r = {-1, 1, 0, 0};
    int[] c = {0, 0, -1, 1};
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] vis = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(board, word, 0, vis, i, j)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    private boolean helper(char[][] board, String word, int index, boolean[][] vis, int row, int col) {
        if (index == word.length()) {
            return true; // matched the whole word
        }
        
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        
        if (vis[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        
        vis[row][col] = true;
        
        for (int i = 0; i < 4; i++) {
            if (helper(board, word, index + 1, vis, row + r[i], col + c[i])) {
                vis[row][col] = false; // restore before returning 
                return true;
            }
        }
        
        vis[row][col] = false; // backtrack
        return false;
    }
}
