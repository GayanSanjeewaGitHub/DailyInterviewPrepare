package august4;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

  class MergeBinaryTrees {


    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        // Merge the values of t1 and t2.
        t1.val += t2.val;

        // Recursively merge the left and right children.
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }

    // Function to print tree in preorder (for verification).
    public static void printPreorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    // Helper function to insert nodes in the binary tree for the given preorder array.
    public static TreeNode buildTreeFromPreorder(int[] preorder, int[] index) {
        if (index[0] >= preorder.length || preorder[index[0]] == -1) {
            index[0]++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[index[0]++]);
        root.left = buildTreeFromPreorder(preorder, index);
        root.right = buildTreeFromPreorder(preorder, index);

        return root;
    }

    public static void main(String[] args) {
        // Example input: Preorder traversal of Tree 1 and Tree 2
        int[] preorder1 = {1, 3, 5, -1, -1, -1, 2, -1, -1};
        int[] preorder2 = {2, 1, 4, -1, -1, 3, -1, -1, 7, -1, -1};

        // Build the trees from preorder arrays.
        TreeNode tree1 = buildTreeFromPreorder(preorder1, new int[]{0});
        TreeNode tree2 = buildTreeFromPreorder(preorder2, new int[]{0});

        // Merge the trees.
        TreeNode mergedTree = mergeTrees(tree1, tree2);

        // Print the merged tree in preorder to verify the output.
        printPreorder(mergedTree);  // Expected output: 3 4 5 4 7 5
    }
}
