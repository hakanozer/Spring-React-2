package product;

import works.Action;

public class MainProduct {

    public static void main(String[] args) {

        Action action = new Action();
        System.out.println( action.name );

        MainProduct product = new MainProduct();
        product.runCall();

    }

    public void runCall() {
        System.out.println("runCall Call");
    }

}
