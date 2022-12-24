package works;

public class MainArray {
    public static void main(String[] args) {

        // Array
        // Diziler
        // String[] diziAdi = { "Değer - 1", "Değer  - 2", ... };

        // dizi tanımlama
        String[] users = new String[5];
        users[0] = "Erkan";
        users[1] = "Serkan";
        users[2] = "Mehmet";
        users[3] = "Zehra";
        users[4] = "Ayşe";

        String[] cities = { "Çeşme", "Antalya", "Muğla", "İzmir", "Aydın" };
        String ist = "İstanbul";

        System.out.println(ist);
        System.out.println(cities);
        // single item
        // index -> 0'dan başlar
        System.out.println( cities[0] );

        // item value change
        cities[1] = "Bodrum";

        System.out.println( cities[1] );
        System.out.println( cities[2] );
        System.out.println( cities[3] );
        System.out.println( cities[4] );

        // dizi size
        int size = cities.length;
        System.out.println( "Size : " + size );

        // user select index
        int i = -10;
        if ( i >= 0 && size > i ) {
            System.out.println( cities[i] );
        }else {
            System.out.println( "Not Found Index" );
        }


    }
}
