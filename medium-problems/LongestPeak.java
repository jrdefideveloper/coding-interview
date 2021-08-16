public class LongestPeak {

    /**
     * Takes in an array of integers and returns the length of the longest peak in
     * the array
     * 
     * Tip = highest value in the peak (after that it's strictly decreasing) (there
     * needs to be 3 integers in a row increasing)
     * 
     * @param array
     * @return int
     */
    public static int longestPeak(int[] array) {
        int longestPeakLength = 0;

        int idx = 1;

        boolean isPeak = false;
        while (idx < array.length - 1) {
            isPeak = array[idx - 1] < array[idx] && array[idx] > array[idx + 1];

            if (!isPeak) {
                idx += 1;
                continue;
            }

            int leftIdx = idx - 2;
            while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
                leftIdx -= 1;
            }

            int rightIdx = idx + 2;
            while (rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
                rightIdx += 1;
            }

            int currentPeakLength = rightIdx - leftIdx - 1;
            longestPeakLength = Math.max(longestPeakLength, currentPeakLength);
            idx = rightIdx;

        }
        return longestPeakLength;

    }

    public static void main(String[] args) {

    }

}
