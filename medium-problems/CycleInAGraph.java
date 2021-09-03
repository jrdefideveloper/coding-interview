public class CycleInAGraph {

    // o(v + e) time | o(v) space 
    public static boolean cycleInGraph(int[][] edges) {
        int numberOfNodes = edges.length; 
        boolean[] visited = new boolean[numberOfNodes]; 
        boolean[] inStack = new boolean[numberOfNodes]; 

        boolean containsCycle = false; 
        for (int node = 0; node < numberOfNodes; node++) { 
            containsCycle = isNodeInCycle(node, edges, visited, inStack); 
            if (containsCycle) return true; 
        }
        return false;
    }

    public static boolean isNodeInCycle(int node, int[][] edges, boolean[] visited, boolean[] inStack) { 
        visited[node] = true; 
        inStack[node] = true; 

        boolean containsCycle = false; 
        int[] neighbors = edges[node];  

        for (int neighborNode : neighbors) { 
            if (!visited[node]) { 
                containsCycle = isNodeInCycle(neighborNode, edges, visited, inStack); 
            } 
            if (containsCycle) { 
                return true; 
            } else if (inStack[node]) { 
                return true; 
            }
        }
        inStack[node] = false; 
        return false; 
    }

    public static void main(String[] args) { 

    }
}
