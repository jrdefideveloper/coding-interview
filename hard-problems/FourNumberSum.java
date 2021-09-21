import java.util.*; 

public class FourNumberSum {


    /**
     * Solution is kind of like a more complicated two sum problem.  
     * Save pairs instead of a single number 
     * 
     * Average is O(n^2) 
     * @param array
     * @param targetSum
     * @return List<Integer[]>
     */
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        Map<Integer, List<Integer[]>> allPairSums = new HashMap<>();
        List<Integer[]> quadruplets = new ArrayList<Integer[]>();
        for (int i = 1; i < array.length - 1; i++) {
            // Iterate after current number 
            for (int j = i + 1; j < array.length; j++) {
                int currentSum = array[i] + array[j];
                int difference = targetSum - currentSum;
                if (allPairSums.containsKey(difference)) {
                    for (Integer[] pair : allPairSums.get(difference)) {
                        Integer[] newQuadruplet = { pair[0], pair[1], array[i], array[j] };
                        quadruplets.add(newQuadruplet);
                    }
                }
            }
            // Iterate before current number
            for (int k = 0; k < i; k++) {
                int currentSum = array[i] + array[k];
                Integer[] pair = { array[k], array[i] };
                // Only add it when we are the second number that generates a pair rather than the first 
                // This prevents duplication from happening 
                if (!allPairSums.containsKey(currentSum)) {
                    List<Integer[]> pairGroup = new ArrayList<Integer[]>();
                    pairGroup.add(pair);
                    allPairSums.put(currentSum, pairGroup);
                } else {
                    allPairSums.get(currentSum).add(pair);
                }
            }
        }
        return quadruplets;
    }

    public static void main(String[] args) {
        int[] input = new int[] { 7, 6, 4, -1, 1, 2 };
        int targetSum = 16;
        List<Integer[]> results = fourNumberSum(input, targetSum);
        for (Integer[] q : results) { 
            System.out.println("[" + q[0] + ", " + q[1] + ", " + q[2] + ", " + q[3]+"]");
        }
    }

}
