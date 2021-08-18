import java.util.*;

public class BSTTraversal {

    
    /** 
     * @param tree
     * @param array
     * @return List<Integer>
     */
    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree.left != null) inOrderTraverse(tree.left, array); 
        array.add(tree.value); 
        if (tree.right != null) inOrderTraverse(tree.right, array); 
        return new ArrayList<Integer>();
    }

    
    /** 
     * @param tree
     * @param array
     * @return List<Integer>
     */
    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        array.add(tree.value); 
        if (tree.left != null) preOrderTraverse(tree.left, array); 
        if (tree.right != null) preOrderTraverse(tree.right, array); 
        return new ArrayList<Integer>();
    }

    
    /** 
     * @param tree
     * @param array
     * @return List<Integer>
     */
    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if (tree.left != null) preOrderTraverse(tree.left, array); 
        if (tree.right != null) preOrderTraverse(tree.right, array); 
        array.add(tree.value); 
        return new ArrayList<Integer>();
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
