package SlidingWindow;

import java.util.Arrays;

public class LongestSubstring {
     public int lengthOfLongestSubstring(String s) {
        
        if(s.length()==0)return 0 ;

        int [] fre = new int[128];
        Arrays.fill(fre, -1);
        
        int size = Integer.MIN_VALUE;
        int left = 0 ;

        for(int i = 0 ; i < s.length() ; i++){
            
            char c = s.charAt(i);
        
            if(fre[c] >= left){
                left = fre[c] + 1 ;
            }

            fre[c] = i ;
            size = Math.max(size, i - left + 1);
            
        }

        return size;
    }
}
