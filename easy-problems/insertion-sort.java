import java.util.*;

class InsertionSort {

    public static void swap(int[] array, int x, int y) {
        int temp = array[y];
        array[y] = array[x];
        array[x] = temp;
    }


    /**
     * Take in an array of integers and returns a sorted version of that array.  
     * O(n^2) | O(1) space 
     * 
     * @param array
     * @return int[]
     */
    public static int[] insertionSort(int[] array) {
        for (int i=1; i < array.length; i++) { 
            int j = i; 
            while (j > 0 && array[j] < array[j-1]) { 
                swap(array, j, j-1);  
                j-=1; 
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] testcase = new int[] { 8, 5, 2, 9, 5, 6, 3 };
        int[] sorted = insertionSort(testcase);
        for (int num : sorted) {
            System.out.println(num);
        }

    }

}
