import java.util.*; 

public class LargestRange {

    // Obvious solution and the other solution is much more clever
    // [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6] -> [0, 7]
    // Solution 1 is using sort O(nlogn) time | O(1) space   
    // Solution 2 is using hashmap O(n) time | O(n) space 

    public static int[] largestRange(int[] array) {
        HashMap<Integer, Boolean> numbers = new HashMap<Integer, Boolean>();  
        for (int num : array) { 
            numbers.put(num, true); 
        }

        int bestLength = 0; 
        int[] bestRange = new int[2]; 
        for (int num : array) { 
            if (!numbers.get(num)) { 
                continue; 
            }
            int left = num - 1; 
            int right = num + 1; 
            while (numbers.containsKey(left)) { 
                numbers.put(left, false); 
                left--; 

            }
            while (numbers.containsKey(right)) { 
                numbers.put(right, false); 
                right++; 
                
            }
            int currentLength = (right - 1) - (left + 1); 
            System.out.println(currentLength); 
            if (currentLength >= bestLength) { 
                bestLength = currentLength; 
                bestRange[0] = left + 1; 
                bestRange[1] = right - 1; 
            }
        }
        return bestRange; 
    }

    public static void main(String[] args) {
        int[] testcase = new int[] { 1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6}; 
        int[] testcase2 = new int[] { 1}; 
        int[] bestRange = largestRange(testcase2); 
        System.out.println(bestRange[0] + ", " + bestRange[1]); 
    }

}
