public class SubarraySort {

    // If one number is out of order it can cause a huge subarray to need sorting
    // [1, 2, 3, 4, 5, -1] -> [0, 5] everything needs to be sorted
    // Find all unsorted numbers and find greatest one and smallest one

    /** 
     * This helper helps with case in which index is 0, last and an index in between 
     * 
     * @param i
     * @param num
     * @param array
     * @return boolean
     */
    public static boolean isOutOfOrder(int i, int num, int[] array) {
        if (i == 0) {
            return num > array[i + 1];
        }
        if (i == array.length - 1) {
            return num < array[i - 1];
        }
        return num > array[i + 1] || num < array[i - 1];
    }

    
    /** 
     * O(n) time | O(1) space 
     * @param array
     * @return int[]
     */
    public static int[] subarraySort(int[] array) {
        int minUnsortedNumber = Integer.MAX_VALUE;
        int maxUnsortedNumber = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (isOutOfOrder(i, array[i], array)) {
                minUnsortedNumber = Math.min(minUnsortedNumber, array[i]);
                maxUnsortedNumber = Math.max(maxUnsortedNumber, array[i]);
            }
        }
        if (minUnsortedNumber == Integer.MAX_VALUE) {
            return new int[] { -1, -1 };
        }
        int startIdx = 0;
        while (startIdx < array.length) {
            if (array[startIdx] > minUnsortedNumber) {
                break;
            }
            startIdx++;
        }
        int endIdx = array.length - 1;
        while (endIdx > 0) {
            if (array[endIdx] <= maxUnsortedNumber) {
                break;
            }
            endIdx--;
        }
        return new int[] { startIdx, endIdx };
    }

}
