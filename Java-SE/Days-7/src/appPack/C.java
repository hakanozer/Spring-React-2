package appPack;

public class C extends Base {

    @Override
    public void action(int num1, int num2) {
        int end = num1 + num2 + 10;
        write(end);
    }

}
