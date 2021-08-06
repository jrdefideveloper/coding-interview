import java.util.*; 

class Fibonacci {

    
    /** 
     * O(2^N) very bad 
     * Many duplicate computations 
     * 
     * O(n) space complexity (at most n frames on the call stack)
     * 
     * @param n
     * @return int
     */
    public static int fibonacciRecursion(int n) { 
        if (n==1) { 
            return 0; 
        } else if (n==2) { 
            return 1; 
        } else { 
            return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2); 
        }
    }
    
    
    /** 
     * Memoization = caching. 
     * O(n) time complexity; O(n) space complexity 
     * 
     * @param n
     * @return int
     */
    public static int fibonacciMemoize(int n) { 
        HashMap<Integer, Integer> fibMap = new HashMap<Integer, Integer>(); 
        fibMap.put(0, 1); 
        fibMap.put(1, 1); 
        int counter = 3; 
        while (counter <= n) { 
            fibMap.put(counter, fibMap.get(counter - 1) + fibMap.get(counter - 2)); 
            counter++; 
        }
        return fibMap.get(n); 
    }


    public static void main(String[] args) { 

    } 
}
