
/**
 *
 * @author nuh.mohamud
 */
import java.util.*;

public class P1 {

    public static void main(String[] args) {
        System.out.println(array110(new int[]{1, 2, 20}, 0));// should be true
        System.out.println(array110(new int[]{3, 30}, 0));// should be true
        System.out.println(array110(new int[]{3}, 0));// should be false
        System.out.println(array110(new int[]{1, 2, 3, 10, 30}, 0));// should be false
    }

    public static boolean array110(int[] nums, int index) {
        while (index < nums.length - 1) {
            if ((nums[index] * 10) == nums[index + 1]) {
                return true;
            } else {
                return array110(nums, index + 1);
            }
        }
        return false;
    }
}
