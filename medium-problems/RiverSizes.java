import java.util.*;

public class RiverSizes {

    // O(1) time | O(1) space
    public static List<Integer[]> getUnvisitedNeighbors
        (int i, int j, int[][] matrix, boolean[][] visited) { 
            List<Integer[]> unvisitedNeighbors = new ArrayList<Integer[]>(); 
            // Check one above 
            if (i > 0 && !visited[i - 1][j]) { 
                unvisitedNeighbors.add(new Integer[]{i - 1, j}); 
            } 
            // Check one below
            if (i < matrix.length - 1 && !visited[i + 1][j]) { 
                unvisitedNeighbors.add(new Integer[]{i + 1, j}); 
            }
            // Check one left
            if (j > 0 && !visited[i][j - 1]) { 
                unvisitedNeighbors.add(new Integer[]{i, j - 1}); 
            }
            // Check one right 
            if (j < matrix[0].length - 1 && !visited[i][j + 1]) { 
                unvisitedNeighbors.add(new Integer[]{i, j + 1}); 
            }
            return unvisitedNeighbors; 
    }

    public static void traverseNodes(
        int i, int j, int[][] matrix, boolean[][] visited, List<Integer> riverSizes) { 
            int currentRiverSize = 0; 
            Stack<Integer[]> nodesToExplore = new Stack<Integer[]>(); 
            nodesToExplore.add(new Integer[]{i, j}); 

            while (!nodesToExplore.isEmpty()) { 
                Integer[] currentNode = nodesToExplore.pop(); 
                i = currentNode[0]; 
                j = currentNode[1]; 

                if (visited[i][j]) continue; 
                visited[i][j] = true; 
                if (matrix[i][j] == 0) continue;  
                currentRiverSize++; 
                List<Integer[]> neighbors = getUnvisitedNeighbors(i, j, matrix, visited); 
                for (Integer[] unvisitedNeighbor : neighbors) { 
                    nodesToExplore.add(unvisitedNeighbor);
                }
            }

            if (currentRiverSize > 0) 
                riverSizes.add(currentRiverSize); 
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];  
        List<Integer> riverSizes = new ArrayList<Integer>();  

        for (int widthIdx = 0; widthIdx < matrix.length; widthIdx++) { 
            for (int heightIdx = 0; heightIdx < matrix[0].length; heightIdx++) { 
                if (visited[widthIdx][heightIdx]) continue; 
                traverseNodes(widthIdx, heightIdx, matrix, visited, riverSizes);
            }
        }

        return riverSizes; 
    }

    public static void main(String[] args) {
        int[][] input = { { 1, 0, 0, 1, 0 }, { 1, 0, 1, 0, 0 }, { 0, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 0 }, };
        int[] expected = { 1, 2, 2, 2, 5 };
        List<Integer> output = riverSizes(input);
        Collections.sort(output);
        for (Integer num : output) {
            System.out.print(num + " ");
        }
    }

}
