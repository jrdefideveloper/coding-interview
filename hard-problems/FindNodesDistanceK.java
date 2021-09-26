import java.util.*; 

public class FindNodesDistanceK {
    /*
     * Solution 1: 
     * 1. Find all parent nodes. Map node values to their parent nodes.
     * 2. Add to queue the target node with a distance of 0 
     * 3. Pop queue and add neighboring nodes into the queue with distances  
     * 4. When the k = k distance then we are done 
     */

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class Pair<U, V> {
        public final U first;
        public final V second;

        private Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    
    /** 
     * Main function 
     * O(n) time | O(n) space 
     * 
     * @param tree
     * @param target
     * @param k
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        HashMap<Integer, BinaryTree> nodesToParent = new HashMap<Integer, BinaryTree>();
        populateNodesToParents(tree, nodesToParent, null);
        BinaryTree targetNode = getNodeFromValue(target, tree, nodesToParent);
        return bfsForNodesDistanceK(targetNode, nodesToParent, k);
    }

    
    /** 
     * Do bfs out from the target node (node.left, node.right, node.parent)
     * 
     * @param targetNode
     * @param nodesToParents
     * @param k
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> bfsForNodesDistanceK(BinaryTree targetNode, HashMap<Integer, BinaryTree> nodesToParents,
            int k) {

        Queue<Pair<BinaryTree, Integer>> queue = new LinkedList<Pair<BinaryTree, Integer>>();
        queue.offer(new Pair<BinaryTree, Integer>(targetNode, 0));

        HashSet<Integer> seen = new HashSet<Integer>(targetNode.value);
        seen.add(targetNode.value); // Always be 0 distance away from yourself...

        while (queue.size() > 0) {
            Pair<BinaryTree, Integer> vals = queue.poll();
            BinaryTree currentNode = vals.first;
            int distanceFromTarget = vals.second;

            if (distanceFromTarget == k) {
                ArrayList<Integer> nodeDistanceK = new ArrayList<Integer>();
                for (Pair<BinaryTree, Integer> pair : queue) {
                    nodeDistanceK.add(pair.first.value);
                }
                nodeDistanceK.add(currentNode.value);
                return nodeDistanceK;
            }

            List<BinaryTree> connectedNodes = new ArrayList<BinaryTree>();
            connectedNodes.add(currentNode.left);
            connectedNodes.add(currentNode.right);
            connectedNodes.add(nodesToParents.get(currentNode.value));

            for (BinaryTree node : connectedNodes) {
                if (node == null)
                    continue;
                System.out.println("connect node found value is " + node.value);
                if (seen.contains(node.value))
                    continue;

                seen.add(node.value);
                queue.add(new Pair<BinaryTree, Integer>(node, distanceFromTarget + 1));

            }
            System.out.println("");
        }
        return new ArrayList<Integer>();
    }

    
    /** 
     * Find the target node  
     * 
     * @param value
     * @param tree
     * @param nodesToParent
     * @return BinaryTree
     */
    public BinaryTree getNodeFromValue(int value, BinaryTree tree, HashMap<Integer, BinaryTree> nodesToParent) {

        if (tree.value == value)
            return tree; // The passed in node is the right node

        BinaryTree nodeParent = nodesToParent.get(value);
        if (nodeParent.left != null && nodeParent.left.value == value)
            return nodeParent.left;

        return nodeParent.right;
    }

    
    /** 
     * Map all the nodes to their parents;  
     * 
     * @param node
     * @param nodesToParents
     * @param parent
     */
    public void populateNodesToParents(BinaryTree node, Map<Integer, BinaryTree> nodesToParents, BinaryTree parent) {
        if (node != null) {
            nodesToParents.put(node.value, parent);
            populateNodesToParents(node.left, nodesToParents, node);
            populateNodesToParents(node.right, nodesToParents, node);
        }
    }
}
