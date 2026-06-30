package Matrix;

public class GameOfLife {
     public void gameOfLife(int[][] board) {

        int n = board.length, m = board[0].length ;

        for(int i = 0 ; i < n ; i++){

            for(int j = 0 ; j < m ; j++){

                int liveNegihbours = 0 ;

                for(int k = -1 ; k <= 1 ; k++){

                    for(int l = -1 ; l <=1 ; l++){

                        if(k==0 && l==0)continue;

                        int nRow = i + k, nCol = j + l ;

                        if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                            liveNegihbours += board[nRow][nCol] & 1 ;
                        }
                    }
                }

                if(board[i][j] == 1){
                    if(liveNegihbours == 2 || liveNegihbours == 3){
                        board[i][j] = 3 ; //live
                    }
                }else{
                    if(liveNegihbours == 3){
                        board[i][j] = 2 ;// dead -> alive
                    }
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}
