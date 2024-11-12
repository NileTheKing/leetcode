/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return null;

        if(root == p || root == q) return root;//찾았음

        TreeNode left = lowestCommonAncestor(root.left, p, q); //이걸 하면 찾은 노드가 리턴됨
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }
        if(left == null && right != null) {
            return right;
        }
        if(left != null && right == null){
            return left;
        }

        return null;
    }


}
/**
LCA는 경우의수가
1. LCA가 두 자식의 부모 -> 부모가 리턴
2. 하나의 노드가 LCA이고 그것이 자식노드 ->
 */