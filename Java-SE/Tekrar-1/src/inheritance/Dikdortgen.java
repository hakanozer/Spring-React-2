package inheritance;

public class Dikdortgen extends Draw{

    public Dikdortgen() {
        super(20);
    }

    @Override
    public void ciz() {
        pixel("Dikdörtgen", 10,5);
    }

}
