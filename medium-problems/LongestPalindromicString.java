public class LongestPalindromicString {

    public static int[] getLongestPalindromeFrom(String str, int leftIdx, int rightIdx) {
        while (leftIdx >= 0 && rightIdx < str.length()) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                break;
            }
            leftIdx--;
            rightIdx++;
        }
        return new int[] { leftIdx + 1, rightIdx }; // we don't need to subtract rightIdx by 1 because it ends up getting excluded anyway

    }

    // O(n^2) time | O(1) space
    public static String longestPalindromicSubstring(String str) {
        int[] currentLongest = new int[] { 0, 1 };
        // Going to use substring function on these indices. 1 is exluded

        // start from 1 because we know 0 is already a palindrome
        for (int i = 1; i < str.length(); i++) {
            int[] odd = getLongestPalindromeFrom(str, i - 1, i + 1);
            int[] even = getLongestPalindromeFrom(str, i - 1, i);
            int[] longest = (odd[1] - odd[0] > even[1] - even[0]) ? odd : even;
            currentLongest = (currentLongest[1] - currentLongest[0] > longest[1] - longest[0]) ? currentLongest
                    : longest;
        }

        return str.substring(currentLongest[0], currentLongest[1]);
    }

}
