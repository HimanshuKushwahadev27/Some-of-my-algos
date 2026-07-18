
public class PeakElement {
    public int findPeakElement(int[] nums) {
        
        int low = 0 ;
        int high = nums.length - 1 ;


        while(high > low){

            int mid = low + (high - low)/2;

            //sequence is falling so it should have risen on the left somewhere
            if(nums[mid] > nums[mid + 1]){
                high = mid ;
            }else{
                //sequence is rising so it should fall on the right somewhere 
                low = mid + 1;
            }

        }

        return low ;
    }
}
