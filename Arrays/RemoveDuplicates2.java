

class RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {

        int low = 0  ;

        int length = nums.length ;

        
        for(int i = 1 ; i < length ; i++){

            if(nums[low] != nums[i]){
                low++;
                nums[low] = nums[i];
                continue;
            }
            if(nums[low] == nums[i]){
                if( i > 0 && low > 0){
                    if(nums[i-1] == nums[low-1]){
                        continue;
                    }
                }
                low++; 

                 nums[low] = nums[i];
            }       
        }
        return low+1; 
    }
}
