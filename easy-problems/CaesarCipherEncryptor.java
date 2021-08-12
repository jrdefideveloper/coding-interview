class CaesarCipherEncryptor { 

    /** 
     * Returns new character after shifting left by newKey
     * @param currentChar
     * @param newKey
     * @return Character
     */
    public static Character getNewLetter(Character currentChar, int newKey) { 
        int charShift = currentChar + newKey; 
        return (charShift > 'z') ? (char) (charShift -=26) : (char) (charShift); 
    }

    /** 
     * O(n) time complexity | O(n) space
     * 
     * 'a' = 97 
     * 'z' = 122 
     * 
     * @param str
     * @param key
     * @return String
     */
    public static String caesarCypherEncryptor(String str, int key) {
        char[] charArray = str.toCharArray(); 
        StringBuilder sb = new StringBuilder(); 
        int newKey = key % 26; 
        for (int idx = 0; idx < charArray.length; idx++) { 
            char currentChar = charArray[idx]; 
            sb.append(getNewLetter(currentChar, newKey)); 
        }
        return sb.toString();
    }

    public static void main(String[] args) { 
        String testcase = "abc"; 
        System.out.println(caesarCypherEncryptor(testcase, 52));
    }
}