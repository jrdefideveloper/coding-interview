import java.util.*; 

public class LoggerRateLimiter {

    HashMap<String, Integer> nextAvailableTime; 
    
    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        nextAvailableTime = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!nextAvailableTime.containsKey(message)) { 
            nextAvailableTime.put(message, timestamp + 10); 
            return true; 
        } else { 
            // Check if it's ok to print 
            if (timestamp >= nextAvailableTime.get(message)) { 
                nextAvailableTime.replace(message, timestamp + 10); 
                return true; 
            } else { 
                return false; 
            }
        }
    }
    
}
