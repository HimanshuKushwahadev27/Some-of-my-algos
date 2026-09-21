package DP;

public class FindXValue {
   int n = nums.length;
        long[] result = new long[k];
        
        // dp[r] = number of subarrays ENDING AT the current index with product % k == r
        long[] dp = new long[k];
        
        for (int j = 0; j < n; j++) {
            long[] newDp = new long[k];
            int val = nums[j] % k;
            
            // Extend every subarray that ended at the previous index
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newR = (int) ((r * (long) val) % k);
                    newDp[newR] += dp[r];
                }
            }
            
            // Also count the new subarray that starts AND ends at j (just nums[j] alone)
            newDp[val]++;
            
            dp = newDp;
            
            // Add this index's contributions into the overall result
            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }
        
        return result;
}
