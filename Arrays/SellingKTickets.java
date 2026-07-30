import java.util.Collections;
import java.util.PriorityQueue;

public class SellingKTickets {
      final int MOD = 1_000_000_007;
    public int maxAmount(int[] arr, int k) {
        // code here
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i : arr){
            pq.offer(i);
        }
        
        long result = 0 ;
        
        while(k != 0 && !pq.isEmpty()){
            k--;
            
            int num = pq.poll();
            
            result  = (result + num)%MOD ;
            num--;
            
            if(num > 0){
             pq.offer(num);
            }
        }
        
        return (int)result ;
        
    }
}
