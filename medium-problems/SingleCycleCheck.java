public class SingleCycleCheck {

    
    /** 
     * O(n) time | O(1) space
     * @param array
     * @return boolean
     */
    public static boolean hasSingleCycle(int[] array) {
        int numElementsVisited = 0; 
        int currentIdx = 0; 

        while (numElementsVisited < array.length) {  
            if (numElementsVisited > 0 && currentIdx == 0) return false;  
            numElementsVisited++; 
            currentIdx = getNextIdx(currentIdx, array); 
        }
        return (currentIdx == 0);
    }

    public static int getNextIdx(int currentIdx, int[] array) { 
        int jump = array[currentIdx];  
        int nextIdx = (currentIdx + jump) % array.length;
        return (nextIdx >= 0) ? nextIdx : nextIdx + array.length;  
    }

    public static void main(String[] args) {
        System.out.println(hasSingleCycle(new int[] {2, 3, 1, -4, -4, 2})); 
    }
}
