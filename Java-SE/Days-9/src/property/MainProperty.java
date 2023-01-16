package property;

import java.util.ArrayList;

public class MainProperty {
    public static void main(String[] args) {

        ArrayList<String> ls = new ArrayList<>();
        ls.add("Product-1");
        ls.add("Product-2");
        ls.add("Product-3");
        ls.add("Product-4");
        ls.add("Product-5");
        ls.add("Product-6");

        for( String item : ls ) {
            System.out.println(item);
        }

        System.out.println("======================");

        Product product = new Product();
        product.setTitle("Ürün -1");
        product.setPrice(100);
        product.setForexBuy(110);
        product.setStar(4);

        System.out.println( product.getTitle() );
        System.out.println( product.getPrice() );
        System.out.println( product.getForexBuy() );
        System.out.println( product.getStar() );

        // Property for ArrayList
        ArrayList<Product> list = new ArrayList<>();

        Product p1 = new Product();
        p1.setStar(4);
        p1.setTitle("TV");
        p1.setPrice(10000);
        p1.setForexBuy(12500);
        list.add(p1);

        Product p2 = new Product();
        p2.setStar(3);
        p2.setTitle("Tablet");
        p2.setPrice(7000);
        p2.setForexBuy(8500);
        list.add(p2);

        Product p3 = new Product();
        p3.setStar(5);
        p3.setTitle("iPhone");
        p3.setPrice(27000);
        p3.setForexBuy(29500);
        list.add(p3);

        Product p4 = new Product("Samsung", 12000, 11200, 4);
        list.add(p4);

        ArrayList<String> images = new ArrayList<>();
        images.add("img-1.jpg");
        images.add("img-2.jpg");
        images.add("img-3.jpg");
        Product p5 = new Product("iMac", 77000, 76000, 5, images);
        list.add(p5);

        System.out.println("Size: " + list.size());
        for( Product item : list ) {
            System.out.println( item );
        }

    }
}
