public class MonotonicArray {

    /**
     * O(n) time | O(1) space
     * 
     * @param array
     * @return boolean
     */
    public static boolean isMonotonic(int[] array) {
        // edge case no elements or 1 element is true
        if (array.length <= 1) {
            return true;
        }

        // First determine what order we are looking for based off of the first and last
        // number
        int firstNum = array[0];
        int lastNum = array[array.length - 1];
        boolean ascendingOrder;

        if (lastNum > firstNum) {
            ascendingOrder = true;
        } else {
            ascendingOrder = false;
        }

        for (int idx = 0; idx < array.length - 1; idx++) {
            if (ascendingOrder) {
                if (array[idx + 1] < array[idx]) {
                    return false;
                }
            } else {
                if (array[idx + 1] > array[idx]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] testcase1 = new int[] { -1, -5, -10, -1100, -1100, -1101, -1102, -9001 };
        System.out.println(isMonotonic(testcase1));

    }

}
