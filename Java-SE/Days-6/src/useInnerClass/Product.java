package useInnerClass;

public class Product {

    // inner - dahili sınıflar
    // class içerisinde class oluşturmak için kullanılır
    int num1 = 30;

    public class Inner {
        int num2 = 40;
        public Inner() {
            System.out.println("num1 : " + num1);
        }
    }

    public class Innerx {
        int num2 = 40;
        public Innerx() {
            System.out.println("num1 : " + num1);
        }
    }

}
