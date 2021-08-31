public class KadanesAlgorithm {

    // [3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]
    // [3, 8, -1, 1, 4, 2, 5, 9, 16, 18, 9, 15, 18, 19, 14, 18]
    // O(n) time | O(1) space; Kadane's algorithm
    public static int kadanesAlgorithm(int[] array) {
        int maxEndingHere = array[0];
        int maxSoFar = array[0];

        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            maxEndingHere = Math.max(num, maxEndingHere + num);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) { 
        int[] testcase = new int[]{3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4}; 
        System.out.println("Result is " + kadanesAlgorithm(testcase)); 
    }
}
