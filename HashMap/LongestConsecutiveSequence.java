package HashMap;

import java.util.HashSet;

public class LongestConsecutiveSequence {
      public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0)return 0 ;
        HashSet<Integer> set = new HashSet<>();

        int ans = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++){
            set.add(nums[i]);
        }

        for(int num : set){

            if(!set.contains(num-1)){
                int length = 1 ;
                while(set.contains(num+length)){
                    length++;
                }

                ans = Math.max(ans, length);
            }
        }

        return ans ;
    }
}
