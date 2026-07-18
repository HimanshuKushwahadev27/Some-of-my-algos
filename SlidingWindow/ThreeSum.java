package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
   public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);

        List<List<Integer>> al = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++){

            if(i > 0 && nums[i] == nums[i-1])continue;
            int low = i+1;
            int high = nums.length-1;

            while(low < high){
                int ans = nums[i] + nums[low] + nums[high];

                if(ans == 0){
                    al.add(Arrays.asList(nums[i], nums[low], nums[high]));

                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;

                    low++;
                    high--;
                }else if(ans > 0){
                    high--;
                }else{
                    low++;
                }
            }
        }
        return al;
    }  
}
