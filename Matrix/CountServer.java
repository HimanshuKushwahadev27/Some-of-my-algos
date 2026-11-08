package Matrix;

class CountServer {
    public int countServers(int[][] grid) {
        int count = 0 ;

        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    boolean connected = false;
                    for(int k = 0 ; k < m && !connected ; k++){
                        if(k != j && grid[i][k] == 1){
                            connected = true ;
                        }
                    }
                    for(int k = 0 ; k < n ; k++){
                    if(k != i && grid[k][j] == 1){
                            connected = true ;
                        }
                    }
                    if(connected) count++;
                }
            }
        }

        return count ;
    }
}