package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {
  public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        helper(result, n, k, new ArrayList<>(), 1);

        return result ;
    }

    public void helper(List<List<Integer>> result, int n, int k, List<Integer> list, int start){

        if(list.size() == k){
            result.add(new ArrayList<>(list));
            return ;
        }

        for(int i = start ; i <= n  ; i++){
            list.add(i);
            helper(result, n, k, list, i+1);
            list.remove(list.size() - 1);
        }
    }
}
