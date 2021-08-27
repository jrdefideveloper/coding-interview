public class HeightBalancedTree {
    
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        boolean isBalanced;
        int height;

        public TreeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(true, -1);
        }

        TreeInfo leftTreeInfo = getTreeInfo(tree.left);
        TreeInfo rightTreeInfo = getTreeInfo(tree.right);

        boolean isBalanced = (Math.abs(leftTreeInfo.height - rightTreeInfo.height) <= 1) && leftTreeInfo.isBalanced
                && rightTreeInfo.isBalanced;

        int height = Math.max(leftTreeInfo.height, rightTreeInfo.height) + 1;
        return new TreeInfo(isBalanced, height);
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        return getTreeInfo(tree).isBalanced;
    }
}
