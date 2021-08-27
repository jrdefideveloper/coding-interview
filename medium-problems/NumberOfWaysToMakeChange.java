
public class NumberOfWaysToMakeChange {

    
    /** 
     * O(amounts*denom) time 
     * O(amounts) space 
     * @param n
     * @param denoms
     * @return int
     */
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = new int[n + 1];
        ways[0] = 1;
        for (int j = 0; j < denoms.length; j++) {
            for (int amount = 1; amount <= n; amount++) {
                if (denoms[j] <= amount) {
                    ways[amount] = ways[amount] + ways[amount - denoms[j]];
                }
            }
        }
        return ways[n];
    }

    public static void main(String[] args) {
        int[] input = { 1, 5 };
        System.out.println(numberOfWaysToMakeChange(6, input));
    }
}
