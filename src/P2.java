

/**
 *
 * @author nuh.mohamud
 */
import java.util.*;
public class P2 {

 
     public static void main(String[] args){
        System.out.println(allStar("hello"));
        System.out.println(allStar("abc"));
        System.out.println(allStar("ab"));
    }
    
    public static String allStar(String s){
       if(s.length() == 1) {
           return s.substring(0);
       }else{
           return  allStar(s.substring(0, s.length() -1)) + "*" + s.charAt(s.length() - 1);
       }
    }

    
}
