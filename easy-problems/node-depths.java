import java.util.*;

import javax.annotation.processing.SupportedSourceVersion;

class NodeDepths {

    
    /** 
     * Helper method for nodeDepths 
     * 
     * @param root
     * @param nodeDepth
     * @param totalDepth
     */
    public static int calculateNodeDepth(BinaryTree root, int nodeDepth) { 
        if (root == null)
            return 0; 

        int currentNodeDepth = nodeDepth + 1;  

        return nodeDepth + calculateNodeDepth(root.left, currentNodeDepth) + 
        calculateNodeDepth(root.right, currentNodeDepth); 
    }
    
    /** 
     * Distance between a node in a binary tree and a root is called a node's depth. 
     * This takes in a binary tree and returns the sum of it's node depths 
     * 
     * O(n) time complexity; O(n) space complexity
     * 
     * @param root
     * @return int
     */
    public static int nodeDepths(BinaryTree root) {
        int nodeDepth = 0; 
        return calculateNodeDepth(root, nodeDepth); 
    }


    public static int nodeDepthsIterativeSolution(BinaryTree root) { 
        Queue<Level> queue = new LinkedList<Level>(); 

        queue.add(new Level(root, 0));   // first add root node with a level of 0
        int totalDepth = 0; 

        while (!queue.isEmpty()) { 
            Level currentLevel = queue.remove();  
            BinaryTree currentNode = currentLevel.root; 
            int currentDepth = currentLevel.depth; 
            if (currentLevel.root == null) continue; 
            System.out.println("We are currently on node " + currentLevel.root.value + " level " + currentDepth); 
            totalDepth += currentDepth; 
            queue.add(new Level(currentNode.left, currentDepth + 1)); 
            queue.add(new Level(currentNode.right, currentDepth + 1));   
        }
           
        return totalDepth;  // the root doesn't count. 
    }

    // Pair node with it's depth (dist from root.)
    static class Level { 
        public BinaryTree root; 
        int depth; 
        
        public Level(BinaryTree root, int depth) { 
            this.root = root; 
            this.depth = depth; 
        }
    }


    public static int nodeDepthsWithStack(BinaryTree root) { 
        int sumOfDepths = 0; 
        List<Level> stack = new ArrayList<Level>(); 
        stack.add(new Level(root, 0)); 

        while (stack.size() > 0) { 
            Level top = stack.remove(stack.size() - 1);  // take from the most recent 
            BinaryTree node = top.root; 
            int depth = top.depth;  
            if (node == null) continue;  // we didn't do an explicit check for null so they may exist here. 
            sumOfDepths += depth; 
            stack.add(new Level(node.left, depth + 1)); 
            stack.add(new Level(node.right, depth + 1)); 
        }
        return sumOfDepths; 
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) { 
        BinaryTree root = new BinaryTree(1); 
        root.left = new BinaryTree(2); 
        root.right = new BinaryTree(3); 
        root.left.left = new BinaryTree(4); 
        root.left.right = new BinaryTree(5); 
        root.right.left = new BinaryTree(6); 
        root.right.right = new BinaryTree(7); 
        root.left.left.left = new BinaryTree(8); 
        root.left.left.right = new BinaryTree(9); 
        System.out.println(nodeDepthsIterativeSolution(root));
    }
}
