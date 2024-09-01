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
 /*
class Solution {
    public int goodNodes(TreeNode root) {
        int max = root.val;
        return traverse(root, max);
    }
    public int traverse(TreeNode root, int max){
        TreeNode current = root;
        if(current == null){
            return 0;
        }

        if(current.val >= max){ //재귀 중에 현재 탐색 중인 노드의 값이 good이라면 1추가
            max = current.val;
            return 1 + traverse(current.left, max) + traverse(current.right, max);
        }
        else{// good이 아니라면 
            return traverse(current.left, max) + traverse(current.right, max);
        }

    }
}
*/

class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        int max = root.val;
        traverse(root, max);
        return count;
    }
    public void traverse(TreeNode root, int max){
        if(root == null){
            return;
        }

        if(root.val >= max){ //재귀 중에 현재 탐색 중인 노드의 값이 good이라면 1추가
            max = root.val;
            count++;
        }
        traverse(root.left, max);
        traverse(root.right, max);   
    }
}