import java.util.*; 

public class MinimumCharacterForWords {
    

    
    /** 
     * O(n * l) time | O(c) space 
     * n = number of words 
     * l = length of the longest word 
     * 
     * c is the number of unique characters across all words  
     * 
     * @param words
     * @return char[]
     */
    public char[] minimumCharactersForWords(String[] words) {
        ArrayList<Character> result = new ArrayList<Character>();
        HashMap<Character, Integer> maxFreqMap = new HashMap<Character, Integer>();

        for (String word : words) {
            HashMap<Character, Integer> tempFreqMap = new HashMap<Character, Integer>();
            char[] characters = word.toCharArray();
            for (Character c : characters) {
                if (!tempFreqMap.containsKey(c)) {
                    tempFreqMap.put(c, 1);
                } else {
                    tempFreqMap.put(c, tempFreqMap.get(c) + 1);
                }
            }
            for (Map.Entry<Character, Integer> set : tempFreqMap.entrySet()) {
                maxFreqMap.putIfAbsent(set.getKey(), set.getValue());
                if (maxFreqMap.get(set.getKey()) < set.getValue()) {
                    maxFreqMap.replace(set.getKey(), set.getValue());
                }
            }
        }
        for (Map.Entry<Character, Integer> finalSet : maxFreqMap.entrySet()) {
            Character currentKey = finalSet.getKey();
            Integer freqValue = finalSet.getValue();
            for (int i = 0; i < freqValue; i++) {
                result.add(currentKey);
            }
        }
        char[] charResult = new char[result.size()];
        for (int c = 0; c < result.size(); c++) {
            charResult[c] = result.get(c);
        }
        return charResult;
    }

}
