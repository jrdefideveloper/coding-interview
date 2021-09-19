import java.util.*;

public class ValidIpAddresses {

    /* 

        1921680 
        
        1.9.2.1680 
        first ss = [0, i] -> 1
        second ss = [i, j -> i + 1] -> 9
        third ss = [j, k -> j + 1] -> 2 
        fourth ss = [k -> j + 1, end] -> 1680 

        Since we know an ip address is represented by 32 bits. 
        We know we can only check 2^32 different combinations.  
        Constant upperbound. 
        Every part is 8 bits (0-255) = 256 x 256 x 256 x 256 = 2 ^ 32

    */ 

    /** 
     * Constant time and space because you know it'll always be 2^32 doesn't depend on input 
     * @param string
     * @return ArrayList<String>
     */
    public static ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> ipAddressesFound = new ArrayList<String>();
        // Place first period
        for (int i = 1; i < Math.min((int)string.length(), 4); i++) {
            // If we have a string less than 4 we don't want an index error 
            String[] currentIPAddressParts = new String[] { "", "", "", "" };
            currentIPAddressParts[0] = string.substring(0, i);
            if (!isValidPart(currentIPAddressParts[0])) {
                continue; 
            }
            // Place second period 
            for (int j = i + 1; j < (i + Math.min((int) string.length() - i, 4)); j++) { 
                currentIPAddressParts[1] = string.substring(i, j); 
                if (!isValidPart(currentIPAddressParts[1])) { 
                    continue; 
                }
                // Place third period and fourth period 
                for (int k = j + 1; k < (j + Math.min((int) string.length() - j, 4)); k++) { 
                    currentIPAddressParts[2] = string.substring(j, k); 
                    currentIPAddressParts[3] = string.substring(k, string.length());   
                    if (isValidPart(currentIPAddressParts[2]) && isValidPart(currentIPAddressParts[3])) { 
                        ipAddressesFound.add(join(currentIPAddressParts)); 
                    }
                }
            }
        }
        return ipAddressesFound;
    }

    
    /** 
     * Check whether or not the current part is valid. 
     * @param part
     * @return boolean
     */
    public static boolean isValidPart(String part) {
        Integer stringAsInt = Integer.parseInt(part);  
        if (stringAsInt > 255) return false; 
        return part.length() == (stringAsInt.toString()).length(); 
    }

    
    /** 
     * Join an array of strings back into a string.
     * @param strings
     * @return String
     */
    public static String join(String[] strings) { 
        StringBuilder sb = new StringBuilder(); 
        for (int l = 0; l < strings.length; l++) { 
            sb.append(strings[l]); 
            if (l < strings.length - 1) { 
                sb.append("."); 
            }
        }
        return sb.toString(); 
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<String> validIPs = validIPAddresses("1921680");   
        for (String ip : validIPs) { 
            System.out.println(ip); 
        }
        System.out.println("Found " + validIPs.size() + " results"); 
    }

}
