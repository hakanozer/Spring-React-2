package odev;

public class MainApp {
    public static void main(String[] args) {

        Call call = new Call();
        boolean status = call.hesaplama();
        System.out.println( "Status : " + status );
    }
}
