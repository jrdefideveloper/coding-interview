import java.util.*;

class ClassPhotos {

    /**
     * Class has an even number of students, and all of these students wearing red
     * or blue shirts. In fact, exactly half is wearing red and the other half is
     * wearing blue. Responsible for arranging the students in 2 rows before taking
     * each photo.
     * 
     * Each row all the red shirts must be in the same row all the blue shirts in
     * the other row Each student in the back is strictly taller than the student
     * directly in front of them in the front row.
     * 
     * Given two input arrays one containing the heights of all the students with
     * red shirts One containing the heights of all the students with blue shirts.
     * 
     * Return whether or not the class photo following the guideline can be taken.
     * 
     * O(nlogn) time; constant space. 
     * 
     * @param redShirtHeights
     * @param blueShirtHeights
     * @return boolean
     */
    public static boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        boolean redShirtTaller = (redShirtHeights.get(0) > blueShirtHeights.get(0));
        for (int idx = 0; idx < redShirtHeights.size(); idx++) {
            if (redShirtTaller) {
                if (redShirtHeights.get(idx) <= blueShirtHeights.get(idx))
                    return false;
            } else {
                if (redShirtHeights.get(idx) >= blueShirtHeights.get(idx))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> redShirtH = new ArrayList<Integer>(Arrays.asList(5, 8, 1, 3, 4));
        ArrayList<Integer> blueShirtH = new ArrayList<Integer>(Arrays.asList(6, 9, 2, 4, 5));
        System.out.println(classPhotos(redShirtH, blueShirtH));

    }

}
