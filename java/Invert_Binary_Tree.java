/**
 * LC #226 - Invert Binary Tree
 *
 * Problem:
 *   Given the root of a binary tree, invert the tree (mirror it), and return its root.
 *
 * Example:
 *   Input:  [4,2,7,1,3,6,9]
 *   Output: [4,7,2,9,6,3,1]
 *
 * Approach — DFS (Recursive):
 *   At every node, swap its left and right children, then recurse into both subtrees.
 *   Base case: null node → return null.
 *
 * Complexity:
 *   Time  : O(n) — every node is visited exactly once.
 *   Space : O(h) — call stack depth equals tree height h (O(log n) balanced, O(n) worst).
 */
public class Invert_Binary_Tree {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Inverts the binary tree rooted at {@code root}.
     *
     * @param root the root of the binary tree
     * @return root of the inverted (mirrored) tree
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recurse into both subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    // ── Quick smoke test ──────────────────────────────────────────────────────
    public static void main(String[] args) {
        Invert_Binary_Tree sol = new Invert_Binary_Tree();

        //       4
        //      / \
        //     2   7
        //    / \ / \
        //   1  3 6  9
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));

        TreeNode inverted = sol.invertTree(root);

        // Expected level-order: 4, 7, 2, 9, 6, 3, 1
        System.out.println("Root      : " + inverted.val);           // 4
        System.out.println("Left      : " + inverted.left.val);      // 7
        System.out.println("Right     : " + inverted.right.val);     // 2
        System.out.println("Left-Left : " + inverted.left.left.val); // 9
    }
}
