import java.util.*; 

public class ReconstructBST {


    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        public int rootIdx;

        public TreeInfo(int rootIdx) {
            this.rootIdx = rootIdx;
        }
    }

    
    /** 
     * O(n) time | O(n) space 
     * @param preOrderTraversalValues
     * @return BST
     */
    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        TreeInfo treeInfo = new TreeInfo(0);
        return reconstructBSTFromRange(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues, treeInfo);
    }

    
    /** 
     * @param lowerBound
     * @param upperBound
     * @param preOrderTraversalValues
     * @param currentSubtreeInfo
     * @return BST
     */
    public BST reconstructBSTFromRange(int lowerBound, int upperBound, List<Integer> preOrderTraversalValues,
            TreeInfo currentSubtreeInfo) {
        if (currentSubtreeInfo.rootIdx == preOrderTraversalValues.size()) {
            return null; // overflowed out of the list
        }

        int rootValue = preOrderTraversalValues.get(currentSubtreeInfo.rootIdx);
        if (rootValue < lowerBound || rootValue >= upperBound) {
            return null;
        }
        currentSubtreeInfo.rootIdx += 1;
        BST leftSubtree = reconstructBSTFromRange(lowerBound, rootValue, preOrderTraversalValues, currentSubtreeInfo);
        BST rightSubtree = reconstructBSTFromRange(rootValue, upperBound, preOrderTraversalValues, currentSubtreeInfo);
        BST bst = new BST(rootValue);
        bst.left = leftSubtree;
        bst.right = rightSubtree;
        return bst;
    }

}
