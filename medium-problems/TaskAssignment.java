import java.util.*; 

public class TaskAssignment {

    
    /** 
     * O(n log n) time | O(n) space (n is number of tasks)
     * @param k
     * @param tasks
     * @return ArrayList<ArrayList<Integer>>
     */
    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        ArrayList<ArrayList<Integer>> pairedTasks = new ArrayList<ArrayList<Integer>>();
        
        // Can also achieve the same result with a min and max heap. 
        HashMap<Integer, ArrayList<Integer>> taskDurationsToIndices = getTaskDurationsToIndices(tasks);

        ArrayList<Integer> sortedTasks = tasks;
        Collections.sort(sortedTasks);

        for (int idx = 0; idx < k; idx++) {
            int task1Duration = sortedTasks.get(idx);
            ArrayList<Integer> indicesWithTask1Duration = taskDurationsToIndices.get(task1Duration);
            int task1Index = indicesWithTask1Duration.remove(indicesWithTask1Duration.size() - 1);

            int task2Duration = sortedTasks.get(tasks.size() - idx - 1);
            ArrayList<Integer> indicesWithTask2Duration = taskDurationsToIndices.get(task2Duration);
            int task2Index = indicesWithTask2Duration.remove(indicesWithTask2Duration.size() - 1);

            ArrayList<Integer> pair = new ArrayList<Integer>();
            pair.add(task1Index);
            pair.add(task2Index);
            pairedTasks.add(pair);

        }
        return pairedTasks;
    }

    
    /** 
     * Converting every element into hashMap 
     * 
     * @param tasks
     * @return HashMap<Integer, ArrayList<Integer>>
     */
    public HashMap<Integer, ArrayList<Integer>> getTaskDurationsToIndices(ArrayList<Integer> tasks) {
        HashMap<Integer, ArrayList<Integer>> taskDurationToIndices = new HashMap<Integer, ArrayList<Integer>>();

        for (int idx = 0; idx < tasks.size(); idx++) {
            int taskDuration = tasks.get(idx);
            if (taskDurationToIndices.containsKey(taskDuration)) {
                taskDurationToIndices.get(taskDuration).add(idx);
            } else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(idx);
                taskDurationToIndices.put(taskDuration, temp);
            }
        }
        return taskDurationToIndices;
    }

}
