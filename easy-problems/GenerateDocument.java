import java.util.*;

class GenerateDocument {

    /**
     * Given a string of available characters and a string representing a document
     * that you need to generate. Write a function that determines if you can
     * generate the document using the available characters. If you can generate the
     * document, your function should return true; otherwise failse.
     * 
     * characters = "abcabc" document = "aabbcc"
     * 
     * You can't generate this because you're missing a c
     * 
     * O(n) time | O(n) space
     * 
     * @param characters
     * @param document
     * @return boolean
     */
    public static boolean generateDocument(String characters, String document) {
        if (document == "")
            return true; // edge case we can always generate the empty string.
        // Build out the hashMap
        HashMap<Character, Integer> charFreq = new HashMap<Character, Integer>();
        for (int i = 0; i < characters.length(); i++) {
            Character currentChar = characters.charAt(i);
            charFreq.put(currentChar, charFreq.getOrDefault(currentChar, 0) + 1);
        }
        for (Character docChar : document.toCharArray()) {
            if (charFreq.containsKey(docChar)) {
                Integer charCount = charFreq.get(docChar);
                if (charCount <= 0) {
                    return false;
                }
                charFreq.put(docChar, charCount - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        System.out.println(generateDocument(characters, document));
    }

}
