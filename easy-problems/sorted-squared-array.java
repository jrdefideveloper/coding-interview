import java.util.*; 

class Problem3 {

    
    /** 
     * Math.pow(num, 2)
     * @param num
     * @return int
     */
    public static int square(int num) { 
        return num * num; 
    }
    
    /** 
     * Input is in sorted ascending order and returns a new array of the same length with the squares
     * of the original array also in ascending order. 
     * 
     * O(n log n) time complexity 
     * O(1) space complexity 
     * 
     * @param array
     * @return int[]
     */
    public static int[] sortedSquaredArrayNaive(int[] array) { 
        // Square every number and update the array. Then run a sort 
        for (int i = 0; i < array.length; i++) { 
            array[i] = square(array[i]); 
        }
        Arrays.sort(array); 
        return array; 
    }

    
    /** 
     * Anytime the array is sorted you should be able to solve it in linear time* 
     * @param array
     * @return int[]
     */
    public static int[] sortedSquaredArrayBetter(int[] array) { 
        // Initialize empty output array 
        int[] result = new int[array.length]; 

        // Squares of value are largest at the furthest left and the furthest right 
        // Look at the absolute value of the  number to see which will be bigger 

        // Look at the values at the beginning and at the end to see what to insert 
        // to the beginning and end of the array
        int start = 0; 
        int end = array.length - 1;  
        int indexToAdd = array.length - 1; 

        while (start != end) { 
            if (Math.abs(array[start]) >= Math.abs(array[end])) { 
                result[indexToAdd] = square(array[start]); 
                start++; 
                indexToAdd--; 
            } else { 
                result[indexToAdd] = square(array[end]); 
                indexToAdd--; 
                end--; 
            }
        }
        result[indexToAdd] = square(array[start]);

        return result; 
    }


    public static void main(String[] args) { 
        int[] testCase1 = {-7, -3, 1, 9, 22, 30}; 

        // O(nlogn) time; O(1) space 
        int[] result = sortedSquaredArrayBetter(testCase1); 
        for (int num: result) { 
            System.out.println(num);
        }

    }
    
}
