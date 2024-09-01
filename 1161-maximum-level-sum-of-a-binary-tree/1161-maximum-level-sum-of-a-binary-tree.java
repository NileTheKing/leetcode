/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        return traverseByLevel(root);
       
        
    }

    public int traverseByLevel(TreeNode node){
         if (node == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int level = 0;
        int max = Integer.MIN_VALUE;;
        int answer = 0;

        while(!queue.isEmpty()){
            level++;
            int sum = 0;
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){ //수정
                TreeNode current = queue.poll();
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
                sum += current.val;
            }
            if(sum > max){
                max = sum;
                answer = level;
            }
        }

        return answer;
    }

}
