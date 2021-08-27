public class MaxSumSetAdjacentNumbers {

    // O(n) time | O(n) space
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length == 0)
            return 0;
        if (array.length == 1)
            return array[0];

        int[] maxSumSet = array.clone();

        maxSumSet[0] = array[0];
        maxSumSet[1] = Math.max(array[0], array[1]);

        for (int i = 2; i < array.length; i++) {
            maxSumSet[i] = Math.max(maxSumSet[i - 1], maxSumSet[i - 2] + array[i]);
        }
        return maxSumSet[array.length - 1];
    }

    // O(n) time | O(1) space
    public static int maxSubsetSumNoAdjacentConstantSpace(int[] array) {
        if (array.length == 0)
            return 0;
        if (array.length == 1)
            return array[0];

        int second = array[0];
        int first = Math.max(array[0], array[1]);

        for (int i = 2; i < array.length; i++) {
            int current = Math.max(first, second + array[i]);
            second = first;
            first = current;
        }
        return first;
    }

    public static void main(String[] args) {
        int[] input = { 75, 105, 120, 75, 90, 135 };
        System.out.println(maxSubsetSumNoAdjacent(input));
    }

}
