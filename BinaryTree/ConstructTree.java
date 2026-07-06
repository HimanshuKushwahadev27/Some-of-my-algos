package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTree {

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
  private Map<Integer, Integer> idxMap = new HashMap<>();
    private int[] preorder;
    private int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder ;

        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }

        return build(0, inorder.length - 1);

    }

    private TreeNode build(int inLeft, int inRight){

        if(inLeft > inRight) return null ;
        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);

        int index = idxMap.get(rootVal);

        root.left = build(inLeft, index-1);
        root.right = build(index+1, inRight);

        return root;
    }
}
