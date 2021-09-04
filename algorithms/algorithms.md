# Algorithms 

Most popular algorithms that may show in the interviews 

+ Depth first search 
+ Breadth first search 
+ In order, preorder, postorder traversal 
+ Level order traversal (BFS)
+ Greedy Algorithms 


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


# Sorting (bad)

## Bubble Sort 

```java 
public static int[] bubbleSort(int[] array) {
    if (array.length == 0)
        return new int[] {};
    int counter = 0;
    boolean isSorted = false;
    while (!isSorted) {
        isSorted = true;
        for (int i = 0; i < array.length - 1 - counter; i++) {
            if (array[i] > array[i + 1]) {
                swap(array, i, i + 1);
                isSorted = false;
            }
        }
        counter++;
    }
    return array;
}
``` 

## Insertion Sort

```java 
public static int[] insertionSort(int[] array) {
    for (int i=1; i < array.length; i++) { 
        int j = i; 
        while (j > 0 && array[j] < array[j-1]) { 
            swap(array, j, j-1);  
            j-=1; 
        }
    }
    return array;
}
``` 

## Selection Sort 

```java 
public static int[] selectionSort(int[] array) {
    // Sorted and unsorted sublist.
    // In the beginning everything is unsorted.
    int currentIdx = 0;
    while (currentIdx < array.length - 1) {
        // Find index of the smallest number
        int smallestIdx = currentIdx;
        for (int i = currentIdx + 1; i < array.length; i++) {
            if (array[smallestIdx] > array[i]) {
                smallestIdx = i;
            }
        }
        swap(array, currentIdx, smallestIdx);
        currentIdx++; // start of the unsorted sublist.
    }
    return array;
}
```