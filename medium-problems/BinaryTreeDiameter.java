import java.util.*; 
public class BinaryTreeDiameter {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    
    /** 
     * currentDiameter may take the diameter of a previous node 
     * @param tree
     * @return int
     */
    public int binaryTreeDiameter(BinaryTree tree) {
        return getTreeInfo(tree).diameter;
    }

    
    /** 
     * @param tree
     * @return TreeInfo
     */
    public TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree != null)
            System.out.println("getTreeInfo(" + tree.value + ")");
        if (tree == null) {
            System.out.println("getTreeInfo(null)");
            return new TreeInfo(0, 0);
        }

        TreeInfo leftTreeInfo = getTreeInfo(tree.left);
        TreeInfo rightTreeInfo = getTreeInfo(tree.right);

        int longestPathThroughRoot = leftTreeInfo.height + rightTreeInfo.height;
        int maxDiameterSoFar = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter);
        int currentDiameter = Math.max(longestPathThroughRoot, maxDiameterSoFar);
        int currentHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);

        System.out.println(
                "currentDiameter= " + currentDiameter + ", currentHeight=" + currentHeight + " for node " + tree.value);
        return new TreeInfo(currentDiameter, currentHeight);
    }

    static class TreeInfo {
        public int diameter;
        public int height;

        public TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

}
