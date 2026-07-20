
public class HouseRobber{
   public int rob(int[] nums) {
        
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper(nums, 0, memo);
    }

    public int helper(int [] nums, int index, int [] memo){

        if(index >= nums.length)return 0;
        if (memo[index] != -1) return memo[index];

        int robThis = nums[index] + helper(nums, index + 2, memo);
        int skipThis = helper(nums, index + 1, memo);

        memo[index] = Math.max(robThis, skipThis);
        return memo[index];
    }
}