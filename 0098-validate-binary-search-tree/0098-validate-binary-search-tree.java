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
    public boolean isValidBST(TreeNode root) {
        
        return dfs(root, null, null);
    }
    public boolean dfs(TreeNode node, Long min, Long max) {

        if (node == null) return true;

        //다음으로 재귀할 떄 오른쪽으로 간다면 최대값을 넘겨주고
        //왼쪽으로 간다면 ㅗ치솟값을 넘겨줌.
        if (max != null) 
            if (node.val >= max) return false;
        if (min != null)
            if (node.val <= min) return false;

        // dfs(node.left, min, null);
        // dfs(node.right, null, max);

        // return true; 
        return dfs(node.left, min,  (long)node.val) && dfs(node.right, (long)node.val, max);
    }
}