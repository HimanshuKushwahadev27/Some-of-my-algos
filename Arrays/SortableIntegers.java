class SortableIntegers {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int total = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;
            if (check(nums, k)) total += k;
        }
        return total;
    }

    private boolean check(int[] nums, int k) {
        int n = nums.length;
        int prevMax = Integer.MIN_VALUE;

        for (int start = 0; start < n; start += k) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            int descents = 0;

            for (int i = 0; i < k; i++) {
                int cur = nums[start + i];
                int next = nums[start + (i + 1) % k]; // wrap-around inside the block
                if (cur > next) descents++;
                min = Math.min(min, cur);
                max = Math.max(max, cur);
            }

            if (descents > 1) return false;      // not a rotation of a sorted block
            if (min < prevMax) return false;     // overlaps with previous block
            prevMax = max;
        }
        return true;
    }
}