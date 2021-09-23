public class MaxPathSumInBinaryTree {
    public static NodeValues findMaxSum(BinaryTree tree) {
        if (tree == null) {
            int maxSumAsBranch = 0;
            int runningMaxSum = Integer.MIN_VALUE;
            return new NodeValues(maxSumAsBranch, runningMaxSum);
        }
        NodeValues leftSubTree = findMaxSum(tree.left);
        NodeValues rightSubTree = findMaxSum(tree.right);

        // Compute maximum child sum as branch
        int maxChildSumAsBranch = Math.max(leftSubTree.maxSumAsBranch, rightSubTree.maxSumAsBranch);
        int value = tree.value;
        int maxSumAsBranch = Math.max(maxChildSumAsBranch + value, value); // If maxChildSumAsBranch is negative then
                                                                           // skip it.
        int maxSumAsRootNode = Math.max(leftSubTree.maxSumAsBranch + value + rightSubTree.maxSumAsBranch,
                maxSumAsBranch);
        int runningMaxPathSum = Math.max(Math.max(leftSubTree.runningMaxSum, rightSubTree.runningMaxSum),
                maxSumAsRootNode);

        return new NodeValues(maxSumAsBranch, runningMaxPathSum);
    }

    public static int maxPathSum(BinaryTree tree) {

        return findMaxSum(tree).runningMaxSum;
    }

    static class NodeValues {
        public int maxSumAsBranch;
        public int runningMaxSum;

        public NodeValues(int maxSumAsBranch, int runningMaxSum) {
            this.maxSumAsBranch = maxSumAsBranch;
            this.runningMaxSum = runningMaxSum;
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
