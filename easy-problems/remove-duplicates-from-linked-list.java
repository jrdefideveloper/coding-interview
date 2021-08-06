class RemoveDuplicatesFromLinkedList {

    public static class LinkedList 
    { 
        public int value; 
        public LinkedList next; 

        public LinkedList(int value) { 
            this.value = value; 
            this.next = null; 
        }
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) { 
        LinkedList slowPointer = linkedList; 
        LinkedList fastPointer = linkedList.next; 

        // We haven't reached tail.next yet 
        while (fastPointer != null) { 
            if (fastPointer.value == slowPointer.value) { 
                slowPointer.next = fastPointer.next; 
                fastPointer = fastPointer.next; 
            } else { 
                slowPointer = fastPointer; 
                fastPointer = fastPointer.next; 
            }
        }
        return linkedList; 
    }


    
    /** 
     * Given the read of a singly linked list whose nodes are in sorted order with respec to their values. 
     * Write a function that returns a modified version of the linkedlist that doesn't contain any nodes with duplicate values 
     * the linkedlist should be modified in place (i.e don't create a new list). Modified nodes should have 
     * its nodes sorted with respect to their values 
     * 
     * @param args
     */
    public static void main(String[] args) { 
        LinkedList head = new LinkedList(1); 
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(3); 
        head.next.next.next = new LinkedList(4); 
        head.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next.next = new LinkedList(5);
        head.next.next.next.next.next.next.next = new LinkedList(6);
        head.next.next.next.next.next.next.next.next = new LinkedList(7);

        LinkedList newhead = removeDuplicatesFromLinkedList(head); 

        StringBuilder sb = new StringBuilder(); 
        while (newhead != null) { 
            sb = sb.append(newhead.value + ", ");
            newhead = newhead.next;
        }
        sb.deleteCharAt(sb.length() - 2); 
        System.out.println(sb.toString());
    }

}
