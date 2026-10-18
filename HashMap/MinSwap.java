package HashMap; // --- IGNORE ---
import java.util.Arrays;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        // Sort indices by (digitSum, value)
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;

        Arrays.sort(order, (a, b) -> {
            int da = digitSum(nums[a]);
            int db = digitSum(nums[b]);
            if (da != db) return da - db;
            return nums[a] - nums[b];
        });

        // order[k] = original index of the element that belongs at sorted position k
        // target[i] = sorted position of the element currently at index i
        int[] target = new int[n];
        for (int k = 0; k < n; k++) {
            target[order[k]] = k;
        }

        // Count cycles in the permutation i -> target[i]
        boolean[] visited = new boolean[n];
        int cycles = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cycles++;
                int j = i;
                while (!visited[j]) {
                    visited[j] = true;
                    j = target[j];
                }
            }
        }

        return n - cycles;
    }

    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}