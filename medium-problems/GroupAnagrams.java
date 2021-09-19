import java.util.*; 


public class GroupAnagrams {

    // O(word * nlogn) time | O(word) 
    public static List<List<String>> groupAnagrams(List<String> words) {
        HashMap<String, List<String>> anagramMap = new HashMap<String, List<String>>();  
        List<List<String>> anagramGroups = new ArrayList<List<String>>(); 

        for (String word : words) { 
            char[] tempWord = word.toCharArray(); 
            Arrays.sort(tempWord);   
            String sortedWord = new String(tempWord); 
            anagramMap.putIfAbsent(sortedWord, new ArrayList<String>());  
            anagramMap.get(sortedWord).add(word); 
        }

        for (List<String> results : anagramMap.values()) { 
            anagramGroups.add(results); 
        }
        return anagramGroups; 
      }
      

    public static void main(String[] args) { 
        List<String> input = new ArrayList<String>(Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp")); 
        List<List<String>> anagramGroup = groupAnagrams(input); 
    }
    
}
