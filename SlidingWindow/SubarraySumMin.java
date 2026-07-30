package SlidingWindow;

public class SubarraySumMin {
   public int minSubArrayLen(int target, int[] nums) {
        
        int low = 0 ;
        int sum = nums[0] ;
        int ans = Integer.MAX_VALUE;
        int i = 1 ;

        while(low < i ){

            if(sum >= target){
                ans = Math.min(ans, i-low);
                sum -= nums[low];
                low++;
            }else if(i < nums.length){
                sum += nums[i];
                i++;
            }else{
                break ;
            }
        }

        if(ans == Integer.MAX_VALUE){
            return 0 ;
        }

        return ans ;
    }
    
}
