package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest {
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
     List<Integer> list = new ArrayList<>();

    public void helper(TreeNode root){
        if(root == null)return;

        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)return 0;
        if(k == 0)return root.val;

        helper(root);
        return list.get(k-1);

    }
}
