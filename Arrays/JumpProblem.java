

class JumpProblem {
    public boolean canJump(int[] nums) {
        
        if(nums[0]==0 && nums.length==1)return true;
        if(nums.length==1)return true;
        if(nums[0]==0)return false;

        int furthest = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; i++){

            furthest = Math.max(furthest , i + nums[i]);
                        
            if(furthest >= nums.length-1){
                return true;
            }

            if(furthest==i && nums[i]==0){
                return false;
            }
        }

        return false;

    }
}