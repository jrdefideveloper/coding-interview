import java.util.*; 

class Problem2 { 

    
    /** 
     * Returns true if the second array is a subsequence of the first array. 
     * 
     * A single number also counts as a subsequence 
     * 
     * array = [5, 1, 22, 25, 6, -1, 8, 10]  
     * sequence = [1, 6, -1, 10]  
     * 
     * true 
     * 
     * O(n) time complexity; O(1) space complexity 
     * 
     * @param array
     * @param sequence
     * @return boolean
     */
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) { 
        int arrayIndex = 0; 
        int sequenceIndex = 0; 
        while (arrayIndex < array.size() && sequenceIndex < sequence.size())
        { 
            if (array.get(arrayIndex) != sequence.get(sequenceIndex))  { 
                arrayIndex++; 
            } else { 
                sequenceIndex++; 
                arrayIndex++; 
            }
        }

        return (sequenceIndex == sequence.size()); 
    }


    public static boolean isValidSubsequence2(List<Integer> array, List<Integer> sequence) { 
        int seqIndex = 0; 
        for (Integer num : array) {  
            if (seqIndex == sequence.size()) { 
                break;  
            } 
            if (num == sequence.get(seqIndex)) { 
                seqIndex++; 
            }
        }

        return (seqIndex == sequence.size()); 
    }

    public static void main(String[] args) { 
        ArrayList<Integer> testCase1 = new ArrayList<Integer>(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10)); 
        ArrayList<Integer> sequence1 = new ArrayList<Integer>(Arrays.asList(1, 6, -1, 10)); 
        System.out.println(isValidSubsequence2(testCase1, sequence1));
    }


}