import java.util.Arrays;

public class Candy {
  public int candy(int[] ratings) {
        
        if(ratings.length==1)return 1;

        int [] front=  new int[ratings.length];
        Arrays.fill(front, 1);


        for(int i = 1 ; i < ratings.length ; i++){
            if(ratings[i] > ratings[i-1]){
               front[i] =  front[i-1] + 1;
            }
        }

        for(int i = ratings.length-2 ; i >= 0 ; i--){
            if(ratings[i] > ratings[i+1]){
                front[i] = Math.max(front[i], front[i+1]+1);
            }
        }

        return Arrays.stream(front).sum();

    }
}
