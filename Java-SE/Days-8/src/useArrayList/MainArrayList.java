package useArrayList;


import java.util.ArrayList;
import java.util.Arrays;

public class MainArrayList {
    public static void main(String[] args) {

        // ArrayList
        // Mutable (Daha sonradan değiştirebilir) özelliğe sahip Dizi elemanlarıdır.
        // ArrayList bir sınıftır, List interface'ten implement almıştır.
        // ArrayListi kurarken hangi tür için çalıştırılacağını belirtmek gerekir.
        // ArrayListler generic üyeleridir (Oluşturulurken Tür alırlar.)

        String[] arr = {"İstanbul", "Ankara", "Antalya"};
        System.out.println(arr);
        ArrayList<String> list = new ArrayList<>();

        // Add Item
        list.add("İstanbul");
        list.add("Ankara");
        list.add("Antalya");
        list.addAll(Arrays.asList("İzmir", "Adana", "Samsun"));

        // Get item
        String item = list.get(0);
        System.out.println(item);

        // Total Size
        int size = list.size();
        System.out.println(size);

        // Total Items
        for( String city : list ) {
            System.out.println(city);
        }

        System.out.println(list);



    }
}
