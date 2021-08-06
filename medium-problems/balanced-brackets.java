import java.util.Stack;

class BalancedBrackets {

    public static boolean isOpenBracket(Character c) { 
        return (c == '(' || c == '{' || c == '['); 
    }

    public static boolean isClosingBracket(Character c) { 
        return (c == ')' || c == '}' || c ==  ']'); 
    }

    public static boolean isOpposite(Character first, Character second) { 
        if (first == '(' && second == ')') return true; 
        if (first == '{' && second == '}') return true; 
        if (first == '[' && second == ']') return true; 
        return false; 
    } 

    /** 
     * Takes in a string made up of brackets and other optional characters.  
     * Function returns a boolean representing whether the string is balanced with regards to brackets. 
     * 
     * O(n) time; O(n) extra space for the stack. 
     * 
     * @param str
     * @return boolean
     */
    public static boolean balancedBrackets(String str) {
        char[] charArray = str.toCharArray();  
        int idx = 0; 
        Stack<Character> stack = new Stack<Character>(); 

        while (idx < str.length()) { 
            char currentChar = charArray[idx]; 
            if (isOpenBracket(currentChar)) { 
                stack.push(currentChar); 
            } else if (isClosingBracket(currentChar)) { 
                if (stack.empty())
                    return false; 
                if (!isOpposite(stack.pop(), currentChar))
                    return false; 
            }
            // if it's a letter or something other than a bracket we just skip it. 
            idx++; 
        }
        return (stack.isEmpty());
    }

    public static void main(String[] args) { 
        String testcase = "([";  // This should result in true. 
        System.out.println(balancedBrackets(testcase));
    }
}
