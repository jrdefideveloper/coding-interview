import java.util.*; 

public class NextGreaterElement {

    // O(2n) time | O(n) space
    public int[] nextGreaterElement(int[] array) {
        int[] result = new int[array.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<Integer>();

        for (int idx = 0; idx < 2 * array.length; idx++) {
            int circularIdx = idx % array.length;

            while (stack.size() > 0 && array[stack.peek()] < array[circularIdx]) {
                int top = stack.pop();
                result[top] = array[circularIdx];
            }
            stack.push(circularIdx);
        }
        return result;
    }

}
