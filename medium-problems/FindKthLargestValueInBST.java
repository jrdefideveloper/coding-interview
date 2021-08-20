import java.util.*; 

public class FindKthLargestValueInBST {

    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    // O(n) time | O(n) space
    public static void inOrderTraversal(BST node, ArrayList<Integer> list) {
        if (node.left != null)
            inOrderTraversal(node.left, list);
        list.add(node.value);
        if (node.right != null)
            inOrderTraversal(node.right, list);
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        ArrayList<Integer> flatList = new ArrayList<Integer>();
        inOrderTraversal(tree, flatList);

        return flatList.get(flatList.size() - k);
    }

}
