package works;

public class Action {

    int age = 30;

    // No Parameter ve No Return
    // void -> retur'nün olmadığını ifade eder
    // Fonk isimleri -> yaptığı işe uygun olacak şeklilde isimlendirilmelidir.
    public void noParameter() {
        System.out.println("noParameter Call");
    }

    // No Return

    /**
     * @deprecated
     * @param data
     * @param age
     */
    public void noReturn( String data, int age ) {
        System.out.println( data + " : " + age );
    }

    // Return
    public int size( String data ) {
        return data.length();
    }

    // Array Parameter Func
    public String arrFunc( Object[] objects ) {
        String data = "";
        for ( Object item : objects ) {
            if ( item instanceof String ) {
                String str = String.valueOf(item);
                data += str + " ";
            }
        }
        return data;
    }


    // All Params
    /**
     * Kullanıcıdan gelen adres satırlarının eklenerek yazılmasını sağlar.
     * @param  arr String...
     * @return String
     */
    public String addressLines( String... arr ) {
        String data = "";
        for ( String item : arr ) {
            data += item + " ";
        }
        return data;
    }


    // Object func
    public String useSetting( Settings settings ) {
        String name = settings.profileName(10);
        return  name;
    }

}
