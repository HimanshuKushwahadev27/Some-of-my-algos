package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KPairSmallest {
   public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> list = new ArrayList<>();


        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return list;
        }


        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> (a[0] + a[1]) - (b[0] + b[1])
        );
        

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0}); // store nums2 index too
        }

        while (k > 0 && !minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int u = curr[0], v = curr[1], j = curr[2];
            
            list.add(Arrays.asList(u, v));
            k--;
            
            // Push the next pair from the same nums1 element, advancing the nums2 index
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{u, nums2[j + 1], j + 1});
            }
        }
        
        return list;
    }
}
