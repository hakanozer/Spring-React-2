package overLoad;

public class Action {

    public int call() {
        return 0;
    }

    public int call(int num1) {
        return num1 + 50;
    }

    public int call(byte num1) {
        return num1 + 10;
    }

    public double call(float num1) {
        return num1 + 10;
    }

    public double call(double num1) {
        return num1 + 99;
    }

}
