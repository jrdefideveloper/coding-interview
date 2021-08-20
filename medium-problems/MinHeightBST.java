import java.util.*;

public class MinHeightBST {
    
    /** 
     * O(nlogn) time | O(n) space 
     * @param array
     * @param root
     * @param startIdx
     * @param endIdx
     * @return BST
     */
    public static BST constructMinHeightBST(List<Integer> array, BST root, int startIdx, int endIdx) {
        if (endIdx < startIdx)
            return null;

        int midIdx = (startIdx + endIdx) / 2;
        int valueToAdd = array.get(midIdx);
        if (root == null) {
            root = new BST(valueToAdd);
        } else {
            root.insert(valueToAdd);
        }
        constructMinHeightBST(array, root, startIdx, midIdx - 1);
        constructMinHeightBST(array, root, midIdx + 1, endIdx);
        return root;
    }

    
    /** 
     * @param array
     * @return BST
     */
    public static BST minHeightBst(List<Integer> array) {
        return constructMinHeightBST(array, null, 0, array.size() - 1);
    }


    
    /** 
     * @param array
     * @return BST
     */
    public static BST minHeightBstCleaner(List<Integer> array) {
        return constructMinHeightBSTCleaner(array, 0, array.size() - 1);
    }

    
    /** 
     * Condensed some more 
     * O(n) time | O(n) space 
     * Avoid using the the insertion method which takes another log n time  
     * @param array
     * @param startIdx
     * @param endIdx
     * @return BST
     */
    public static BST constructMinHeightBSTCleaner(List<Integer> array, int startIdx, int endIdx) {
     	if (endIdx < startIdx) return null; // still need base case 
		int midIdx = (startIdx + endIdx) / 2; 
		BST bst = new BST(array.get(midIdx));
		bst.left = constructMinHeightBSTCleaner(array, startIdx, midIdx - 1); 
	 	bst.right = constructMinHeightBSTCleaner(array, midIdx + 1, endIdx); 
		return bst; 
    }

   

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

    public static void main(String[] args) { 

    }

}
