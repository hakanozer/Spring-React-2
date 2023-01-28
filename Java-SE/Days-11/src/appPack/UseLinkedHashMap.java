package appPack;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class UseLinkedHashMap {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("name", "Ali");
        hm.put("surname", "Bilmem");
        hm.put("age", 30);
        hm.put("status", true);
        hm.put("random", new Random());
        for (int i = 0; i < 100000; i++) {
            hm.put("i"+i, i);
        }
        long end = System.currentTimeMillis();
        long beetween = end - start;
        System.out.println( hm );


        long startx = System.currentTimeMillis();
        Map<String, Object> hmx = new HashMap<>();
        hmx.put("name", "Ali");
        hmx.put("surname", "Bilmem");
        hmx.put("age", 30);
        hmx.put("status", true);
        hmx.put("random", new Random());
        for (int i = 0; i < 100000; i++) {
            hmx.put("i"+i, i);
        }
        long endx = System.currentTimeMillis();
        long beetweenx = endx - startx;
        System.out.println( hmx );

        System.out.println( "LinkedHashMap : " + beetween );
        System.out.println( "HashMap : " + beetweenx );
    }
}
