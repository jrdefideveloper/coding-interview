import java.util.*; 

public class RemoveIslands {


    /** 
     * @param matrix
     * @param x
     * @param y
     * @return List<Integer[]>
     */
    public static List<Integer[]> getNeighbors(int[][] matrix, int x, int y) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        ArrayList<Integer[]> neighbors = new ArrayList<Integer[]>();

        if (x - 1 >= 0) { // UP - only top row can't go up anymore
            neighbors.add(new Integer[] { x - 1, y });
        }
        if (x + 1 < numRows) { // DOWN - only last row can't go down anymore
            neighbors.add(new Integer[] { x + 1, y });
        }
        if (y - 1 >= 0) { // LEFT
            neighbors.add(new Integer[] { x, y - 1 });
        }
        if (y + 1 < numCols) { // RIGHT
            neighbors.add(new Integer[] { x, y + 1 });
        }
        return neighbors;
    }

    
    /** 
     * @param matrix
     * @param x
     * @param y
     */
    public static void changeBorderedIslandToTwo(int[][] matrix, int x, int y) {
        Stack<Integer[]> nodesToExplore = new Stack<Integer[]>();
        nodesToExplore.push(new Integer[] { x, y });
        while (!nodesToExplore.isEmpty()) {
            Integer[] currentNode = nodesToExplore.pop();
            x = currentNode[0];
            y = currentNode[1];
            matrix[x][y] = 2;
            List<Integer[]> neighbors = getNeighbors(matrix, x, y);
            for (Integer[] neighbor : neighbors) {
                int row = neighbor[0];
                int col = neighbor[1];
                if (matrix[row][col] != 1)
                    continue;
                nodesToExplore.push(neighbor);
            }
        }
    }

    
    /** 
     * @param matrix
     * @return int[][]
     */
    public static int[][] removeIslands(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                // border logic
                boolean isBorder = (i == 0 || i == rowCount - 1 || j == 0 || j == colCount - 1);
                if (isBorder && matrix[i][j] == 1)
                    changeBorderedIslandToTwo(matrix, i, j);
            }
        }

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                int color = matrix[row][col];
                if (color == 1) {
                    matrix[row][col] = 0;
                } else if (color == 2) {
                    matrix[row][col] = 1;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) { 
        int[][] input =
        new int[][] {
          {1, 0, 0, 0, 0, 0},
          {0, 1, 0, 1, 1, 1},
          {0, 0, 1, 0, 1, 0},
          {1, 1, 0, 0, 1, 0},
          {1, 0, 1, 1, 0, 0},
          {1, 0, 0, 0, 0, 1},
        };
        int[][] expected =
        new int[][] {
          {1, 0, 0, 0, 0, 0},
          {0, 0, 0, 1, 1, 1},
          {0, 0, 0, 0, 1, 0},
          {1, 1, 0, 0, 1, 0},
          {1, 0, 0, 0, 0, 0},
          {1, 0, 0, 0, 0, 1},
        };
        int[][] actual = removeIslands(input);  

        for (int i = 0; i < actual.length; i++)  { 
            for (int j = 0; j < actual[0].length; j++) { 
                if (actual[i][j] != expected[i][j]) {  
                    System.out.println("Solution is wrong at coordinate " + i + ", " + j); 
                }
            }
        }
        System.out.println("Booyah");

    }

}
