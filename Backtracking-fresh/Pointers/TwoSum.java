package Pointers;

public class TwoSum {
   public int[] twoSum(int[] numbers, int target) {
        
        int [] ans = new int [2];


        int low = 0 ;
        int high = numbers.length-1;

        while(low < high){

            if(numbers[low]+numbers[high] == target)break ;

            if(numbers[low] + numbers[high] > target){
                high--;
            }else{
                low++;
            }

        }
        low++; high++;
        ans[0] = low;
        ans[1] = high;

        return ans ;
    }
}
