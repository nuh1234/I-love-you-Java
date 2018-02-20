
/**
 *
 * @author nuh.mohamud
 */
import java.util.*;

public class P3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Marty", "206-685-2181");
        map.put("Rick", "520-621-6126");
        map.put("Beekto", "206-685-2181");
        map.put("Jenny", "253-867-5309");
        map.put("Stuart", "206-685-9138");
        map.put("DirectTV", "800-494-4388");
        map.put("Bob", "206-685-9138");
        map.put("Benson", "206-616-1246");
        map.put("Hottline", "900-674-2767");

        System.out.println(countInAreaCode(map, "206"));//should be 3
        System.out.println(countInAreaCode(map, "425"));//should be 0
        System.out.println(countInAreaCode(map, "800"));//should be 1
    }

    public static int countInAreaCode(Map<String, String> map, String areaCode) {
        HashSet<String> numbers = new HashSet<>();
        for (String s : map.values()) {
            if (s.substring(0, 3).equals(areaCode)) {
                numbers.add(s);
            }
        }
        return numbers.size();
    }
}
