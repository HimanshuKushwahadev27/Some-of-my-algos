package Arrays;
class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        


        int low = 0 ;

        int length = nums.length ;


        for(int i = 1 ; i < length ; i++){

            if(nums[i] == nums[low]){
                continue;
            }
            low++;
            nums[low] = nums[i] ;
        }

        return low+1;
    }
}
