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
    private HashMap<Long, Integer> prefixSum;
    private int count;
    public int pathSum(TreeNode root, int targetSum) {
        prefixSum = new HashMap<>();
        count = 0;

        dfs(root, targetSum, 0);

        return count;
    }
    public void dfs(TreeNode node, int targetSum, long currentSum) {
        if(node == null) return;

        currentSum += node.val;
        
        if(currentSum == targetSum){
            count++;
        }
        count += prefixSum.getOrDefault(currentSum - targetSum, 0);

        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);

        dfs(node.left, targetSum, currentSum);
        dfs(node.right, targetSum, currentSum);

        prefixSum.put(currentSum, prefixSum.get(currentSum) - 1);//백트래킹해서 줄이기
        
        
    }
}