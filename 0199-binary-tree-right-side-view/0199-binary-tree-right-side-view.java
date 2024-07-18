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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>(); // 답 저장할 어레이리스트
        if (root == null) return list; // 루트가 null이면 빈 리스트 반환

        traversalByLevel(root, list);
        return list;
    }

    public void traversalByLevel(TreeNode node, List<Integer> list) {
        Queue<TreeNode> queue = new LinkedList<>(); // 순회할 큐
        queue.add(node);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode rightMostNode = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                rightMostNode = currentNode;

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            if (rightMostNode != null) {
                list.add(rightMostNode.val);
            }
        }
    }
}