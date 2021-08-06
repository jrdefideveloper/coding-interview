import java.util.*; 
class NonRepeatingCharacter {

    
    /** 
     * Compare everything against everything else in two nested for loops 
     * 
     * O(n^2) time; O(1) space 
     * 
     * @param string
     * @return int
     */
    public static int firstNonRepeatingCharacterBruteForce(String string) { 
        for (int i=0; i < string.length() - 1; i++) { 
            boolean foundDuplicate = false; 
            for (int j=1; j < string.length(); j++) { 
                if (string.charAt(i) == string.charAt(j)) { 
                    foundDuplicate = true; 
                }
            }
            if (!foundDuplicate) return i; 
        }
        return - 1; 
    
    }

    
    /** 
     * Takes in a string of lowercase English letters and returns the index of
     * the string's first non-repeating character 
     * 
     * The first non-repeating char is the first char in a string that occurs only once 
     * 
     * If the input string doesn't have any non-repeating characters, your function 
     * should return -1 
     * 
     * @param string
     * @return int
     */
    public static int firstNonRepeatingCharacterWithMap(String string) {
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>(); 
        char[] charArray = string.toCharArray(); 
          for (char letter : charArray) { 
              freq.put(letter, freq.getOrDefault(letter, 0) + 1); 
          }
          
          for (int i=0; i < charArray.length; i++) { 
              if (freq.get(charArray[i]) == 1)
                  return i; 
          }
        return -1;
    }

    public static void main(String[] args) { 
        String testcase = "abcdcaf"; // Answer should be b, index 1 
        System.out.println(firstNonRepeatingCharacterWithMap(testcase));
    }

    
}
