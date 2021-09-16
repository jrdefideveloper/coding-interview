public class SearchInSortedMatrix {
    
    // start at the top right (row = 0; col = matrix[0].length )
    // O(n + m) time | O(1) space
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return new int[] { row, col };
            }
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) { 
    }

}
