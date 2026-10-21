class SortString {
    public int minOperations(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        char[] t = a.clone();
        Arrays.sort(t);

        if (Arrays.equals(a, t)) return 0;
        if (n == 2) return -1; // unsorted, and any operation would sort the whole string

        // 1 operation: the mismatch range is a proper substring
        int l = 0, r = n - 1;
        while (a[l] == t[l]) l++;
        while (a[r] == t[r]) r--;
        if (l > 0 || r < n - 1) return 1;

        char min = t[0], max = t[n - 1];

        // 2 operations: min occurs in s[0..n-2], or max occurs in s[1..n-1]
        for (int i = 0; i < n - 1; i++) {
            if (a[i] == min) return 2;
        }
        for (int i = 1; i < n; i++) {
            if (a[i] == max) return 2;
        }

        return 3;
    }
}