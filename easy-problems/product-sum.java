import java.util.*;

class ProductSum {

    /**
     * Take in a "special" array and return it's product sum.
     * 
     * [x, y] = x + y [x, [y, z]] = x + 2 * (y + z) [x, [y, [z]]] = x + 2 * (y + 3z)
     * 
     * @param array
     * @return int
     */
    @SuppressWarnings("unchecked")
    public static int productSumHelper(List<Object> array, int level) {
        int sum = 0;
        for (int idx = 0; idx < array.size(); idx++) {
            if (array.get(idx) instanceof ArrayList) {
                sum += productSumHelper((ArrayList) array.get(idx), level + 1);
            } else {
                // it's a regular number.
                sum += (Integer) array.get(idx);
            }
        }
        return sum * level;
    }

    public static int productSum(List<Object> array) {
        return productSumHelper(array, 1);
    }

    public static void main(String[] args) {
        ArrayList<Object> special = new ArrayList<Object>();
        special.add(5);
        special.add(2);
        special.add(new ArrayList<Integer>(Arrays.asList(7, -1)));
        special.add(3);
        ArrayList<Object> specialNest = new ArrayList<Object>();
        specialNest.add(6);
        specialNest.add(new ArrayList<Integer>(Arrays.asList(-13, 8)));
        specialNest.add(4);
        special.add(specialNest);

    }

}
