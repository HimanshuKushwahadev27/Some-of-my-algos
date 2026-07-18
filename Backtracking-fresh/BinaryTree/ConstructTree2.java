package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTree2 {

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
    private int[] postorder;
    private int postIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.postIdx = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }

        return build(0, inorder.length - 1);
    }

    public TreeNode build(int inLeft, int inRight){
        if(inLeft > inRight)return null;

        int rootVal = postorder[postIdx--];
        TreeNode root = new TreeNode(rootVal);

        int index = idxMap.get(rootVal);

        root.right = build(index + 1, inRight);
        root.left = build(inLeft, index - 1);

        return root;
    }
}
