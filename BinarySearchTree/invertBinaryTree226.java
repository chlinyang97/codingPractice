package codingPractice.BinarySearchTree;

import java.util.*;

class Solution {
    public TreeNode invertTreeNode (TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTreeNode(root.left);
        TreeNode right = invertTreeNode(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // Convert tree to list using level-order (BFS) traversal
    public List<Integer> treeToList(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Solution solution = new Solution();

        TreeNode invertedRoot = solution.invertTreeNode(root);

        List<Integer> invertedTreeList = solution.treeToList(invertedRoot);
        List<Integer> expectedInvertedTree = Arrays.asList(1, 3, 2, 6, 5, 4);

        boolean isCorrect = invertedTreeList.equals(expectedInvertedTree) ;
        System.out.println("Inverted tree structure is correct: " + isCorrect);
//        System.out.println(expectedInvertedTree);
//        System.out.println(invertedTreeList);
    }
}