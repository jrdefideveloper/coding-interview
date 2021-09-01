public class YoungestCommonAncestor {

    
    /** 
     * @param node
     * @return int
     */
    public static int getDepth(AncestralTree node) {
        int depth = 0;
        while (node.ancestor != null) {
            node = node.ancestor;
            depth++;
        }
        return depth;
    }

    
    /** 
     * @param lowerDesc
     * @param higherDesc
     * @param diff
     * @return AncestralTree
     */
    public static AncestralTree backtrackAncestralTree(AncestralTree lowerDesc, AncestralTree higherDesc, int diff) {
        while (diff > 0) {
            lowerDesc = lowerDesc.ancestor;
            diff--;
        }
        while (lowerDesc != higherDesc) {
            lowerDesc = lowerDesc.ancestor;
            higherDesc = higherDesc.ancestor;
        }
        return lowerDesc;
    }

    
    /** 
     * O(depth) time | O(1) space 
     * @param topAncestor
     * @param descendantOne
     * @param descendantTwo
     * @return AncestralTree
     */
    public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne,
            AncestralTree descendantTwo) {

        int depthOne = getDepth(descendantOne);
        int depthTwo = getDepth(descendantTwo);

        if (depthOne > depthTwo) {
            return backtrackAncestralTree(descendantOne, descendantTwo, depthOne - depthTwo);
        } else {
            return backtrackAncestralTree(descendantTwo, descendantOne, depthTwo - depthOne);
        }
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

    public static void main(String[] args) {

    }

}
