# Min and Max Heap 

These can typically constructed simply from a dynamic ArrayList<Integer>. 
The first index should house either the minimum element in the list or the maximum element in the list. 

Every parent node in the list should be smaller than it's children if it's a minHeap. Conversely every parent node in the list should be larger than it's children if it's a maxHeap. 

The list is not necessarily a sorted list. Remember we are prioritizing the min or max element.   

## Accessing parent and children nodes 

A parent node can be accessed via `floor of (currentIdx - 1) / 2`  
The first child node can be accessed via `2*currentIdx + 1` 
The second child node can be accessed via `2*currentIdx + 2`  

## Typical functions 

+ siftDown() - O(logn)
+ siftUp() - O(log n)
+ remove() - O(logn) because it needs to call siftDown() 
+ insert() - O(logn) because it needs to call siftUp()
+ buildHeap() - O(n)

## 

```java 
public boolean isMinHeapPropertySatisfied(List<Integer> array) { 
    for (int currentIdx = 1; currentIdx < array.size(); currentIdx++) { 
        int parentIdx = (currentIdx - 1) / 2; 
        if (parentIdx < 0) { 
            return true; 
        } 
        if (array.get(parentIdx) > array.get(currentIdx)) { 
            return false; 
        }
    }
    return true; 
}
``` 