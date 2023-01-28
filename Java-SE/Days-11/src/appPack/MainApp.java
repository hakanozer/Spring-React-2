package appPack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApp {
    public static void main(String[] args) {


        List<Map<String, String>> ls = new ArrayList<>();

        Map<String, String> hm1 = new HashMap<>();
        hm1.put("name", "Ali Bilmem");
        hm1.put("age", "30");
        ls.add(hm1);

        HashMap<String, String> hm2 = new HashMap<>();
        hm2.put("name", "Ahmet Bilsin");
        hm2.put("age", "25");
        ls.add(hm2);

        HashMap<String, String> hm3 = new HashMap<>();
        hm3.put("name", "Zehra Bilirim");
        hm3.put("age", "34");
        ls.add(hm3);


        for (int i = 0; i < 10; i++) {
            HashMap<String, String> hmx = new HashMap<>();
            hmx.put("name", "Name-"+i);
            hmx.put("age", ""+ (25 + i) );
            ls.add(hmx);
        }

        for ( Map<String, String> item : ls ) {
            System.out.println( item.get("name") );
        }


    }
}
