package Soru9;

public class IsIncludesInteger {

    public static boolean isIncludesInteger(int[] arr, int num){
        for (int k= 0; k < arr.length; k++){
            if (num == arr[k]){
                return true;
            }
        }
        return false;
    }
}
