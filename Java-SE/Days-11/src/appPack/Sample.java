package appPack;

import java.util.*;

public class Sample {
    public static void main(String[] args) {

        // ArrayList üretilirken Ata Tür olan List kullanılır.
        // List
        List<String> ls = new ArrayList<>();
        ArrayList<String> lsx = new ArrayList<>();

        // Hashmap üretilirken Ata Tür olan Map kullanılır.
        Map<String, String> hm = new HashMap<>();
        HashMap<String, String> hmx = new HashMap<>();

        // Set -> Benzersiz değerleri bir liste altında tutumak için kullanılır.
        // Sıralama algoritması önemli değildir.
        Set<String> set = new HashSet<>();

        // LinkedHashMap -> Sıralama algoritmasının önemli olduğu Map olaylarında kullanılır.
        Map<String, String> linkedMap = new LinkedHashMap<>();

        // LinkedHashSet -> sıralama ve benzersizliğin önemli olduğu collection olaylarında kullanılır.
        Set<String> linkedSet = new LinkedHashSet<>();


        // Enum -> Anahtar -> Key
        Map<EKeys, Object> hmt = new HashMap<>();
        hmt.put(EKeys.name, "Ali");
        hmt.put(EKeys.surname, "Bilmem");
        hmt.put(EKeys.age, 40);

        System.out.println( hmt.get(EKeys.name) );

        EKeys status = EKeys.name;
        switch ( status ) {
            case name:
                break;
            case age:
                break;
            case surname:
                break;
        }

        System.out.println( hmt );
    }
}
