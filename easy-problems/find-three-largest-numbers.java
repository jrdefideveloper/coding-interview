import java.util.*;

class FindThreeLargestNumbers {

    /**
     * Returns a sorted array of the three largest integers in the input array
     * (without sorting input) Should return duplicate integers if necessary
     * 
     * [10, 10, 12] for an input of [10, 5, 9, 10, 12]
     * 
     * O(n) time | O(1) space 
     * 
     * @param array
     * @return int[]
     */
    public static int[] findThreeLargestNumbers(int[] array) {
        int[] previousMax = new int[] { -1, -1, -1 };
        
        for (int i = 0; i < 3; i++) {
            int currentMax = Integer.MIN_VALUE;
            for (int idx = 0; idx < array.length; idx++) {
                boolean notPreviousVisited = (idx != previousMax[0] && idx != previousMax[1] && idx != previousMax[2]);
                if (array[idx] >= currentMax && notPreviousVisited) {
                    currentMax = array[idx];
                    previousMax[i] = idx;
                }
            }
        }
        return new int[] { array[previousMax[0]], array[previousMax[1]], array[previousMax[2]] };
    }

    public static void main(String[] args) {
        int[] testcase = new int[] { 141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7 };
        // 18, 141, 541
        int[] threeLargest = findThreeLargestNumbers(testcase);
        for (int i : threeLargest) {
            System.out.println(i);
        }

    }

}
