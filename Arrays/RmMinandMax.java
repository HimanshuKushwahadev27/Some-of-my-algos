public class RmMinandMax{
   public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = 0, maxIdx = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }
        
        int i = Math.min(minIdx, maxIdx);
        int j = Math.max(minIdx, maxIdx);
        
        // Option 1: remove both from the front (up to and including j)
        int option1 = j + 1;
        
        // Option 2: remove both from the back (from i to end)
        int option2 = n - i;
        
        // Option 3: remove i from front, j from back
        int option3 = (i + 1) + (n - j);
        
        return Math.min(option1, Math.min(option2, option3));
    }
}