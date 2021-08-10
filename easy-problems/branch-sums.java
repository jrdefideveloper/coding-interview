import java.util.*;

class BranchSums {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * O(n) time | O(n) space Helper function for branchSums
     * 
     * O(n) space because number of branches is roughly number of leaf nodes which
     * is usually rougly nodes/2 O(n/2) ~ O(n)
     * 
     * @param node
     * @param runningSum
     * @param runningList
     * @return int
     */
    public static void calculateRunningSum(BinaryTree node, int runningSum, List<Integer> runningList) {
        if (node == null)
            return;
        int newRunningSum = node.value + runningSum;
        if (node.left == null && node.right == null) {
            runningList.add(newRunningSum);
            return;
        }
        calculateRunningSum(node.left, newRunningSum, runningList);
        calculateRunningSum(node.right, newRunningSum, runningList);
    }

    /**
     * Takes in a Binary tree and returns a list of it's branches sums. Ordered from
     * leftmost branch to right most branch. Branch = start at root all the way to
     * the leaf
     * 
     * O(n) time | O(n) space Helper function for branchSums
     * 
     * @param root
     * @return List<Integer>
     */
    public static List<Integer> branchSums(BinaryTree root) {
        // Every new level is 2^(level) = number of nodes
        List<Integer> sums = new ArrayList<>();

        calculateRunningSum(root, 0, sums);
        return sums;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);

        List<Integer> branchSums = branchSums(root);
        for (Integer num : branchSums) {
            System.out.println(num);
        }

    }

}
