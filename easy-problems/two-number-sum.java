import java.util.*;

class Program {
  /*
   * O(N^2) time; O(1) extra space 
   * Return numbers that add up to target sum in an array. Array is assumed to be
   * non-empty. If no two numbers sum up to the target sum return an empty array
   * Assume there is at most only 1 pair
   * 
   * [3, 5, -4, 8, 11, 1, -1, 6]  targetSum = 10 answer would be [-1, 11]
   * 
   * @param array
   * @param targetSum
   * @return int[]
   */
  public static int[] twoNumberSumSlow(int[] array, int targetSum) {
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] + array[j] == targetSum) {
          return new int[] {array[i], array[j]}; 
        }
      }
    }
    return new int[0];
  }

  
  /** 
   * O(n) time; O(n) space 
   * @param array
   * @param targetSum
   * @return int[]
   */
  public static int[] twoNumberSumFaster(int[] array, int targetSum) { 
    // key = number, value = index 
    Set<Integer> nums = new HashSet<Integer>(); 
    for (int num : array) { 
      int complement = targetSum - num; 
      if (nums.contains(complement)) { 
          return new int[] {complement, num}; 
      } else { 
        nums.add(num); 
      }
    }

    return new int[0]; 
  }


  
  /** 
   * O(nlogn) time; Array.sort() in the backend is QuickSort for Java 
   * O(1) extra space 
   * First sort the array and then run a binary search on the sorted array. 
   * @param array
   * @param targetSum
   * @return int[]
   */
  public static int[] twoNumberSumNLogN(int[] array, int targetSum) { 
    Arrays.sort(array); 
    int left = 0, right = array.length - 1;  
    while (left < right) {  
      int leftValue = array[left]; 
      int rightValue = array[right]; 
      int currentSum = leftValue + rightValue; 
      if (currentSum == targetSum) { 
        return new int[] {leftValue, rightValue}; 
      } else if (currentSum < targetSum) { 
        left++; 
      } else { 
        right--; 
      }
    }
    return new int[0]; 
  }

  public static void main(String[] args) {
    int[] testCase = { 3, 5, -4, 8, 11, 1, -1, 6 };
    int[] result = twoNumberSumNLogN(testCase, 10);

    for (int num : result) {
      System.out.print(num + " ");
    }
  }
}
