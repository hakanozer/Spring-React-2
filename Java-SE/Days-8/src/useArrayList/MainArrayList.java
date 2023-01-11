package useArrayList;


import java.util.*;

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

        System.out.println("==================");

        for (int i = 0; i < list.size(); i++) {
            String data = list.get(i);
            System.out.println(data);
        }
        System.out.println("==================");

        // değeri Ankara olan elemanı sil
        // list.remove("Ankara");
        // list.remove(0);
        // list.removeAll(Arrays.asList("Ankara", "İstanbul", "Samsun"));

        // all items clear
        // list.clear();

        // index add
        list.add(2, "Erzurum");

        // contains -> liste içinde var mı
        boolean containsStatus = list.contains("Ankara");
        System.out.println("containsStatus : " + containsStatus);

        // addAll -> bir listeni bu liste içine eklenmesi
        List<String> ls = new ArrayList<>();
        ls.add("Gaziantep");
        ls.add("Şanlıurfa");
        ls.add("Gaziantep");
        list.addAll(ls);

        // indexOf -> bir değerin liste içinde nerede(hangi index'te) olduğunu bulur.
        int index = list.indexOf("Gaziantep");
        System.out.println(index);

        // lastIndexOf -> var olan değerin dışında aynı değerin sonraki index değerini getirir.
        int indexLast = list.lastIndexOf("Gaziantep");
        System.out.println(indexLast);

        // var olan bir index değerinini değiştirmeye yarar
        list.set(5, "Mersin" );

        // Sıralama
        Collections.sort(list); // A - Z
        Collections.reverse(list); // Z - A

        // Listeyi Dizi dönüştürme
        Object[] objects = list.toArray();

        // Bir diziyi Listeye dönüştürme
        String[] arrx = { "Van", "Ağrı" };
        List<String> newList = Arrays.asList(arrx);

        // to Iterator
        System.out.println("=======================s");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println( "iter: " + iterator.next() );
        }
        while (iterator.hasNext()) {
            System.out.println( "iterx: " + iterator.next() );
        }

        System.out.println(list);

    }
}
