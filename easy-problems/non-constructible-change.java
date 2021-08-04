import java.util.*; 

class Problem5 {

    /** 
     * Array is positive integers representing the value of your coins 
     * Minimum amount of change you can not create. 
     * 
     * Coin values are not unique 
     * 
     * 
     * @param coins
     * @return int
     */
    public static int nonConstructibleChange(int[] coins) {
        // first sort the array 
        // then keep a running sum of change you can make. 
        // when you encounter a coin that has a value of > change + 1 
        // you wont be able to make the change anymore 

        Arrays.sort(coins); // o(n log n)
        int maxChange = 0; 
        for (int coin: coins) { 
            if (coin > maxChange + 1) { 
                return maxChange + 1; 
            } else { 
                maxChange += coin; 
            }

        }
        return maxChange + 1; // ahh tricky. 
    }

    public static void main(String[] args) { 
        int[] coins = new int[]{5, 7, 1, 1, 2, 3, 22}; 
        System.out.println(nonConstructibleChange(coins));
        int[] coins2 = new int[]{2, 3}; 
        System.out.println(nonConstructibleChange(coins2));
    }
    
}
