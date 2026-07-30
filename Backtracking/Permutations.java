package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
      public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();

        helper(result, nums, new ArrayList<>(), new boolean[nums.length]);

        return result ;
    }

    public void helper(List<List<Integer>> result, int [] nums, List<Integer> current, boolean [] used){

        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return ;
        }


        for(int i = 0 ; i < nums.length ; i++){

            if(used[i])continue;

            used[i] = true; 

            current.add(nums[i]);
            helper(result, nums, current, used);
            current.remove(current.size() - 1);
            used[i] = false ;
        }
    }
}
