import java.util.*; 

public class EmployeeImportance {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    HashMap<Integer, Employee> eMap = new HashMap<Integer, Employee>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            eMap.putIfAbsent(employee.id, employee);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(eMap.get(id)); // Queue is not empty.
        int sum = 0;
        while (queue.size() > 0) {
            Employee e = queue.poll();
            sum += e.importance;
            for (Integer subId : e.subordinates) {
                queue.offer(eMap.get(subId));
            }
        }
        return sum;
    }

    public int dfs(int eid) {
        Employee current = eMap.get(eid);  
        int sum = current.importance; 
        for (Integer subId : current.subordinates) { 
            sum += dfs(subId); 
        }
        return sum; 
    }

    public int getImportanceRecursive(List<Employee> employees, int id) { 
        for (Employee employee : employees) {
            eMap.putIfAbsent(employee.id, employee);
        }
        return dfs(id); 
    }

    public static void main(String[] args) { 

    }

}
