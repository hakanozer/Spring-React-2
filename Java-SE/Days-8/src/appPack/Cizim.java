package appPack;

public class Cizim {

    int border = 0;

    public Cizim() {
        System.out.println("Cizim Call");
    }

    public Cizim( int border ) {
        System.out.println("Cizim Border : " + border);
        this.border = border;
    }

    public void ciz() {
        cizimYap("");
    }

    public void cizimYap(String status) {
        System.out.println(status + " Çizim Yapıldı - Border: " + border);
    }

}
