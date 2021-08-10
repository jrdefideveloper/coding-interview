# Algorithms 

Most popular algorithms that may show in the interviews 

+ Depth first search 
+ Breadth first search 
+ In order, preorder, postorder traversal 
+ Level order traversal (BFS)


# Depth First Search 

+ O(v + e) time complexity 
+ O(v) space complexity (array holds v different nodes) in the worst case scenario it takes an addtional o(v) space because we're adding a bunch of frames into the call stack. 

```java 
    // O(v + e) time | O(v) space
    public List<String> depthFirstSearch(List<String> array) {
        array.add(this.name);  
        for (int i = 0; i < children.size(); i++) { 
            children.get(i).depthFirstSearch(array); 
        }
        return array;
    }
```