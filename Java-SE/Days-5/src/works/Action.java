package works;

public class Action {

    // Kurucu methodlar
    // Return Anahtar kelimesi almazlar
    // Void Anahtar kelimesi almazlar
    // Sınıf ismi ile aynı olmak zorundadırlar
    // Erişim belirteçleri alırlar
    // Methodları parametre alabilirler

    // kurulmasa bile default kurucu method vardır.
    // kurucu methodu yazmamamız durumunda default olan egale/iptal edilir.

    // Amaç
    // Bir sınıfın kurulurken farklı yeteneklere sahip olmasını sağlamak

    // this
    // kullanıldığı methodun sınıfını işaret eder

    // Oluşturma
    String data = "";
    int status = 40;
    Settings settings = new Settings();

    public Action() {
        //System.out.println("Defult Action Call");
        //read();
        //System.out.println("data : " + data);
    }


    public Action(String data) {
        System.out.println("Actiton Call: " + data);
        this.data = data;
    }

    public void count() {
        int age = 30;
        System.out.println( data.length() );
    }

    public void read() {
        System.out.println("Read Call");
    }

}
