public class NumberOfWaysToTraverseGraph {

    /**
     * Dynamic programming solution to the problem. O(n * m) time | O(n * m) space
     * where n = height and m = width.
     * 
     * @param width
     * @param height
     * @return int
     */
    public static int numberOfWaysToTraverseGraph(int width, int height) {
        int[][] numberOfWays = new int[height + 1][width + 1];
        for (int widthIdx = 1; widthIdx < width + 1; widthIdx++) {
            for (int heightIdx = 1; heightIdx < height + 1; heightIdx++) {
                if (widthIdx == 1 || heightIdx == 1) {
                    numberOfWays[heightIdx][widthIdx] = 1;
                } else {
                    int waysLeft = numberOfWays[heightIdx][widthIdx - 1];
                    int waysUp = numberOfWays[heightIdx - 1][widthIdx];
                    numberOfWays[heightIdx][widthIdx] = waysLeft + waysUp;
                }
            }
        }
        return numberOfWays[height][width];
    }

    
    /** 
     * O(n) time | O(1) space 
     * @param num
     * @return int
     */
    public static int factorial(int num) {
        int result = 1;
        for (int n = 2; n < num + 1; n++) {
            result *= n;
        }
        return result;
    }

    
    /** 
     * O(n + m)  time | O(1) space 
     * @param width
     * @param height
     * @return int
     */
    public static int numberOfWaysToTraverseGraphMathSolution(int width, int height) {
        // (R + D)! / (R!*D!) = 10
        int right = width - 1;
        int down = height - 1;
        return factorial(right + down) / (factorial(right) * factorial(down));
    }

    public static void main(String[] args) {
        int width = 4;
        int height = 3;
        // System.out.println("Result is " + numberOfWaysToTraverseGraph(width,
        // height));
        System.out.println("Result is " + numberOfWaysToTraverseGraphMathSolution(width, height));
    }

}
