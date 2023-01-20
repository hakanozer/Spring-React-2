package Soru4;

public class LongSum {

    public static long longSum(long num){
        long sum = 0;
        while( num != 0){
            sum += num%10;
            num = num/10;
        }
        return sum;
    }
}
