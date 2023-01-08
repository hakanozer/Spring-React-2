package useAbstract;

public class MainAbstract {
    public static void main(String[] args) {

        // Abstract Class'lar
        // İçerisinde hem gövdeli hemde gövdesiz methodlar kurulabililen sınıflardır.
        // Normal sınıf davranışları gösterirler
        // İçerisinde gövdesiz(Soyut) methodlar kurulmak istendiğinde abstract anahtar kelimesi kullanır.
        // Miras verildiğinde içindeki soyut methodlar override edilmek zorunda'dır.

        Person person = new Person(200);
        System.out.println( person.customerName() );

    }
}
