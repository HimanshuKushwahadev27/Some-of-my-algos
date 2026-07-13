public class Rearrange {
   static final long MOD = 1_000_000_007;
    int minOperations(int[] b) {
    
       int n = b.length;
        boolean[] visited = new boolean[n];
        long lcm = 1;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int length = 0;
                int curr = i;

                // find cycle length
                while (!visited[curr]) {
                    visited[curr] = true;
                    curr = b[curr] - 1; // convert to 0-based
                    length++;
                }

                // update LCM
                lcm = lcm(lcm, length);
            }
        }

        return (int)(lcm % MOD);
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}
