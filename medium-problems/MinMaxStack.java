import java.util.*; 

public class MinMaxStack {

    /*
     * stack - pile books on the table
     */

    List<Map<String, Integer>> minMaxStack = new ArrayList<Map<String, Integer>>();
    ArrayList<Integer> stack = new ArrayList<Integer>();

    
    /** 
     * @return int
     */
    // O(1) time | O(1) space
    public int peek() {
        return stack.get(stack.size() - 1);
    }

    
    /** 
     * @return int
     */
    // O(1) time | O(1) space
    public int pop() {
        minMaxStack.remove(minMaxStack.size() - 1);
        return stack.remove(stack.size() - 1);
    }

    
    /** 
     * @param number
     */
    // O(1) time | O(1) space
    public void push(Integer number) {
        HashMap<String, Integer> newMinMax = new HashMap<String, Integer>();
        newMinMax.put("min", number);
        newMinMax.put("max", number);

        if (minMaxStack.size() > 0) {
            int previousMin = getMin();
            int previousMax = getMax();
            newMinMax.replace("min", Math.min(number, previousMin));
            newMinMax.replace("max", Math.max(number, previousMax));
        }

        minMaxStack.add(newMinMax);
        stack.add(number);
    }

    
    /** 
     * @return int
     */
    public int getMin() {
        return minMaxStack.get(minMaxStack.size() - 1).get("min");
    }

    
    /** 
     * @return int
     */
    public int getMax() {
        return minMaxStack.get(minMaxStack.size() - 1).get("max");
    }

}
