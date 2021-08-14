import java.util.*;

public class MoveElementToEnd {

    
    /** 
     * O(n) time | O(1) space 
     * 
     * @param array
     * @param toMove
     * @return List<Integer>
     */
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int start = 0;
        int end = array.size() - 1;

        while (start < end) {
            while (start < end && array.get(end) == toMove) { // look for number that is NOT to move
                end--;
            }
            if (array.get(start) == toMove) { // found a number you can swap with the end
                array.set(start, array.get(end));
                array.set(end, toMove);
            }
            start++;
        }
        return array;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
        int toMove = 2;
        List<Integer> answer = moveElementToEnd(array, toMove);

        for (Integer num : answer) {
            System.out.print(num + " ");
        }
    }

}
