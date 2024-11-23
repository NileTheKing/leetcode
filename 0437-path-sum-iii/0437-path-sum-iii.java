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
    private int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        long currentSum = 0;
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        dfs(root, targetSum, currentSum);

        return count;
    }
    public void dfs(TreeNode node, int targetSum, long currentSum) {
        if(node == null) {
            return;
        }
        currentSum += node.val;
        if(currentSum == targetSum) {
            count++;
        }

        dfs(node.left, targetSum, currentSum);
        dfs(node.right, targetSum, currentSum);
    }
}
/**
모든 방법 트라이. 쭉이어서 하는 것. 그리고 거기서 다시 시작하는 것.
I might not have to check for the already-visited nodes.
stackedSums는 키값이 합이고 밸류가 뭐지? 해시맵은 왜쓰고 누적합은 어떻게 활용하여야 할까/?

 */