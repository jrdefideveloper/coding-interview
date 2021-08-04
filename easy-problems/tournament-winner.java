import java.util.*;

class Problem4 {

    /**
     * Each team faces off against all other teams
     * 
     * Win = 3 points; Loss = 0 points
     * 
     * Array of pairs represents teams that have competed against each other
     * 
     * And array of results against each competition
     * 
     * Function should return the winner of the competition
     * 
     * @param competitions
     * @param results
     * @return String
     */
    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // Iterate through all the pairs
        // When there is a winner insert into the HashMap and increment value by 3
        // At the end traverse the keySet with the largest value
        // O(n) time complexity | O(n) extra space for the HashMap

        HashMap<String, Integer> score = new HashMap<String, Integer>(); 
        int compCount = competitions.size();
        for (int i = 0; i < compCount; i++) { 
            boolean homeTeamWon = (results.get(i) == 1); 
            if (homeTeamWon) { 
                String hometeam = competitions.get(i).get(0); 
                score.put(hometeam, score.getOrDefault(hometeam, 0) + 3); 
            } else { 
                String awayteam = competitions.get(i).get(1); 
                score.put(awayteam, score.getOrDefault(awayteam, 0) + 3); 
            }
        }
        
        return Collections.max(score.entrySet(), Map.Entry.comparingByValue()).getKey();      
    }

   
    public static void main(String[] args) {
        ArrayList<String> match1 = new ArrayList<String>(Arrays.asList("HTML", "C#")); 
        ArrayList<String> match2 = new ArrayList<String>(Arrays.asList("C#", "Python")); 
        ArrayList<String> match3 = new ArrayList<String>(Arrays.asList("Python", "HTML")); 
        ArrayList<ArrayList<String>> competition = new ArrayList<ArrayList<String>>(); 
        competition.add(match1); 
        competition.add(match2); 
        competition.add(match3); 
        ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 0, 1)); 
        System.out.println(tournamentWinner(competition, results));
    }

}
