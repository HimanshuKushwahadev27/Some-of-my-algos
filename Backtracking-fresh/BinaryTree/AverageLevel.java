package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevel {
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
      public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root == null)return ans ;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            double sum = 0;
            for(int i = 0  ; i < size ; i++){
                TreeNode node = q.poll();

                sum = sum + (double)node.val ;

                if(node.left != null)q.offer(node.left);
                if(node.right != null)q.offer(node.right);
            }

            sum = sum/size ;
            ans.add(sum);
        }

        return ans ;
    }
}
