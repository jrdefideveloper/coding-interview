import java.util.*;

class Problem8 {
    /** 
     * @param tree
     * @param min
     * @param max
     * @return boolean
     */
    public static boolean validateBstRecursiveHelper(BST tree, int min, int max) { 
        if (tree == null)
            return true; 
        if (tree.value < min || tree.value >= max) { 
           return false; 
        } 
        boolean leftIsValid = validateBstRecursiveHelper(tree.left, min, tree.value); 
        return leftIsValid && validateBstRecursiveHelper(tree.right, tree.value, max); 
    }

    
    /** 
     * @param tree
     * @return boolean
     */
    public static boolean validateBstRecursive(BST tree) {
        return validateBstRecursiveHelper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE); 
    }

    
    /** 
     * Time: O(n), Space: O(n)
     * This assumes everything is unique. 
     * @param tree
     * @return boolean
     */
    public static boolean validateBstIterative(BST tree) {
        Stack<BST> stack = new Stack<BST>();
        BST currentNode = tree;
        queue.add(tree); // first add the root node
        int prev = Integer.MIN_VALUE;

        while (!stack.isEmpty) {
            if (currentNode.left != null) {
                tree = tree.left;
                queue.add(tree);
            } else {
                currentNode = queue.remove();
                if (currentNode.value < prev)
                    return false;
                prev = currentNode.value;
                currentNode = currentNode.right;
            }
        }
        return true;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
