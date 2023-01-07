package appPack;

public class MainApp {
    public static void main(String[] args) {

        // Miras - Kalıtım - Inheritance
        // Bir sınıfın farklı bir sınıfa özellik ve genetik davranışlarını aktarması durumudur.
        // Javada Miras bir class içerisine aynı anda sadece farklı bir class ile bir sefer atanabilir.
        // Mirası veren sınıf nesne halinde oluşup mirası verebilir.
        // extends anahtar kelimesi ile miras verilmiş olur.
        // Mirası alan sınıf mirası veren sınıfın içindeki methodları değiştirebilir(Override)
        // Mirası alan sınıf mirası veren sınıf gibi davranış sergiler.

        Base a = new A();
        Base b = new B();
        Base c = new C();

        call(a);
        call(b);
        call(c);

    }

    public static void call( Base base ) {
        base.action(10, 30);
    }

}
