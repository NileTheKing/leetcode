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
        dfs(root, targetSum, 0);

        //새로시작.
        pathSum(root.left, targetSum); 
        pathSum(root.right, targetSum);

        return count;
    }
    public void dfs(TreeNode node, int targetSum, long currentSum) {
        if(node == null) {
            return;
        }

        
        currentSum = currentSum + node.val;
        //System.out.println("currentNode=" + node.val + ",sum = " + currentSum);
        if(currentSum == targetSum) {
            count++;
        }

        dfs(node.left, targetSum, currentSum);
        dfs(node.right, targetSum, currentSum);

        return;
    }
}

/**
모든 경로를 탐색해야함. 1. DFS 2. BFS 이 문제에서는 당연히 DFS가 편하겠지
DFs -> 스택, 재귀. 아마 재귀로 하는 것이 일반적일 것.
지금까지의 합을 계산하면서 동일하면 리턴. 그런데 들어가서 -랑 결합되면 또 같아질 수도 있잖아. 종료조건이 애마하네 일단 모두 다 살펴보는 것은 맞는듯?
그러면.. 배열을 같이 넘겨주고 노드마다 그거를 더해서 확인해보는 것은 어떤가? 굳이 처음부터 계산할 필요도 없고 그냥 마지막 값만 딱 추가해서 값을 비교하면 되잖아/
그런데 배열 자체가 필요없는 것ㅇ 아닌가? 왜냐함하면 그 전까지의 합을 더한 것을 저장해놓고 비교하면 되잖아. 그리고 같으면 카운트 하면되고.. 너무 쉬운데??? 리턴조건은 뭐 다 살펴보면 리턴이지 ㅋㅋ

흠 지금 문제는 기존코드에서는 무조건 루트부터 더해와서 값이 같은 것을 찾는 거였는데, 실제로 구하고자 하는 것은 그것이 아니라 모든 경로를  찾는 거임.
그렇다는 것은 매 노드에서 그 노드로부터 출발하는 경로를 또 뻗어 나가게 해야함.
 */