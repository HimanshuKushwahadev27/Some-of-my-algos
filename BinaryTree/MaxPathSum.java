  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class MaxPathSum {
   private int maxSum;
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively get the max gain from left and right subtrees.
        // If a subtree's contribution is negative, it's better to not include it (treat as 0).
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // The best path THROUGH this node (as the "peak") considers both children.
        // This can only be used to update the global answer — it can't be returned
        // upward, since a path passed up to the parent can only extend through ONE side.
        int priceNewPath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, priceNewPath);

        // Return the max gain if this node continues as part of a path upward —
        // can only take ONE side (left or right), not both, since a path can't branch.
        return node.val + Math.max(leftGain, rightGain);
    }
}
