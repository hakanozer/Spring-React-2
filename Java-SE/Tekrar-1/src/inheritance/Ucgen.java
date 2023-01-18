package inheritance;

public class Ucgen extends Draw{

    public Ucgen() {
        super(30);
    }

    @Override
    public void ciz() {
        pixel("Üçgen", 5,6);
    }
}
