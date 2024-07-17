class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        findLeaf(root1, arr1);
        findLeaf(root2, arr2);

        return arr1.equals(arr2);
    }


    private void findLeaf(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            arr.add(node.val);
            return;
        }
        findLeaf(node.left, arr);
        findLeaf(node.right, arr);
    }
}