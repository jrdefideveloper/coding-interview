import java.util.*;

class MinimumWaitingTime {

    /**
     * Given a non-empty array of positive integers representing the amounts of time
     * that specific queries take to execute. Only one query can be executed at a
     * time, but the quries can be executed in any order.
     * 
     * A query's waiting time is defined as the amount of time that it must wait
     * before it's execution starts.
     * 
     * Write a function that returns the min amount of total waiting time for all
     * the queries. For example if given [1, 4, 5]
     * 
     * [5, 1, 4] would be (0) + (5) + (5 + 1) = 11.
     * 
     * Allowed to mutate input array.
     * 
     * Another example: [3, 2, 1, 2, 6] = 17
     * 
     * O(nlogn) time | O(n) space
     * 
     * @param queries
     * @return int
     */
    public static int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int[] waitTimes = new int[queries.length];
        waitTimes[0] = 0;
        int totalWait = 0; 

        for (int i = 1; i < queries.length; i++) {
            waitTimes[i] = waitTimes[i - 1] + queries[i - 1];
            totalWait += waitTimes[i]; 
        }
        // Write your code here.
        return totalWait;
    }

    
    /** 
     * O(nlogn) time | O(1) space 
     * @param queries
     * @return int
     */
    public static int minimumWaitingTimeConstantSpace(int[] queries) {
        Arrays.sort(queries);
        int totalWait = 0; 

        for (int i = 0; i < queries.length; i++) {
            int duration = queries[i]; 
            totalWait = totalWait + duration * (queries.length - 1 - i); 
        }
        // Write your code here.
        return totalWait;
    }

    public static void main(String[] args) {
        int[] testcase = new int[]{3, 2, 1, 2, 6}; 
        System.out.println(minimumWaitingTimeConstantSpace(testcase));

    }

}
