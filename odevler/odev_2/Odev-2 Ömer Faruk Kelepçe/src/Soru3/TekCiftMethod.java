package Soru3;

public class TekCiftMethod {

    public double tekCiftKontrol(int n1, int n2){
        if (n1 % 2 == 1){
            return n1/n2;
        } else {
            return n1 % n2;
        }
    }
}
