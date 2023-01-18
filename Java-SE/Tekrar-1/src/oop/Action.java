package oop;

final public class Action {

    // public
    // protected
    // private

    // final

    // default

    int a = 10;
    Settings settings = new Settings();

    public Action() {
        System.out.println("oop.Action Call :" + a);
    }

    public Action(int a) {
        this.a = a;
    }

    public Action(Settings settings) {
        a = settings.sum(50,70);
    }

    public int call() {
        return a * a;
    }


}
