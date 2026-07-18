package BinaryTree;

public class LeafToRoot {
     public class TreeNode {
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
   public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int currentNumber){
        if(root == null)return 0 ;

       currentNumber = currentNumber * 10 + root.val ;

       if(root.left == null && root.right==null)return currentNumber;

       return dfs(root.left, currentNumber) + dfs(root.right, currentNumber);
    }
}
