package works;

public class MainApp {
    public static void main(String[] args) {

        Action ac = new Action();
        //System.out.println(ac.data);
        //ac.count();

        //Action action = new Action("Spring Java");
        //action.count();

        Call call = new Call(12.5);
        double end = call.action();
        System.out.println( "End : " + end );
    }


    // bir sınıf
    // Call
    // Call call = new Call(40, 50)
    // call.action() -> topla
    // Call call = new Call(50)
    // call.action() -> karesini al
    // Call call = new Call(5.6)
    // call.action() -> dairenin alanı al

}
