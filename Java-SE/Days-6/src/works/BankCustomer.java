package works;

import java.util.Random;

public class BankCustomer {

    // Static
    // Kullanımı için nesne üretimine ihtiyaç duymazlar.
    // Sınıfa ait olmak zorundadırlar.(Sınıfın gövdesi {} içerisinde kurulmalıdırlar.)
    // Değişkenler, Fonksiyonlar ve nesnelerde kullanılırlar.
    // Tetiklenmesi SınıfAdı.statisAdı şeklinde tetiklenirler.
    // Erişim belirteci alırlar.
    // Uygulama içinde her yerden erişime açıktırlar
    // Uygulama açık olduğu sürece ölmezler.
    // İçindeki değerler istenilen her yerde değiştirilebilir.
    static String name = "Erkan Bilsin";
    String city = "İstanbul";


    public String userName( long customerTC ) {
        Random random = new Random();
        String userName = "";
        if ( customerTC == 78266265068l ) {
            userName = "Ali Bilmem";
        }
        if ( customerTC == 38444326486l ) {
            userName = "Zehra Bilsin";
        }
        return userName;
    }


}
