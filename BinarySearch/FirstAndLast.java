public class FirstAndLast {
    private int findBound(int[] nums, int target, boolean findFirst) {
        int left = 0, right = nums.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                result = mid;
                if (findFirst) {
                    right = mid - 1; // keep searching left for earlier occurrence
                } else {
                    left = mid + 1; // keep searching right for later occurrence
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);
        
        if (first == -1) {
            return new int[]{-1, -1};
        }
        
        int last = findBound(nums, target, false);
        
        return new int[]{first, last};
    }
}
