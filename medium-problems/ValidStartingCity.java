public class ValidStartingCity {

    
    /** 
     * Greedy algorithm. 
     * 
     * Set city at index 0 to be 0 miles left and then start computing miles left at 
     * each city. The city with the smallest number of miles left 
     * should be the starting city because no matter what entering that city 
     * from another other city is the most expensive.  
     * 
     * @param distances
     * @param fuel
     * @param mpg
     * @return int
     */
    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int minMilesLeft = Integer.MAX_VALUE;
        int minMilesLeftCity = -1;

        int currentFuel = 0;
        int milesLeft = 0;
        for (int city = 0; city < distances.length; city++) {
            if (city == 0) {
                minMilesLeft = city;
                minMilesLeftCity = city;
                continue;
            }
            currentFuel = fuel[city - 1];
            milesLeft = milesLeft + currentFuel * mpg - distances[city - 1];

            if (milesLeft < minMilesLeft) {
                minMilesLeft = milesLeft;
                minMilesLeftCity = city;
            }
        }
        return minMilesLeftCity;
    }

    public static void main(String[] args) { 
        int[] distances = new int[] {5, 25, 15, 10, 15};
        int[] fuel = new int[] {1, 2, 1, 0, 3};
        int mpg = 10;
        int expected = 4;
        int actual = validStartingCity(distances, fuel, mpg); 
        if (expected == actual)
            System.out.println("Solution is correct for test case 1"); 

    }

}
