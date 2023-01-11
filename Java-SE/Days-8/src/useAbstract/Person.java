package useAbstract;

public class Person extends Customer{

    int cusNumber = 0;
    public Person( int cusNumber ) {
        this.cusNumber = cusNumber;
    }

    @Override
    public int customerNumber() {
        return cusNumber;
    }

}
