
package javaapplication4;

/**
 *
 * @author nuh.mohamud
 */
import java.util.*;

public class P4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(5, 7, 8, 9));
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(3, 2, 1));
        System.out.println(isConsecutive(list1));// should be true
        System.out.println(isConsecutive(list2));// should be false
        System.out.println(isConsecutive(list3));// should be false

    }

    public static boolean isConsecutive(ArrayList<Integer> list) {
       for(int i = 0; i < list.size() - 1; i++) {
           if((list.get(i) + 1) != list.get(i + 1)) {
               return false;
           }
       }
       return true;
    }
}
