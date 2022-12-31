package overLoad;

public class MainOverLoad {

    public static void main(String[] args) {

        int age = 30;
        String name = "Erkan";
        float num1 = 10.5f;
        Object obj = 50.6;

        String cStr = ""+num1;
        String cStirng = String.valueOf(age);

        Action action = new Action();
        byte num = 10;
        double end = action.call(10);

        end = action.call(10.5f);

        System.out.println( end );

    }

}
