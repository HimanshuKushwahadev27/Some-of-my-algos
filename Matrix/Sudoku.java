package Matrix;

import java.util.HashSet;

public class Sudoku {
   public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0 ; i < 9 ; i++){
            HashSet<Character> st = new HashSet<>();
            for(int j = 0 ; j < 9 ; j++){
                char val = board[i][j];
                if(val == '.')continue;
                if(st.contains(val))return false;
                st.add(val);
            }
        }

        for(int i = 0 ; i < 9 ; i++){
            HashSet<Character> st = new HashSet<>();
            for(int j = 0 ; j < 9 ; j++){
                char val = board[j][i];
                if(val == '.')continue;
                if(st.contains(val))return false;
                st.add(val);
            }
        }


        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                HashSet<Character> st = new HashSet<>();
                
                    for(int k = 0 ; k < 3 ;k++){
                        for(int l = 0 ; l < 3 ; l++){
                            char val = board[i*3+k][j*3+l];
                            if(val == '.')continue;
                            if(st.contains(val))return false;
                            st.add(val);
                        }
                    }
            }
        }

        return true;
    }
}
