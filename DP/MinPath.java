public class MinPath{
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            return 0; 
        }

        obstacleGrid[0][0] = 1;


        for (int c = 1; c < cols; c++) {
            obstacleGrid[0][c] = (obstacleGrid[0][c] == 1) ? 0 : obstacleGrid[0][c - 1];
        }

        for (int r = 1; r < rows; r++) {
            obstacleGrid[r][0] = (obstacleGrid[r][0] == 1) ? 0 : obstacleGrid[r - 1][0];
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (obstacleGrid[r][c] == 1) {
                    obstacleGrid[r][c] = 0;
                } else {
                    obstacleGrid[r][c] = obstacleGrid[r - 1][c] + obstacleGrid[r][c - 1];
                }
            }
        }

        return obstacleGrid[rows - 1][cols - 1];
    }
}