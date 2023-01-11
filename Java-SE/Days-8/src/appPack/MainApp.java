package appPack;

public class MainApp {

    public static void main(String[] args) {

        Kare kare = new Kare(3);
        Cember cember = new Cember();
        Ucgen ucgen = new Ucgen();

        call(kare);
        call(cember);
        call(ucgen);


    }

    public static void call( Cizim cizim ) {
        cizim.ciz();
        if( cizim instanceof Kare ) {
            Kare kare = (Kare) cizim;
            kare.action(10);
            System.out.println(kare.width);
        }
    }

}
