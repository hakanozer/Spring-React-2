package works;

public class MainMethod {
    public static void main(String[] args) {

        // Nesne Üretimi
        Action obj = new Action();
        System.out.println( obj.age );

        // Function Call
        obj.noParameter();

        // no Return Call
        obj.noReturn("Ali", 30);

        // return fnc
        int count = obj.size("Bugün günlerden JAVA");
        System.out.println(count);
        if ( obj.size("Fenerbahçe") >= 10 ) {
            System.out.println("Şampiyon Fenerbahçe");
        }

        // Array func Call
        Object[] arr = {10, "Java", true, "React", "Full", 10.5, "Stack"};
        String data = obj.arrFunc(arr);
        System.out.println(data);

        // All Params func Call
        String address = obj.addressLines("İzmir", "Hatay", "no: 2");
        System.out.println(address);

        // Object use
        Settings settings = new Settings();
        String name = obj.useSetting(settings);
        System.out.println(name);

    }
}
