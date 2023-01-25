package appPack;

import java.util.HashMap;
import java.util.Set;

public class MainApp {
    public static void main(String[] args) {

        // HashMap
        // Key - Val
        // Değerler eklenirken key(anahtar), val(değer) şeklinde ekleme yapılır.
        // Anahtarlar benzersiz olmak zorundadırlar.
        // Aynı değere sahip anahtar eklediğinizde en son eklediğiniz değer geçerli olur.
        // Sıralama algoritması önemli değildir.
        // Hashmap olaylarında index kavramı yoktur.
        // Değerler key'lere göre çağrılmış olurlar.
        // Üretilirken <KEY, VAL> değer türleri atanmalıdır.

        HashMap<String, Object> hm = new HashMap<>();

        // değer ekleme
        String name = "Erkan";
        String surname = "Bilmem";
        Integer age = 30;
        Boolean status = true;
        String address = "İstanbul";

        hm.put("name", name);
        System.out.println("name: " + name.hashCode() );

        hm.put("surname", surname);
        System.out.println( "surname: "+ surname.hashCode() );

        hm.put("age", age);
        System.out.println("age: " + age.hashCode() );

        hm.put("status", status);
        System.out.println( "status: "+ status.hashCode() );

        hm.put("address", address);
        System.out.println( "address: "+ address.hashCode() );

        hm.put("address", "Ankara");

        // Değere Erişim
        Object nm = hm.get("name");
        System.out.println(nm);


        // Tüm elemanları ayrı ayrı yazdırma
        Set<String> keys = hm.keySet();
        for ( String key : keys ) {
            Object val = hm.get(key);
            System.out.println( key + " : " + val );
        }

        // değer silme
        Object statu = hm.remove("status");
        System.out.println(statu);

        // tüm elemaları silme
        // hm.clear();

        // eleman sayısı
        int size = hm.size();
        System.out.println(size);


        System.out.println(hm);
    }
}
