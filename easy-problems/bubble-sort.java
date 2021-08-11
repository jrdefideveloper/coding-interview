import java.util.*;

class BubbleSort {

    public static void swap(int[] array, int x, int y) {
        int temp = array[y];
        array[y] = array[x];
        array[x] = temp;
    }

    /**
     * Sort a list of numbers in place with bubble sort
     * 
     * O(n) if already sorted.  
     * 
     * O(n^2) avg time; O(1) extra space. 
     * 
     * @param array
     * @return int[]
     */
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0)
            return new int[] {};
        int counter = 0;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1 - counter; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
            counter++;
        }
        return array;
    }

    public static void bubbleSortGFG(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    public static void main(String[] args) {
        int[] testcase = new int[] { 8, 5, 2, 9, 5, 6, 3 };
        int[] sorted = bubbleSort(testcase);

        for (int i : sorted) {
            System.out.println(i);
        }

    }

}
