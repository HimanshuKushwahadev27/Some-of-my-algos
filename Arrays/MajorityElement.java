package Arrays;

class MajorityElement {
    public int majorityElement(int[] nums) {
        
        int vote = 0 , candidate = -1 ;

        for(int i = 0 ; i < nums.length ; i++){
            if(vote == 0){
                candidate = nums[i];
                vote = 1;
            }else{
                if(nums[i] == candidate){
                vote++;
                }else{
                vote--;
                }
            }

            
        }

        int count = 0 ;

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]==candidate){
                count++;
            }
        }

       
        return candidate;
        
    }
}