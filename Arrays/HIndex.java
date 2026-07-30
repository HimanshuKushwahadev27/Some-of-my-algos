import java.util.Arrays;

public class HIndex {
     public int hIndex(int[] citations) {
        
        Arrays.sort(citations);

        int ans = 0;

        int low = 0 , high = citations.length-1 ; 

        while(low < high){
            int temp = citations[low];
            citations[low] = citations[high];
            citations[high] = temp;
            low++ ; high-- ;
        }

        for(int i = 0 ; i < citations.length ; i++){

            if(i+1 <= citations[i]){
                ans = i+1 ; 
            }
        }
        return ans;
    }
}
