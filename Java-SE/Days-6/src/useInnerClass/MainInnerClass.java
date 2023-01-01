package useInnerClass;

public class MainInnerClass {

    public static void main(String[] args) {

        Product product = new Product();
        System.out.println( product.num1 );
        Product.Inner inner = product.new Inner();
        System.out.println( inner.num2 );

    }

}
