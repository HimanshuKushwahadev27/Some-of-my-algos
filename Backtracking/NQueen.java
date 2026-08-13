public class NQueen {
   private int count = 0;
    private boolean[] cols;
    private boolean[] diag1; 
    private boolean[] diag2;

    public int totalNQueens(int n) {
        count = 0;
        cols = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];

        backtrack(0, n);
        return count; 
    }


    private void backtrack(int row, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col + n - 1;

            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue; // this position is under attack
            }

            // Place the queen
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtrack(row + 1, n);

            // Remove the queen (backtrack)
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}
