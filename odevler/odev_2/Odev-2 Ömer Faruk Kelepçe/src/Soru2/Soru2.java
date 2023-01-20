package Soru2;

public class Soru2 {

    public int sumOfTwoNumbers(int n1, int n2) {
        int total = 0;
        for (int i = n1 + 1; i <= n2 ; i++){
            total = total + i;
        }
        return total;
    }

}

