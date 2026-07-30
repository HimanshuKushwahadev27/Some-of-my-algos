package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
   public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(result, candidates, target, 0, new ArrayList<>());

        return result ;
    }

    public void helper(List<List<Integer>> result, int [] cand, int remain, int start, List<Integer> current){
        if(remain == 0){
            result.add(new ArrayList<>(current));
            return ;
        }

        for(int i = start ; i < cand.length ; i++){
            if(cand[i] > remain){
                break;
            }

            current.add(cand[i]);
            helper(result, cand, remain - cand[i], i, current);
            current.remove(current.size()-1);
        }
    }
}
