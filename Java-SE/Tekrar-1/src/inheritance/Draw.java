package inheritance;

public class Draw {

    public Draw( int a ) { }

    public void ciz() { }

    public final void pixel( String name,  int x, int y ) {
        System.out.println(name +": x : " + " y : " + y);
    }

    public static  void call(){
        System.out.println("Call Line");
    }

    private void sum() {
        String name = "";
    }


}
