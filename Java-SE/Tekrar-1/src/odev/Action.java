package odev;

public abstract class Action {

    abstract int getParam();

    public boolean hesaplama() {
        int getprm = getParam();
        if (getprm <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(getprm); i++) {
            if (getprm % i == 0) {
                return false;
            }
        }
        return true;
    }


}
