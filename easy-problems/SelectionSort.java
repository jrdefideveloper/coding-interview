import java.util.*;

class SelectionSort {

    /**
     * @param array
     * @param x
     * @param y
     */
    public static void swap(int[] array, int x, int y) {
        int temp = array[y];
        array[y] = array[x];
        array[x] = temp;
    }

    /**
     * O(n^2) time; O(1) complexity
     * 
     * @param array
     * @return int[]
     */
    public static int[] selectionSort(int[] array) {
        // Sorted and unsorted sublist.
        // In the beginning everything is unsorted.
        int currentIdx = 0;
        while (currentIdx < array.length - 1) {
            // Find index of the smallest number
            int smallestIdx = currentIdx;
            for (int i = currentIdx + 1; i < array.length; i++) {
                if (array[smallestIdx] > array[i]) {
                    smallestIdx = i;
                }
            }
            swap(array, currentIdx, smallestIdx);
            currentIdx++; // start of the unsorted sublist.
        }
        return array;
    }

    public static void main(String[] args) {
        int[] testcase = new int[] { 8, 5, 2, 9, 5, 6, 3 };
        int[] sorted = selectionSort(testcase);

        for (int i : sorted) {
            System.out.println(i);
        }
    }
}
