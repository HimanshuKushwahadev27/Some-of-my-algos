package DP;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
            
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if s[0..j-1] is breakable AND s[j..i-1] is a valid word
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // no need to check other j values for this i
                }
            }
        }
        
        return dp[n];
    }
}
