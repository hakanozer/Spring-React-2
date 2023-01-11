package appPack;

public class B extends Base {

    @Override
    public void action(int num1, int num2) {
        int end = num2 - num1;
        write(end);
    }
}
