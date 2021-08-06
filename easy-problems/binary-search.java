class BinarySearch { 

    public static int binarySearchRecursive(int[] array, int target) { 
        return binarySearchRecursive(array, target, 0, array.length - 1); 
    }

    public static int binarySearchRecursive(int[] array, int target, int left, int right) { 
        if (right >= 1) { 
            int mid = (left + right) / 2; 
            if (array[mid] == target) 
                return mid; 

            if (array[mid] > target) { 
                return binarySearchRecursive(array, target, left, mid - 1); 
            } else { 
                return binarySearchRecursive(array, target, mid + 1, right); 
            }
        } 
        return -1; 
    }

    public static int binarySearchIterative(int[] array, int target) { 
        int left = 0, right = array.length - 1; 
    
        while (left <= right) { 
            int mid = (left + right) / 2; 
            if (array[mid] == target) { 
                return mid; 
            } else if (array[mid] > target){ 
                right = mid - 1; 
            } else { 
                left = mid + 1; 
            }
        }

        return -1; 
    }

    
    /** 
     * Write a function that takes in a sorted array of integers as well as a target integer. The function 
     * should use the binary search algo to determin if the target integer is contained in the 
     * array and should return it's index if it is, otherwise -1. 
     * @param args
     */
    public static void main(String[] args) { 
        int[] array = new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73}; 
        int target = 33; 
        System.out.println(binarySearchRecursive(array, target));
        // Result should be idx 3. 

    }
}