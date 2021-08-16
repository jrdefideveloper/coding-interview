public class ArrayyOfProducts {

    
    /** 
     * O(n) time | O(n) space  
     * @param array
     * @return int[]
     */
    public static int[] arrayOfProducts(int[] array) {
        int[] products = new int[array.length];

        int leftRunningProduct = 1;
        for (int i = 0; i < array.length; i++) {
            products[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }

        int rigthRunningProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            products[i] *= rigthRunningProduct;
            rigthRunningProduct *= array[i];
        }

        return products; 
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {

    }

}
