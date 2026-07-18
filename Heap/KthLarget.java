package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLarget {
   public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : nums){
            pq.offer(i);
        }


        while(k != 1){
            k--;
            pq.poll();
        }

        return pq.peek();
    }
}
