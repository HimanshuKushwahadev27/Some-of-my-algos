package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
      public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        String[] mapping = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        helper(result, new StringBuilder(), digits, 0, mapping);

        return result;
    }

    public void helper(List<String> result, StringBuilder current, String digits, int index, String[] mapping){
        if(index == digits.length()){
            result.add(current.toString());
            return ;
        }

        int digit = digits.charAt(index) - '0';
        String letter = mapping[digit];

        for(char c : letter.toCharArray()){
            current.append(c);
            helper(result, current, digits, index + 1, mapping);
            current.deleteCharAt(current.length() - 1) ;
        }
    }
}
