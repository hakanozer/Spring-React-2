package appPack;

public class Base implements Runnable {

    public Base() {
        System.out.println("Base Call");
    }

    public void action(int num1, int num2) {
        int end = num1 * num2;
        write(end);
    }

    public void write(int end) {
        System.out.println("Write Call : " + end);
    }

    @Override
    public void run() {
        System.out.println("Run Call");
    }
}
