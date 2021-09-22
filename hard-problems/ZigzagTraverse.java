import java.util.*; 

public class ZigzagTraverse {

    /** 
     * O(n) time | O(1) space 
     * 
     * @param array
     * @return List<Integer>
     */
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        int height = array.size() - 1;
        int width = array.get(0).size() - 1;
        List<Integer> result = new ArrayList<Integer>();
        int row = 0;
        int col = 0;
        boolean goingDown = true;
        while (!isOutOfBounds(row, col, height, width)) {
            result.add(array.get(row).get(col));
            if (goingDown) {
                if (col == 0 || row == height) {
                    goingDown = false;
                    if (row == height) {
                        col++;
                    } else {
                        row++;
                    }
                } else {
                    row++;
                    col--;
                }
            } else {
                if (row == 0 || col == width) {
                    goingDown = true;
                    if (col == width) {
                        row++;
                    } else {
                        col++;
                    }
                } else {
                    row--;
                    col++;
                }
            }

        }
        return result;
    }
    
    /** 
     * @param row
     * @param col
     * @param height
     * @param width
     * @return boolean
     */
    public static boolean isOutOfBounds(int row, int col, int height, int width) {
        return row < 0 || row > height || col < 0 || col > width;
    }

    public static void main(String[] args) { 
        List<List<Integer>> array = new ArrayList<List<Integer>>();  
        ArrayList<Integer> firstRow = new ArrayList<>(Arrays.asList(1, 3, 4, 10)); 
        ArrayList<Integer> secondRow = new ArrayList<>(Arrays.asList(2, 5, 9, 11));
        ArrayList<Integer> thirdRow = new ArrayList<>(Arrays.asList(6, 8, 12, 15));
        ArrayList<Integer> fourthRow = new ArrayList<>(Arrays.asList(7, 13, 14, 16));
        array.add(firstRow); 
        array.add(secondRow);
        array.add(thirdRow);
        array.add(fourthRow);
        List<Integer> zzresult = zigzagTraverse(array); 
        for (Integer num : zzresult) { 
            System.out.print(num + " "); 
        }

    }

}
