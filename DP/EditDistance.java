package DP;

public class EditDistance {
   public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // memo[i][j] = answer for word1[i..] vs word2[j..], -1 means uncomputed
        int[][] memo = new int[m + 1][n + 1];
        for (int[] row : memo) {
            java.util.Arrays.fill(row, -1);
        }

        return solve(word1, word2, 0, 0, memo);
    }


    private int solve(String word1, String word2, int i, int j, int[][] memo) {
        // Base cases: one string exhausted
        if (i == word1.length()) {
            return word2.length() - j; // insert all remaining word2 characters
        }
        if (j == word2.length()) {
            return word1.length() - i; // delete all remaining word1 characters
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int result;

        if (word1.charAt(i) == word2.charAt(j)) {
            result = solve(word1, word2, i + 1, j + 1, memo); // no operation needed
        } else {
            int replace = solve(word1, word2, i + 1, j + 1, memo);
            int delete = solve(word1, word2, i + 1, j, memo);
            int insert = solve(word1, word2, i, j + 1, memo);

            result = 1 + Math.min(replace, Math.min(delete, insert));
        }

        memo[i][j] = result;
        return result;
    }
}
