import java.util.*;

public class ThreeNumberSum {

    
    /** 
     * O(n^2) time | O(n) space. 
     * @param array
     * @param targetSum
     * @return List<Integer[]>
     */
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        ArrayList<Integer[]> triplets = new ArrayList<Integer[]>();
        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];
                if (currentSum == targetSum) {
                    triplets.add(new Integer[] { array[i], array[left], array[right] });
                    left++;
                    right--;
                } else if (currentSum < targetSum) {
                    left++;
                } else if (currentSum > targetSum) {
                    right--;
                }
            }

        }
        return triplets;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 12, 3, 1, 2, -6, 5, -8, 6 };
        int targetSum = 0;
        List<Integer[]> answer = threeNumberSum(array, targetSum);

        for (Integer[] list : answer) {
            System.out.println(list[0] + " " + list[1] + " " + list[2]);
        }
    }
}
