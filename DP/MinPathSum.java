
public class MinPathSum {
  public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 && c == 0) {
                    continue; // starting cell, no adjustment needed
                } else if (r == 0) {
                    grid[r][c] += grid[r][c - 1]; // top row: only reachable from the left
                } else if (c == 0) {
                    grid[r][c] += grid[r - 1][c]; // left column: only reachable from above
                } else {
                    grid[r][c] += Math.min(grid[r - 1][c], grid[r][c - 1]);
                }
            }
        }

        return grid[rows - 1][cols - 1];
    }
}
