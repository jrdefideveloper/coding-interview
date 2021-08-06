class FindClosestValueInBSTProblem {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    /**
     * Helper function for findClosestValueInBst()
     * 
     * @param tree
     * @param target
     * @param closest
     * @return int
     */
    public static int findClosestValueInBst(BST tree, int target, int closest) {
        // Always start with the base case. If you've reached the leaf node without
        // children you should've already arrived at your solution
        if (tree == null) {
            return closest;
        }

        // Update the closest node. The smaller the difference the closer we are to the
        // target.
        if (Math.abs(target - closest) > Math.abs(target - tree.value))
            closest = tree.value;

        // If target is smaller than tree.value then we should go left
        if (target < tree.value) {
            return findClosestValueInBst(tree.left, target, closest);
            // If target is larger than the tree.value then we should go right.
        } else if (target > tree.value) {
            return findClosestValueInBst(tree.right, target, closest);
            // Otherwise they are equal so we should return the current closest.
        } else {
            return closest;
        }

    }

    /**
     * O(logn) time complexity; O(logn) extra space complexity for the recursive
     * stack.
     * 
     * @param tree
     * @param target
     * @return int
     */
    public static int findClosestValueInBSTRecursive(BST tree, int target) {
        return findClosestValueInBst(tree, target, tree.value);
    }

    /**
     * Iterative solution
     * 
     * O(logn) time complexity; O(1) extra space complexity.
     * 
     * @param tree
     * @param target
     * @return int
     */
    public static int findClosestValueInBstBetterSpace(BST tree, int target) {
        // Initialize the best node as the root node.
        int closest = tree.value;
        BST current = tree;
        // While there are more nodes there may be a better node.
        while (current != null) {
            // If current node is closer to the target than the previous node update closest
            if (Math.abs(target - current.value) < Math.abs(target - closest)) {
                closest = current.value;
            }
            // If target node value is smaller than current node value you should go left
            if (target < current.value) {
                current = current.left;
                // If target node value is larger than current node you should go right.
            } else if (target > current.value) {
                current = current.right;
                // The last case they should be equal then you exit and return closest.
            } else {
                break;
            }
        }

        return closest;
    }

    public static void main(String[] args) {

    }
}