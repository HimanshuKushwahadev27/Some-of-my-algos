package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZag {

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
      public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;

        queue.offer(root);
        boolean leftToRight = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> helper = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                helper.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }


            if (!leftToRight) {
                Collections.reverse(helper);
            }
            ans.add(helper);
             leftToRight = !leftToRight;
        }

        return ans ;
    }
}
