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
        boolean pFound = false;
        boolean qFound = true;
        TreeNode ans;

        dfs(null, root, p, q);

        return ans;
    }

    public void dfs(TreeNode father, TreeNode next, TreeNode q, TreeNode q) {
        TreeNode current = next;
        if(curret == null) {
            return;
        }

        if(pFound && qFound) {
            return;
        }

        if(current.val == p.val) { //p먼저 찾으면 같은 갈래에서 q도  찾을거라 가정 후 일단 답저장
            pFound = true;
            if(!qFound) //q먼저 찾은거면ㅇ 저장하면 안됨
                ans = current;
            dfs(current, current.left, p, q);
            dfs(current, current.right, p, q);
        }

        if(current.val == q.val) { //p먼저 찾으면 같은 갈래에서 q도  찾을거라 가정 후 일단 답저장
            qFound = true;
            if(!pFound)
                ans = current;
            dfs(current, current.left, p, q);
            dfs(current, current.right, p, q);
        }

        if(current.val != p.val && current.val != q.val) {
            dfs(current, current.left, p, q);
            dfs(current, current.right, p, q);
        }

        return;
    }
}

/**
LCA: 중에 가장 가까운 놈
같은 조상인지 어떻게 아냐?
만약에 DFS를 한다고 하면 그 경로상 모든 노드들은 조상임

경우의수:줄기가 이어진다:한놈이 한놈의 조상이다. -> 조상인 애가 LCA
        :분화된 다른 집안이다 ->갈리기 직전은 더 세대가 높은 애의 조상. 얘가 LCA
        끝.
    
구현:
안됨

일단 dfs를 들어가..언제까지? 둘다 찾을 떄 까지
아 그러면 일단 dfs들어가서 하나찾아. 그다음에 하나 더 찾겠지.
문제는 공통조상을 어떻게 아냐는것.
만약 두번째로 찾아진 애가 첫번째로 찾은 노드의 연장선이다? 그러면 답은 첫번째 노드

만약 그게 아니면 어떻게 찾지
그게 아니라면 답은 처음 찾은애의 부모!! 그러면 부모를 넘겨주면서 dfs를 진행하지
그리고 경우의수 대로.

 */