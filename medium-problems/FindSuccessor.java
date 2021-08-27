import java.util.*;

class FindSuccessor {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void inOrderTraverse(BinaryTree tree, List<BinaryTree> array) {
        if (tree.left != null)
            inOrderTraverse(tree.left, array);
        array.add(tree);
        if (tree.right != null)
            inOrderTraverse(tree.right, array);
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        ArrayList<BinaryTree> listNodes = new ArrayList<BinaryTree>();

        inOrderTraverse(tree, listNodes);

        for (BinaryTree binaryTree : listNodes) {
            System.out.println(binaryTree.value);
        }

        int currentIndex = listNodes.indexOf(node);

        return (currentIndex == -1 || currentIndex == listNodes.size() - 1) ? null : listNodes.get(currentIndex + 1);
    }

    public BinaryTree getRightMostParentNode(BinaryTree node) {

        BinaryTree currentNode = node;

        while (currentNode.parent != null && currentNode.parent.right == currentNode) {
            currentNode = currentNode.parent;
        }

        return currentNode.parent;
    }

    // Case in which you need to return the left most child of the right subtree
    public BinaryTree getLeftMostChildNode(BinaryTree node) {
        BinaryTree currentNode = node;

        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode;
    }

    // O(h) time | O(1) space 
    public BinaryTree findSuccessorFaster(BinaryTree tree, BinaryTree node) {
        if (node.right != null)
            return getLeftMostChildNode(node.right);
        return getRightMostParentNode(node);
    }

    public static void main(String[] args) {
        FindSuccessor.BinaryTree root = new FindSuccessor.BinaryTree(1);
        root.left = new FindSuccessor.BinaryTree(2);
        root.left.parent = root;
        root.right = new FindSuccessor.BinaryTree(3);
        root.right.parent = root;
        root.left.left = new FindSuccessor.BinaryTree(4);
        root.left.left.parent = root.left;
        root.left.right = new FindSuccessor.BinaryTree(5);
        root.left.right.parent = root.left;
        root.left.left.left = new FindSuccessor.BinaryTree(6);
        root.left.left.left.parent = root.left.left;
        FindSuccessor.BinaryTree node = root.left.right;
        FindSuccessor.BinaryTree expected = root;
        FindSuccessor.BinaryTree output = new FindSuccessor().findSuccessor(root, node);
        assert (expected == output);
    }

}
