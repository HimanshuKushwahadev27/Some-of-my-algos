class SortPermutation {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int ans = -1; // all bits set (AND identity)
        boolean any = false;

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                ans &= nums[i];
                any = true;
            }
        }

        return any ? ans : 0;
    }
}
