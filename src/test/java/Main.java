import java.util.HashMap;

/**
 * Created by forvoid on 2017/7/31.
 */
public class Main {
       static HashMap hashMap = new HashMap(3);

    public static void main(String[] args) {
        System.out.println(4 & 3);
        hashMap.put("1","3");
        hashMap.put("2","2");
        hashMap.put("3","1");
//        hashMap.put("3","1");
        System.out.println(hashMap.get("1"));
        System.out.println(hashMap.get("2"));
        System.out.println(hashMap.get("3"));
    }
}
