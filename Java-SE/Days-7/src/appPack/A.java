package appPack;

public class A extends Base {

    public A() {
        System.out.println("A Call");
    }

    @Override
    public void action(int num1, int num2) {
        int end = num1 + num2;
        write(end);
    }

    public void read()  {
        System.out.println("Read Call");
    }

}
