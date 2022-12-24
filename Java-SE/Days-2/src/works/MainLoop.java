package works;

public class MainLoop {
    public static void main(String[] args) {

        // for loop
        int i = 0;
        for (i = 0; i < 10; i++) {
            System.out.println("i : " + i);
        }
        System.out.println("i end : " + i);

        // ++, --
        int x = 0;
        System.out.println((++x));
        System.out.println(x);

        String[] cities = { "Çeşme", "Antalya", "Muğla", "İzmir", "Aydın" };
        for (int j = 0; j < cities.length; j++) {
            String item = cities[j];
            System.out.println(item);
        }

        System.out.println("==========Foreach=======");
        // foreach
        for ( String item : cities ) {
            System.out.println(item);
        }

        String[] sections = {"Kış", "İlkbahar", "Yaz", "Sonbahar" };
        String[][] aylars = { {"Aralık" ,"Ocak", "Şubat"}, {"Mart", "Nisan", "Mayıs"}, {"Haziran", "Temmuz", "Ağustos"}, {"Eylül", "Ekim", "Kasım"} };
        String ay = "Temmuz";
        label:  for (int j = 0; j < aylars.length; j++) {
            String[] newArr = aylars[j];
            for (int k = 0; k < newArr.length; k++) {
                String item = newArr[k];
                if ( ay.equals(item) ) {
                    System.out.println( sections[j] );
                    break label;
                }
                System.out.println("---Call---");
            }
        }

        String name = "Ali";
        String namex = "Ali";
        System.out.println( name.hashCode() );
        System.out.println( namex.hashCode() );


        // break
        for (int j = 0; j < 10; j++) {
            if (j == 2) {
                continue;
            }
            if (j == 5) {
                break;
            }
            System.out.println("for loop : " + j);
        }



    }
}
