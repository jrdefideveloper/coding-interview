public class FirstDuplicateValue {

    
    /** 
     * O(n) time | O(1) space 
     * 
     * @param array
     * @return int
     */
    public static int firstDuplicateValue(int[] array) {
        for (int value : array) {
            int absValue = Math.abs(value);
            if (array[absValue - 1] < 0)
                return absValue;
            array[absValue - 1] *= -1;
        }
        return -1; 
    }

    public static void main(String[] args) { 
        int[] testcase = new int[]{2, 1, 5, 2, 3, 3, 4};
        System.out.println(firstDuplicateValue(testcase));
    }

}
