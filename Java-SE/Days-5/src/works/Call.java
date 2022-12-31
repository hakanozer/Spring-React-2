package works;

public class Call {

    int status = 0;
    double a, b, c = 0;
    public Call( int a, int b ) {
        status = 1;
        this.a = a;
        this.b = b;
    }

    public Call(int a) {
        status = 2;
        this.a = a;
    }

    public Call(double c) {
        status = 3;
        this.c = c;
    }

    public double action( ) {
        double end = 0;
        switch (status) {
            case 1:
                end = a + b;
            break;
            case 2:
                end = a * a;
            break;
            case 3:
                end = 3.14 * (c * c);
            break;
        }
        return end;
    }

}
