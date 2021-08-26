import java.util.*; 

public class InvertBinaryTree {


    
    /** 
     * Recursive solution 
     * 
     * O(n) time | O(height) 
     * @param tree
     */
    public static void recursiveInvertBinaryTree(BinaryTree tree) { 
        if (tree == null) return;  

        swapLeftAndRight(tree);  
        recursiveInvertBinaryTree(tree.left);  
        recursiveInvertBinaryTree(tree.right); 
    }

    
    /**
     * Iteratuve verson of the solution  
     * O(n) time | O(n) space
     * @param tree
     */

    public static void invertBinaryTree(BinaryTree tree) {
        ArrayDeque<BinaryTree> queue = new ArrayDeque<BinaryTree>();
        queue.addLast(tree); // first add the root node

        while (queue.size() > 0) {
            BinaryTree current = queue.pollFirst();
            swapLeftAndRight(current);
            if (current.left != null) {
                queue.addLast(current.left);
            }
            if (current.right != null) {
                queue.addLast(current.right);
            }
        }
    }

    
    /** 
     * Swap the left and right node of parent node tree 
     * @param tree
     */
    private static void swapLeftAndRight(BinaryTree tree) {
        BinaryTree left = tree.left;
        tree.left = tree.right;
        tree.right = left;
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
