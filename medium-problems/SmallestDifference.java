import java.util.*;

public class SmallestDifference {

    
    /** 
     * O(n log n) + O(m log m) | O(n) iteration | O(1) space
     * @param arrayOne
     * @param arrayTwo
     * @return int[]
     */
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne); 
        Arrays.sort(arrayTwo); 
        int idxOne = 0; 
        int idxTwo = 0;  
        int smallest = Integer.MAX_VALUE;   
        int current = Integer.MAX_VALUE; 
        int[] smallestPair = new int[2];  

        while (idxOne < arrayOne.length && idxTwo < arrayTwo.length) { 
            int firstNum = arrayOne[idxOne]; 
            int secondNum = arrayTwo[idxTwo]; 

            if (firstNum < secondNum) { 
                current = secondNum - firstNum; 
                idxOne += 1; 
            } else if (secondNum < firstNum) {  
                current = firstNum - secondNum; 
                idxTwo += 1; 
            } else { 
                smallestPair[0] = firstNum; 
                smallestPair[1] = secondNum; 
                return smallestPair; 
            } 
            if (smallest > current) { 
                smallest = current; 
                smallestPair[0] = firstNum; 
                smallestPair[1] = secondNum; 
            }
        }
        return smallestPair; 
    }

    public static void main(String[] args) {
        int[] testcase = {-1, 5, 10, 20, 28, 3};  
        int[] testcase2 = {26, 134, 135, 15, 17};
        int[] result = smallestDifference(testcase, testcase2);
        for (int num : result) { 
            System.out.println(num);
        }


    }

}
