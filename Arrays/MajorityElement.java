

class MajorityElement {
    public int majorityElement(int[] nums) {
      
      //utilized Boyer-Moore Voting Algorithm , no case where there is no majority element as it is given that majority element always exists(given in question)
      

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
 
        return candidate;
        
    }
}