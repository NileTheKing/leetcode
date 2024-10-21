/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int max = 0;
    public int longestZigZag(TreeNode root) {
        int count = 0;
        boolean previous = false;// false:left, true:right
        dfs(root.left, 1, false);
        dfs(root.right, 1, true);

        return max;
    }

    public void dfs(TreeNode current, int count,  boolean previous) {
        if(current == null){
            return;
        }

        max = Math.max(max, count);
        if(!previous) {
            dfs(current.right, count+1, true);
            dfs(current.left, 1, false);
        }
        else {
            dfs(current.left, count+1,  false);
            dfs(current.right, 1, true);
        }
    }
}
// 일단 dfs임. 그리고 모든 경우의 수를 다 돌아봐야함. 각경우에 대해 길이를 가지고 있어야함.
// 스택을 이용해서 회귀하는 방식?아니면 재귀.
// 보통 재귀로 구현이 가능하잖아.
// 카운트를 셀 때 중간부터 시작할 수도 있음. 그런데 그거를 구현하는 방법은 지금 가려는 방향이 이전에서 온 방향과
// 같으면 새로 세어야 하고, 다르면 이어서 세면 됨.
// 그러면 구현할때 재귀로 구현하고 넘겨주는 값을 잘 설정하면 되겠다.
//