package appPack;

public class MainApp {

    public static void main(String[] args) {

        Kare kare = new Kare();
        Cember cember = new Cember();
        Ucgen ucgen = new Ucgen();

        call(kare);
        call(cember);
        call(ucgen);

        System.out.println(kare);

    }

    public static void call( Cizim cizim ) {
        cizim.ciz();
    }

}
