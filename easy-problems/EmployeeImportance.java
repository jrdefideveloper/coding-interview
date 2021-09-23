import java.util.*; 

public class EmployeeImportance {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> eMap = new HashMap<Integer, Employee>();
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

    public static void main(String[] args) { 

    }

}
