import java.util.*;

public class MergeOverlappingIntervals {

    /** 
     * O(n log n) time | O(n) space 
     * @param intervals
     * @return int[][]
     */
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        int[][] sortedIntervals = intervals.clone(); 
        Arrays.sort(sortedIntervals, (a, b) -> Integer.compare(a[0], b[0]));  
    
        List<int[]> mergedIntervals = new ArrayList<int[]>(); 
        int[] currentInterval = sortedIntervals[0];
        mergedIntervals.add(currentInterval); 
        System.out.println(currentInterval[0] + ", " + currentInterval[1]); 
    
        for (int[] nextInterval : sortedIntervals) { 
            int currentIntervalEnd = currentInterval[1]; 
            int nextIntervalStart = nextInterval[0]; 
            int nextIntervalEnd = nextInterval[1]; 
            
            if (currentIntervalEnd >= nextIntervalStart) { 
                currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd); 
                System.out.println(currentInterval[1]);
            } else { 
                currentInterval = nextInterval; 
                mergedIntervals.add(currentInterval);
                System.out.println(currentInterval[0] + ", " + currentInterval[1]); 
            } 
        }
    return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    } 

    public static void main(String[] args) {

        int[] interval1 = new int[]{1, 3}; 
        int[] interval2 = new int[]{2, 8}; 
        int[] interval3 = new int[]{9, 10}; 
        int[][] intervals = new int[][]{interval1, interval2, interval3}; 

        int[][] result = mergeOverlappingIntervals(intervals);  

        System.out.println("Answer"); 
        for (int[] i : result) 
            System.out.println(i[0] + ", " + i[1]);

    }
   
}
