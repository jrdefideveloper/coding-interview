import java.util.*;

public class SameBSTs {

    // Must have the same first value
    // Must have the same length

    // Recursively check if left and right subtrees are the same
    // Then make a list of all elements smaller than the root node
    // Then make a list of all the elements greater than or equal to the root node

    // [10] versus [10]
    // [8, 5, 2] versus [8, 5, 2]
    // [5, 2] versus [5, 2]
    // [2] versus [2]

    // [15, 12, 94, 81, 11]
    // [15, 12, 11, 94, 81]

    // [12, 11] versus [12, 11]
    // [11] versus [11]

    // [94, 81] versus [94, 81]

    // O(n^2) time | O(n^2) space
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size())
            return false;

        if (arrayOne.size() == 0 && arrayTwo.size() == 0)
            return true;

        if (arrayOne.get(0) != arrayTwo.get(0))
            return false;

        List<Integer> leftOne = getSmaller(arrayOne);
        List<Integer> leftTwo = getSmaller(arrayTwo);
        List<Integer> rightOne = getBiggerOrEqual(arrayOne);
        List<Integer> rightTwo = getBiggerOrEqual(arrayTwo);
        return sameBsts(leftOne, leftTwo) && sameBsts(rightOne, rightTwo);
    }

    public static List<Integer> getSmaller(List<Integer> array) {
        List<Integer> allSmaller = new ArrayList<Integer>();
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) < array.get(0))
                allSmaller.add(array.get(i));
        }
        return allSmaller;
    }

    public static List<Integer> getBiggerOrEqual(List<Integer> array) {
        List<Integer> allBiggerOrEqual = new ArrayList<Integer>();
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) >= array.get(0))
                allBiggerOrEqual.add(array.get(i));
        }
        return allBiggerOrEqual;
    }

    public static void main(String[] args) {
        List<Integer> arrayOne = new ArrayList<Integer>(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11));
        List<Integer> arrayTwo = new ArrayList<Integer>(Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81));
        System.out.println("The two arrays represent the same BST = " + sameBsts(arrayOne, arrayTwo));
    }

}
