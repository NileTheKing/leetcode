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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }

        else{ //삭제할 노드의 자식의 경우의 수 컨트롤 

            if(root.right == null) return root.left; //오른쪽이 널이면 그냥 왼쪽이랑 연결되게
            if(root.left == null) return root.right; //오른쪽이 다 널이면 그냥 왼쪽이랑 연결되게 하면 됨.

            //자식이 둘다 있는 경우

            TreeNode node = root.right;
            while(node.left != null){ //오른쪽 자식의 서브트리 중 가장 작은 값을 찾아서
                node = node.left;
            }
            root.val = node.val;
            root.right = deleteNode(root.right, node.val);

        }

        return root;



    }
}