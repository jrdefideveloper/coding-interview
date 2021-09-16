public class ThreeNumberSort {
    
    
    /** 
     * O(n) time | O(1) space 
     * 
     * Sort the given array in the same order as the given order array. 
     * 
     * @param array
     * @param order
     * @return int[]
     */
    public int[] threeNumberSort(int[] array, int[] order) {
        int firstValue = order[0];
        int thirdValue = order[2];
        int firstIdx = 0; // going to end at the last index of the first values subarray location
        int thirdIdx = array.length - 1; // first index of the last order value subarray location
        for (int idx = 0; idx < array.length; idx++) {
            if (array[idx] == firstValue) {
                swap(idx, firstIdx, array);
                firstIdx++;
            }
        }
        for (int idx = array.length - 1; idx >= firstIdx; idx--) {
            if (array[idx] == thirdValue) {
                swap(idx, thirdIdx, array);
                thirdIdx--;
            }
        }
        return array;
    }

    
    /** 
     * @param first
     * @param second
     * @param array
     */
    public void swap(int first, int second, int[] array) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
