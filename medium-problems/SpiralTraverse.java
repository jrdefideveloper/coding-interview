import java.util.*;

public class SpiralTraverse {

    /**
     * O(n) total number of elements in the 2d array traversing everything once |
     * O(n) space
     * 
     * @param array
     * @return List<Integer>
     */
    public static List<Integer> spiralTraverse(int[][] array) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        int startRow = 0;
        int endRow = array.length - 1;
        int startCol = 0;
        int endCol = array[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {

            // top border
            for (int col = startCol; col <= endCol; col++) {
                result.add(array[startRow][col]);
            }

            // right border
            for (int row = startRow + 1; row <= endRow; row++) {
                result.add(array[row][endCol]);
            }

            // bottom border
            for (int col = endCol - 1; col >= startCol; col--) {
                if (startRow == endRow)
                    break;
                result.add(array[endRow][col]);
            }

            // left border
            for (int row = endRow - 1; row > startRow; row--) {
                if (startRow == endCol)
                    break;
                result.add(array[row][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] testcase = new int[3][4]; 
        testcase[0] = new int[]{1, 2, 3}; 
        testcase[1] = new int[]{12, 13, 4}; 
        testcase[2] = new int[]{11, 14, 5}; 

        List<Integer> spiralResult = spiralTraverse(testcase); 
        for (Integer num : spiralResult) { 
            System.out.print(num + " ");
        }
    }
}
