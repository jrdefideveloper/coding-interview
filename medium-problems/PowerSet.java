import java.util.*; 

public class PowerSet {
    

    /*
     * Write a function that takes in an array of unique integers and returns its
     * powerset.
     * 
     * P(X) of a set x is the set of all subsets of X. [1, 2] = [[], [1], [2], [1,
     * 2]]
     */

    /** 
     * O(2^n * n) time |  O(2^n * n) space
     * @param array
     * @return List<List<Integer>>
     */
    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        subsets.add(new ArrayList<Integer>());
        for (Integer ele : array) {
            int length = subsets.size();
            for (int i = 0; i < length; i++) {
                System.out.println("Current length is " + length); 
                List<Integer> currentSubset = new ArrayList<Integer>(subsets.get(i));
                currentSubset.add(ele);
                System.out.println("Element added is " + ele);
                subsets.add(currentSubset);
            }
        }
        return subsets;
    }

    public static void main(String[] args) { 
        List<Integer> testinput = new ArrayList<Integer>(); 
        testinput.add(1); 
        testinput.add(2);  

        powerset(testinput); 

    }
}
