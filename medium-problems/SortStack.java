import java.util.*; 

public class SortStack {

    public void insertInSortedOrder(ArrayList<Integer> stack, int value) {
        if (stack.size() == 0 || stack.get(stack.size() - 1) <= value) {
            stack.add(value);
            System.out.println("Adding " + value);
            return;
        }

        int top = stack.remove(stack.size() - 1);
        System.out.println(top + " is not in the right order removing...");
        insertInSortedOrder(stack, value);
        stack.add(top);
        System.out.println("Adding back " + top);
    }

    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        if (stack.size() == 0) {
            return stack;
        }

        int top = stack.remove(stack.size() - 1);
        sortStack(stack);

        insertInSortedOrder(stack, top);
        return stack;
    }

}
