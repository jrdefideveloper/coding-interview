import java.util.*;

public class Permutations {
    /*
     * 
     * Given an array of unique integers write a function that returns an array of
     * all permutations of the integers.
     * 
     * e.g [1, 2, 3]
     * 
     * Solution [1, 2, 3] [1, 3, 2] [2, 1, 3] [2, 3, 1] [3, 2, 1] [3, 1, 2]
     */
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        getPermutations(0, array, permutations);
        return permutations;
    }

    public static void getPermutations(int i, List<Integer> array, List<List<Integer>> permutations) {
        if (i == array.size() - 1) {
            permutations.add(new ArrayList<Integer>(array));
        } else {
            for (int j = i; j < array.size(); j++) {
                swap(array, i, j);
                getPermutations(i + 1, array, permutations);
                swap(array, i, j);
            }
        }
    }

    public static void swap(List<Integer> array, int i, int j) {
        Integer tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }

    public static void main(String[] args) {

    }
}
