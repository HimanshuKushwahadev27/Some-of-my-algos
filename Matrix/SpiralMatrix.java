package Matrix;

import java.util.ArrayList;
import java.util.List;
public class SpiralMatrix {
      public List<Integer> spiralOrder(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0, right = m-1,  top = 0, bottom = n-1 ;

        List<Integer> hs = new ArrayList<>();
        int num = 1 ;
        while(left <= right && top <= bottom){

            for(int c = left ; c <= right ; c++){
                hs.add(matrix[top][c]);
            }
            top++;

            for(int c = top ; c <= bottom ; c++){
                hs.add(matrix[c][right]);
            }
            right--;

            if(top<=bottom){
                for (int c = right; c >= left; c--){
                    hs.add(matrix[bottom][c]);
                }
                 bottom--;
            }

            if (left <= right) {
                for (int r = bottom; r >= top; r--){
                    hs.add(matrix[r][left]);
                }
            left++;
            }
        }

        return hs;
    }
}
