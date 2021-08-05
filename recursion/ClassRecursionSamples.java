class ClassRecursionSamples {

    
    /** 
     * Fn = Fn-1 + Fn-2
     * F0 = 0; F1 = 1 
     * The Fibonacci Sequence is the series of numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
     * The next number is found by adding up the two numbers before it.  
     * 2 = 1 + 1 
     * 3 = 1 + 2 
     * 5 = 2 + 3 
     * 
     * @param n
     * @return int
     */
    public static int fibonacci(int num) { 
        if (num <= 1) {
            return num; 
        } else { 
            return fibonacci(num - 1) + fibonacci(num - 2); 
        }
    }

    
    /** 
     * 5! = 5 x 4 x 3 x 2 x 1 
     * @param n
     * @return int
     */
    public static int factorial(int n) {
        if (n <= 1)
            return 1; 
        else 
            return n * factorial(n - 1); 
    }

    public static String reverseWord(String word) { 
        if (word.isEmpty())
            return word; 
        return reverseWord(word.substring(1)) + word.charAt(0); 
    } 

    public static int totalDiff(int sensorA[], int sensorB[], int size) { 
        int diff = 0; 
        for (int i = 0; i < size; i++) { 
             diff += Math.abs(sensorA[i] - sensorB[i]);
        }
        return diff; 
    }

    public static int totalDiffR(int[] sensorA, int sensorB[], int size) { 
        if (size == 0) 
            return 0; 
        int lastElementDiff = Math.abs(sensorA[size - 1] - sensorB[size - 1]); 
        int diff = totalDiffR(sensorA, sensorB, size - 1) + lastElementDiff; 
        return diff; 
    }

 
    public static void main(String[] args) { 
       // System.out.println(factorial(5));
        //System.out.println(fibonacci(9));
        //System.out.println(reverseWord("Jessica"));

        int[] sensorA = new int[]{15, -4, 56, 10, -23}; 
        int[] sensorB = new int[]{14, -9, 56, 14, -23};   
        System.out.println(totalDiffR(sensorA, sensorB, 5));
    }
    
}
