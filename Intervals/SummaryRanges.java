package Intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
   public List<String> summaryRanges(int[] nums) {
       

      List<String> al = new ArrayList<>();

      int n = nums.length ;

      if(n == 0)return al;
      if(n==1){
         al.add(String.valueOf(nums[0]));
         return al ;
      }

      int num = nums[0] ;

      for(int i = 1 ; i < n ; i++){

        if(nums[i] != nums[i-1]+1){

            if(num != nums[i-1]){
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(num));
                sb.append("->");
                sb.append(String.valueOf(nums[i-1]));
                al.add(sb.toString());
                num = nums[i];
            }else{
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(num));
                al.add(sb.toString());
                num = nums[i];
            }
        }
      }


        if(num != nums[n-1]){
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(num));
            sb.append("->");
            sb.append(String.valueOf(nums[n-1]));
            al.add(sb.toString());
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(num));
            al.add(sb.toString());
        }
      return al;  
    }
}
