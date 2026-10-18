package HashMap;

import java.util.HashMap;
import java.util.Map;

public class SubArrayDistinct {
   static final long MOD = 1_000_000_007L;
    long[] sum, sq, lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> last = new HashMap<>();
        long ans = 0;

        for (int j = 0; j < n; j++) {
            int p = last.getOrDefault(nums[j], -1);
            update(1, 0, n - 1, p + 1, j, 1);
            ans = (ans + sq[1]) % MOD;
            last.put(nums[j], j);
        }
        return (int) ans;
    }

    private void apply(int node, int len, long v) {
        // order matters: sq uses old sum
        sq[node] = (sq[node] + 2 * v % MOD * sum[node] % MOD + (long) len * v % MOD * v % MOD) % MOD;
        sum[node] = (sum[node] + (long) len * v) % MOD;
        lazy[node] = (lazy[node] + v) % MOD;
    }

    private void push(int node, int l, int r) {
        if (lazy[node] != 0) {
            int mid = (l + r) / 2;
            apply(2 * node, mid - l + 1, lazy[node]);
            apply(2 * node + 1, r - mid, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void update(int node, int l, int r, int ql, int qr, long v) {
        if (qr < l || r < ql) return;
        if (ql <= l && r <= qr) {
            apply(node, r - l + 1, v);
            return;
        }
        push(node, l, r);
        int mid = (l + r) / 2;
        update(2 * node, l, mid, ql, qr, v);
        update(2 * node + 1, mid + 1, r, ql, qr, v);
        sum[node] = (sum[2 * node] + sum[2 * node + 1]) % MOD;
        sq[node] = (sq[2 * node] + sq[2 * node + 1]) % MOD;
    }
}
