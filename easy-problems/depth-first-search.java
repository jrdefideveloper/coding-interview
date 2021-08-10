import java.util.*;

class DepthFirstSearch {

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        // O(v + e) time | O(v) space
        public List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);  
            for (int i = 0; i < children.size(); i++) { 
                children.get(i).depthFirstSearch(array); 
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }

    }

    public static void main(String[] args) {
        Node root = new Node("A"); 
        root.children = new ArrayList<Node>();  
        root.children.add(new Node("B")); 
        root.children.add(new Node("C")); 
        root.children.add(new Node("D")); 
        root.children.get(0).addChild("E"); 
        root.children.get(0).addChild("F"); 
        root.children.get(0).children.get(1).addChild("I"); 
        root.children.get(0).children.get(1).addChild("J"); 
        root.children.get(2).addChild("G"); 
        root.children.get(2).addChild("H"); 
        root.children.get(2).children.get(0).addChild("K");
        ArrayList<String> dfsOrder = new ArrayList<String>(); 
        root.depthFirstSearch(dfsOrder); 

        for (String s : dfsOrder) { 
            System.out.println(s);
        }

    }

}
