import java.util.*;

public class StaircaseTraversal {
    // O(n * k) n = height; k = number of allowed steps
    public int numberOfWaysToTop(int height, int maxSteps, HashMap<Integer, Integer> memoize) {
        if (memoize.containsKey(height)) {
            return memoize.get(height);
        }
        int numberOfWays = 0;

        for (int step = 1; step < Math.min(height, maxSteps) + 1; step++) {
            numberOfWays += numberOfWaysToTop(height - step, maxSteps, memoize);
        }
        memoize.put(height, numberOfWays);

        return numberOfWays;
    }

    public int staircaseTraversal(int height, int maxSteps) {
        HashMap<Integer, Integer> memoize = new HashMap<Integer, Integer>();
        memoize.put(0, 1);
        memoize.put(1, 1);
        return numberOfWaysToTop(height, maxSteps, memoize);
    }

    // O(n) time | O(n) space
    public int staircaseTraversalDP(int height, int maxSteps) {
        // Dynamic programming no recursive calls
        ArrayList<Integer> waysToTop = new ArrayList<Integer>();
        waysToTop.add(1);
        int currentNumberOfWays = 0;

        for (int currentHeight = 1; currentHeight < height + 1; currentHeight++) {
            int startWindow = currentHeight - maxSteps - 1;
            int endWindow = currentHeight - 1;

            if (startWindow >= 0) {
                currentNumberOfWays -= waysToTop.get(startWindow);
            }

            currentNumberOfWays += waysToTop.get(endWindow);
            waysToTop.add(currentNumberOfWays);
        }

        return waysToTop.get(height);

    }
}
