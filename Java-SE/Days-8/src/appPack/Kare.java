package appPack;

public class Kare extends Cizim {

    int width = 100;

    public Kare(int kareBorder) {
        super(kareBorder);
        System.out.println("This Line : " + border);
    }

    @Override
    public void ciz() {
        cizimYap("Kare");
    }

    @Override
    public String toString() {
        return "Kare Class";
    }

    public void action( int i ) {
        if (i > 5) {
            ciz();
        }else {
            super.ciz();
        }
    }

}
