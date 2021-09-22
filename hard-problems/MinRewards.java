import java.util.*; 

public class MinRewards {

    public static void handleLeftAndRightStudent(int[] scores, int[] rewards) { 
        int lastStudentIdx = scores.length - 1; 
        if (scores[lastStudentIdx] < scores[lastStudentIdx - 1]) { 
            rewards[lastStudentIdx] = 1; 
        }
        int firstStudentIdx = 0; 
        if (scores[firstStudentIdx] < scores[firstStudentIdx + 1]) { 
            rewards[firstStudentIdx] = 1; 
        }
    }

    public static int minRewards(int[] scores) {
        int[] rewards = new int[scores.length];
        int tempMinNumber = Integer.MAX_VALUE;  
        Arrays.fill(rewards, 1); 
        for (int i = 1; i < scores.length; i++) { 
            if (scores[i] < scores[i - 1]) { 
                rewards[i] = rewards[i - 1] - 1; 
            } else if (scores[i] > scores[i - 1]){ 
                rewards[i] = rewards[i - 1] + 1; 
            }  
            if (tempMinNumber > rewards[i]) { 
                tempMinNumber = rewards[i]; 
            }
        }
        for (int reward : rewards) { 
            System.out.print(reward + " "); 
        }
        System.out.println("");

        if (tempMinNumber < 1) { 
            int incrementBy = 1 - tempMinNumber; 
            for (int i = 0; i < scores.length; i++) { 
                rewards[i] = rewards[i] + incrementBy; 
            }
        }
        // Handle the most left and right students 
        handleLeftAndRightStudent(scores, rewards); 

        int minReward = 0; 
        for (int reward : rewards) { 
            System.out.print(reward + " "); 
            minReward += reward; 
        }
        return minReward;
    }

    public static void main(String[] args) {
        int[] testInput = new int[] {8, 4, 2, 1, 3, 6, 7, 9, 5}; 
        int[] testInput2 = new int[] { 800, 400, 20, 10, 30, 61, 70, 90, 17, 21, 22, 13, 12, 11, 8, 4, 2, 1, 3, 6, 7, 9, 0, 68, 55, 67, 57, 60, 51, 661, 50, 65, 53 };
        System.out.println("The minimum rewards needed is " + minRewards(testInput2));
    }

}
