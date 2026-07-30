

public class JumpProblem2 {
      public int jump(int[] nums) {
        if(nums.length==1)return 0;

        int furthest = -1, cnt = 0, currentEnd = 0;

        for(int i = 0 ; i < nums.length-1 ; i++){

            furthest = Math.max(furthest, i+nums[i]);
                        
            if(i==currentEnd){
                cnt++;
                currentEnd = furthest;
            }
            
        }

        return cnt;
    }
}
