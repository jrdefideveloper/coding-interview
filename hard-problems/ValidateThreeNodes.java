public class ValidateThreeNodes {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    // Determine which node is the ancestor and which is the ancestor
    // O(h) time | O(h) space
    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        if (isDescendent(nodeTwo, nodeOne)) {

            return isDescendent(nodeThree, nodeTwo);
        }

        if (isDescendent(nodeTwo, nodeThree)) {
            return isDescendent(nodeOne, nodeTwo);
        }
        return false;
    }

    public boolean isDescendent(BST node, BST target) {
        while (node != null && node != target) {
            node = (target.value) < node.value ? node.left : node.right;
        }
        return (node == target);
    }

}
