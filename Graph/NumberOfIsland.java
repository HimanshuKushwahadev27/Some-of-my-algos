package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
   public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0 ;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        boolean [][] visited = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){

            for(int j = 0 ; j < m ; j++){

                if(!visited[i][j] && grid[i][j] == '1'){
                    visited[i][j] = true ;
                    count++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] {i, j});

                    while(!queue.isEmpty()){
                        int [] index = queue.remove();

                        for(int k = 0 ; k < 4 ; k++){
                            int row = index[0] + dr[k] ;
                            int col = index[1] +  dc[k];
                            if(row >= 0 && col >= 0 && row < n && col < m && grid[row][col] == '1' && !visited[row][col]){
                                visited[row][col] = true ;
                                queue.offer(new int[] {row, col});
                            }
                        }
                    }
                }
            }
        }

        return count ;
    }
}
