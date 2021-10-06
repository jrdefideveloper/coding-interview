import java.util.*;

public class MultiStringSearch {
    /*
     * Bad solution
     * 
     * Iterate through big string and find where they start to equal each other then
     * follow along and make sure the whole word exists
     * 
     * [this is a big string] [this, yo, is, a, bigger, string, kappa] [t, f, t, t,
     * f, t, f]
     * 
     * O(bns) time | O(n) space
     */

    public static boolean isInBigStringHelper(String bigString, String smallString, int startIdx) {
        int leftBigIdx = startIdx;
        int rightBigIdx = startIdx + smallString.length() - 1;
        int leftSmallIdx = 0;
        int rightSmallIdx = smallString.length() - 1;

        while (leftBigIdx <= rightBigIdx) {
            if (bigString.charAt(leftBigIdx) != smallString.charAt(leftSmallIdx)
                    || bigString.charAt(rightBigIdx) != smallString.charAt(rightSmallIdx)) {
                return false;
            }
            leftBigIdx += 1;
            rightBigIdx -= 1;
            leftSmallIdx += 1;
            rightSmallIdx -= 1;
        }
        return true;
    }

    public static boolean isInBigString(String bigString, String smallString) {
        for (int idx = 0; idx < bigString.length(); idx++) {
            if (idx + smallString.length() > bigString.length()) {
                break;
            }
            if (isInBigStringHelper(bigString, smallString, idx))
                return true;
        }
        return false;

    }

    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        List<Boolean> solution = new ArrayList<Boolean>();

        for (String smallString : smallStrings) {
            solution.add(isInBigString(bigString, smallString));
        }
        return solution;
    }

    public static void main(String[] args) {
        String bigString = "this is a big string";
        String[] smallStrings = new String[] { "this", "yo", "is", "a", "bigger", "string", "kappa" };

        List<Boolean> result = multiStringSearch(bigString, smallStrings);

        for (Boolean b : result) {
            System.out.print(b + " ");
        }

    }
}
