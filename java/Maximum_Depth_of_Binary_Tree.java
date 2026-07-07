/**
 * LeetCode #104 - Maximum Depth of Binary Tree
 *
 * Problem:
 *   Given the root of a binary tree, return its maximum depth.
 *   The maximum depth is the number of nodes along the longest path from the
 *   root node down to the farthest leaf node.
 *
 * Approach 1 – Recursive DFS (what we use below):
 *   - Base case: if node is null, depth is 0.
 *   - Recursively compute depth of left and right subtrees.
 *   - Answer = 1 + max(leftDepth, rightDepth).
 *
 * Approach 2 – Iterative BFS (level-order traversal):
 *   - Use a queue; count the number of levels processed.
 *
 * Time Complexity : O(n)  — every node is visited once
 * Space Complexity: O(h)  — h = height of tree (call stack); worst case O(n)
 */
public class Maximum_Depth_of_Binary_Tree {

    // ── TreeNode definition ───────────────────────────────────────────────────
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // ── Solution ──────────────────────────────────────────────────────────────

    /**
     * Approach 1: Recursive DFS
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth  = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    /**
     * Approach 2: Iterative BFS using a queue
     * Kept as an alternative to showcase both common patterns.
     */
    public int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left  != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return depth;
    }

    // ── Driver ────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        Maximum_Depth_of_Binary_Tree sol = new Maximum_Depth_of_Binary_Tree();

        /*
         * Example 1:
         *        3
         *       / \
         *      9  20
         *        /  \
         *       15   7
         * Expected depth: 3
         */
        TreeNode root1 = new TreeNode(3);
        root1.left  = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left  = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Example 1 (DFS): " + sol.maxDepth(root1));    // 3
        System.out.println("Example 1 (BFS): " + sol.maxDepthBFS(root1)); // 3

        /*
         * Example 2:
         *   1
         *    \
         *     2
         * Expected depth: 2
         */
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        System.out.println("Example 2 (DFS): " + sol.maxDepth(root2));    // 2
        System.out.println("Example 2 (BFS): " + sol.maxDepthBFS(root2)); // 2

        /*
         * Example 3: null tree
         * Expected depth: 0
         */
        System.out.println("Example 3 (DFS): " + sol.maxDepth(null));     // 0
        System.out.println("Example 3 (BFS): " + sol.maxDepthBFS(null));  // 0
    }
}
