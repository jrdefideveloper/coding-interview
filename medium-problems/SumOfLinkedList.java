import java.util.*;

public class SumOfLinkedList {

    // Typical Linked list class
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    /**
     * O(n) time | O(n) space where n represents the number of nodes in the longer
     * linkedlist
     * 
     * @param linkedListOne
     * @param linkedListTwo
     * @return LinkedList
     */
    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList newLinkedListHeadPointer = new LinkedList(0);
        LinkedList currentNode = newLinkedListHeadPointer;
        int carry = 0;

        LinkedList nodeOne = linkedListOne;
        LinkedList nodeTwo = linkedListTwo;

        while (nodeOne != null || nodeTwo != null || carry != 0) {
            int valueOne = (nodeOne != null) ? nodeOne.value : 0;
            int valueTwo = (nodeTwo != null) ? nodeTwo.value : 0;
            int sumOfValues = valueOne + valueTwo + carry;

            int newValue = sumOfValues % 10;
            LinkedList newNode = new LinkedList(newValue);

            currentNode.next = newNode;
            currentNode = newNode;

            carry = sumOfValues / 10; // Carry is sum of digits in current column / 10
            nodeOne = (nodeOne != null) ? nodeOne.next : null;
            nodeTwo = (nodeTwo != null) ? nodeTwo.next : null;

        }

        return newLinkedListHeadPointer.next;
    }

    public static LinkedList addMany(LinkedList linkedList, int[] values) {
        var current = linkedList;
        while (current.next != null) {
            current = current.next;
        }
        for (var value : values) {
            current.next = new LinkedList(value);
            current = current.next;
        }
        return linkedList;
    }

    public static ArrayList<Integer> getNodesInArray(LinkedList linkedList) {
        ArrayList<Integer> nodeValues = new ArrayList<Integer>();
        LinkedList current = linkedList;
        while (current != null) {
            nodeValues.add(current.value);
            current = current.next;
        }
        return nodeValues;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LinkedList ll1 = addMany(new LinkedList(2), new int[] { 4, 7, 1 });
        LinkedList ll2 = addMany(new LinkedList(9), new int[] { 4, 5 });
        LinkedList expected = addMany(new LinkedList(1), new int[] { 9, 2, 2 });
        var actual = sumOfLinkedLists(ll1, ll2);
        boolean result = getNodesInArray(expected).equals(getNodesInArray(actual));
        System.out.println("Result is correct = " + result);
    }

}
