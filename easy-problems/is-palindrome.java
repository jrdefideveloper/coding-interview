class IsPalindrome {

    // O(n) time complexity; O(1) space 
    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    
    /** 
     * O(n) time complexity; O(n) space complexity
     * 
     * @param str
     * @return boolean
     */
    public static boolean isPalindromeReverse(String str) {
        StringBuilder sb = new StringBuilder(str);  
        return (str.equals(sb.reverse().toString())); 
    }
    

    public static boolean isPalindromeRecursion(String str, int start) { 
        int end = str.length() - 1 - start; 
        return start >= end ? true : str.charAt(start) == str.charAt(end) && isPalindromeRecursion(str, start + 1); 
    }

    /** 
     * O(n) time complexity
     * O(letters) space complexity (call stack)
     * 
     * @param str
     * @return boolean
     */
    public static boolean isPalindromeRecursion(String str) { 
        // base case if we arrive at the middle then true.  
        // first letter == last and isPalindrome(mid) return true 
        return isPalindromeRecursion(str, 0); 
    }

    public static void main(String[] args) {
        String testcase = "abcdcba";
        System.out.println(isPalindromeRecursion(testcase));
    }

}
