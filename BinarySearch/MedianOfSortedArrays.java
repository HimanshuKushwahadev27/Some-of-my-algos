public class MedianOfSortedArrays {
   public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // Always binary search on the smaller array for efficiency
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        int half = (total + 1) / 2; // size of the left partition

        int low = 0, high = m;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = half - partitionX;

            // Values just around the partition line in each array
            int leftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int rightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int leftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int rightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            if (leftX <= rightY && leftY <= rightX) {
                // Correct partition found
                if (total % 2 == 0) {
                    return (Math.max(leftX, leftY) + Math.min(rightX, rightY)) / 2.0;
                } else {
                    return Math.max(leftX, leftY);
                }
            } else if (leftX > rightY) {
                high = partitionX - 1; // too many elements from nums1 on the left, shrink
            } else {
                low = partitionX + 1; // too few elements from nums1 on the left, expand
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}
