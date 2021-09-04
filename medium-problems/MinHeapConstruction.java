import java.util.*;

public class MinHeapConstruction {

    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        // Every parent node is bigger than it's children nodes but not in sorted order*
        // currentNode = i
        // childOne = 2i + 1;
        // childTwo = 2i + 2;
        // parentNode = floor((i - 1) / 2);
        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        // O(n) time
        // Start at parent node and call sift down method. Calling sift down on n nodes
        // Every level higher you get the longer sift down takes
        // Majority of nodes is at the bottom
        // As a result this converges to O(n)
        // If you use sift up* however it will end up running in O(nlogn time)
        public List<Integer> buildHeap(List<Integer> array) {
            int firstParentIdx = (array.size() - 2 / 2);
            for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
                siftDown(currentIdx, array.size() - 1, array);
            }
            return array;
        }

        // O(log n) time
        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            // Swapping a node eliminates half the tree every time.
            int childOneIdx = currentIdx * 2 + 1;
            while (childOneIdx <= endIdx) {
                int childTwoIdx = (currentIdx * 2 + 2) <= endIdx ? currentIdx * 2 + 2 : -1;
                int idxToSwap;
                if (childTwoIdx != -1 && heap.get(childTwoIdx) < heap.get(childOneIdx)) {
                    idxToSwap = childTwoIdx;
                } else {
                    idxToSwap = childOneIdx;
                }
                if (heap.get(idxToSwap) < heap.get(currentIdx)) {
                    swap(currentIdx, idxToSwap, heap);
                    currentIdx = idxToSwap;
                    childOneIdx = currentIdx * 2 + 1;
                } else {
                    return;
                }
            }
        }

        // O(log n) time
        public void siftUp(int currentIdx, List<Integer> heap) {
            // Swapping a node eliminates half the tree every time
            int parentIdx = (currentIdx - 1) / 2;
            while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
                swap(currentIdx, parentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2;
            }
        }

        public int peek() {
            return heap.get(0);
        }

        // O(log n) time
        public int remove() {
            swap(0, heap.size() - 1, heap);
            int valueToRemove = heap.get(heap.size() - 1);
            heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return valueToRemove;
        }

        // O(log n) time
        public void insert(int value) {
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }

        public void swap(int i, int j, List<Integer> heap) {
            Integer temp = heap.get(j);
            heap.set(j, heap.get(i));
            heap.set(i, temp);
        }

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
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(
                new ArrayList<Integer>(Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41)));
        minHeap.insert(76);
        boolean correctMinHeap = minHeap.isMinHeapPropertySatisfied(minHeap.heap);
        System.out.println("Min heap is valid = " + correctMinHeap);

    }

}
