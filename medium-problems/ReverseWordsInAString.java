public class ReverseWordsInAString {


    /* 
        "AlgoExpert is the best!"
          
        "best! the is AlgoExpert"

        Start from the back and if it's not a whitespace

        Then when we hit a white space 

        reverse it again, and then add it to the result string 

        then we start adding whitespace 

        eht -> reverse again  

        
    */ 

    public static String reverseWordsInString(String string) {
        char[] characters = string.toCharArray();  
        reverseListRange(characters, 0, characters.length - 1); 
        int startOfWord = 0; 
       
        while (startOfWord < characters.length) { 
            int endOfWord = startOfWord; 
            while (endOfWord < characters.length && characters[endOfWord] != ' ') { 
                endOfWord++; 
            }
            reverseListRange(characters, startOfWord, endOfWord - 1);  
            startOfWord = endOfWord + 1; 
        }
        return new String(characters); 
    }
    

    public static char[] reverseListRange(char[] list, int start, int end) { 
        while (start < end) { 
            Character temp = list[start]; 
            list[start] = list[end];  
            list[end] = temp;  
            start++; 
            end--; 
        }
        return list; 
    }

    public static void main(String[] args) { 
        String input = "tim is great"; 
        System.out.println(reverseWordsInString(input)); 
    }
    
}
