import java.util.*;

public class PhoneNumberMneumonics {

    public static HashMap<Character, String[]> digitsMapper = new HashMap<Character, String[]>();

    static {
        digitsMapper.put('0', new String[] { "0" });
        digitsMapper.put('1', new String[] { "1" });
        digitsMapper.put('2', new String[] { "a", "b", "c" });
        digitsMapper.put('3', new String[] { "d", "e", "f" });
        digitsMapper.put('4', new String[] { "g", "h", "i" });
        digitsMapper.put('5', new String[] { "j", "k", "l" });
        digitsMapper.put('6', new String[] { "m", "n", "o" });
        digitsMapper.put('7', new String[] { "p", "q", "r", "s" });
        digitsMapper.put('8', new String[] { "t", "u", "v" });
        digitsMapper.put('9', new String[] { "w", "x", "y", "z" });
    }

    
    /** 
     * O(4^n* n)
     * @param idx
     * @param phoneNumber
     * @param currentMneumonic
     * @param allMneumonics
     */
    public void phoneNumberMnemonicsHelper(int idx, String phoneNumber, String[] currentMneumonic,
            ArrayList<String> allMneumonics) {
        if (idx == phoneNumber.length()) {
            String mneumonic = String.join("", currentMneumonic);
            allMneumonics.add(mneumonic);
        } else {
            Character digit = phoneNumber.charAt(idx);
            String[] letters = digitsMapper.get(digit);
            for (String letter : letters) {
                currentMneumonic[idx] = letter;
                phoneNumberMnemonicsHelper(idx + 1, phoneNumber, currentMneumonic, allMneumonics);
            }
        }
    }

    
    /** 
     * O(4^n* n)
     * @param phoneNumber
     * @return ArrayList<String>
     */
    public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        ArrayList<String> allMneumonics = new ArrayList<String>();
        String[] currentMneumonic = new String[phoneNumber.length()];
        Arrays.fill(currentMneumonic, "0");
        phoneNumberMnemonicsHelper(0, phoneNumber, currentMneumonic, allMneumonics);
        return allMneumonics;
    }

}
