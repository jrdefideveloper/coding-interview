import java.util.*;

class TandemBicycle {

    public static void reverseArrayOrder(int[] array) { 
        int start = 0; 
        int end = array.length - 1;  

        while (start < end) { 
            int temp = array[start]; 
            array[start] = array[end]; 
            array[end] = temp; 
            start++; 
            end--; 
        }
    }

    
    /** 
     * Tandem bike = bike operated by 2 people. The person that pedals faster dictates speed. 
     * tandemSpeed = max(speedA, speedB) 
     * 
     * Pair every rider wearing red with a rider wearing blue  
     * 
     * Return the max possible total speed or the min possible total speed of all the tandem bicycles being ridden. 
     * based of input fastest. 
     * 
     * O(nlogn) time | constant space. 
     * 
     * @param redShirtSpeeds
     * @param blueShirtSpeeds
     * @param fastest
     * @return int
     */
    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds); 
        Arrays.sort(blueShirtSpeeds);   
        if (fastest) { 
            reverseArrayOrder(blueShirtSpeeds); 
        } 

        int result = 0; 
        for (int idx = 0; idx < redShirtSpeeds.length; idx++ ){ 
            result += Math.max(redShirtSpeeds[idx], blueShirtSpeeds[idx]); 
        }
        return result;
    }

    public static void main(String[] args) {

        int[] redShirtSpeeds = new int[]{5, 5, 3, 9, 2}; 
        int[] blueShirtSpeeds = new int[]{3, 6, 7, 2, 1};  
        System.out.println(tandemBicycle(redShirtSpeeds, blueShirtSpeeds, true));
        System.out.println(tandemBicycle(redShirtSpeeds, blueShirtSpeeds, false));
    }

}
