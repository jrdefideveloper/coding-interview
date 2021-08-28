import java.util.*;

public class MinNumberOfChange {

    
    /** 
     * O(nd) time | O(n) space 
     * @param n
     * @param denoms
     * @return int
     */
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] numOfCoins = new int[n + 1];
        Arrays.fill(numOfCoins, Integer.MAX_VALUE);
        numOfCoins[0] = 0;
        int newNum = 0;

        for (int denom : denoms) {
            for (int amount = 0; amount <= n; amount++) {
                if (denom <= amount) {
                    if (numOfCoins[amount - denom] == Integer.MAX_VALUE) {
                        newNum = numOfCoins[amount - denom];
                    } else {
                        newNum = numOfCoins[amount - denom] + 1;
                    }
                    numOfCoins[amount] = Math.min(numOfCoins[amount], newNum);
                }
            }
        }

        return (numOfCoins[n] != Integer.MAX_VALUE ? numOfCoins[n] : -1);
    }

    public static void main(String[] args) {
        int[] input = new int[] { 1, 5, 10 };
        System.out.println(minNumberOfCoinsForChange(7, input));
    }

}
