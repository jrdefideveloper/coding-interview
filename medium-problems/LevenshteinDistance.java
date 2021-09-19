public class LevenshteinDistance {

    
    /** 
     * Algorithm is if the letter we are comparing is the same then we take the diagonal number 
     * If they are different then we look to the three neighbors and check for the minimum number 
     * 
     * This ends up being 
     * O(n*m) time | O(n*m) space 
     * Where n is the length of str1 and m is the length of str2 
     * 
     * @param str1
     * @param str2
     * @return int
     */
    public static int levenshteinDistance(String str1, String str2) {
        int[][] edits = new int[str2.length() + 1][str1.length() + 1];
        for (int i = 0; i < str2.length() + 1; i++) {
            for (int j = 0; j < str1.length() + 1; j++) {
                edits[i][j] = j; // This is doing more than the row and column but that's okay.
            }
            edits[i][0] = i; // always on the first row 
        }
        
        for (int i1 = 0; i1 < edits.length; i1++) {
            for (int j1 = 0; j1 < edits[0].length; j1++) { 
                System.out.print(edits[i1][j1] + " ");
            }
            System.out.println("");
        }
        for (int i = 1; i < str2.length() + 1; i++) { // We start at 1 because we don't need to look at empty index.
            for (int j = 1; j < str1.length() + 1; j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                    edits[i][j] = edits[i - 1][j - 1]; // Grab the diagonal if same letter
                } else {
                    edits[i][j] = 
                        1 + Math.min(edits[i - 1][j - 1], Math.min(edits[i - 1][j], edits[i][j - 1])); // smallest of three neighbors
                }
            }
        }
        return edits[str2.length()][str1.length()]; // bottom right of the edits array.
    }

    public static void main(String[] args) { 
        System.out.println("The final result is " + levenshteinDistance("abc", "yabd")); 
    }
 
}
