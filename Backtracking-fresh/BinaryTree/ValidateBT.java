package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBT {

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
    public boolean isValidBST(TreeNode root) {
        
        helper(root);
        if(list.size() == 1)return true ;

        for(int i = 1 ; i < list.size() ; i++){
            if(list.get(i) <= list.get(i-1) ){
                return false ;
            }
        }

        return true ;
    }
}
