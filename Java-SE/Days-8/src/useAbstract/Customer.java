package useAbstract;

public abstract class Customer {

    public abstract int customerNumber();

    public int total() {
        int number = customerNumber();
        if ( number == 100 ) {
            return 100000;
        }else if ( number == 200 ) {
            return 200000;
        }
        return 0;
    }

    public String customerName() {
        int number = customerNumber();
        if ( number == 100 ) {
            return "Ali Bilmem";
        }else if ( number == 200 ) {
            return "Zehra Bilsin";
        }
        return "";
    }


}
