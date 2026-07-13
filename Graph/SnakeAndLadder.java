package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {
      private int[] getRowCol(int label, int n) {
        int row = (label - 1) / n;
        int col = (label - 1) % n;
        
        int boardRow = n - 1 - row;
        
        int boardCol;
        if (row % 2 == 0) {
            boardCol = col;
        } else {
            boardCol = n - 1 - col;
        }
        
        return new int[]{boardRow, boardCol};
    }
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length ;
        int target = n*n ;

        int [] vis = new int[target+1];
        Arrays.fill(vis, -1);

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        vis[1] = 0 ;

        while(!queue.isEmpty()){
            int curr = queue.poll();

            if(curr == target){
                return vis[curr];
            }

            for(int next = curr + 1 ; next <= Math.min(curr + 6, target) ; next++){
                int[] pos = getRowCol(next, n);

                int r = pos[0], c = pos[1] ;

                int destination = board[r][c] != -1 ? board[r][c] : next;
                
                if (vis[destination] == -1) {
                    vis[destination] = vis[curr] + 1;
                    queue.offer(destination);
                }
            }
        }

        return -1 ;
    }
}
